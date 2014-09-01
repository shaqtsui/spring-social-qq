package net.gplatform.spring.social.qq.autoconfig;

import net.gplatform.spring.social.qq.api.QQ;
import net.gplatform.spring.social.qq.connect.QQConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.GenericConnectionStatusView;
import org.springframework.web.servlet.View;

@Configuration
@ConditionalOnClass(value = { SocialConfigurerAdapter.class, QQConnectionFactory.class })
@ConditionalOnProperty(prefix = "spring.social.qq.", value = "app-id")
@AutoConfigureBefore(SocialWebAutoConfiguration.class)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class QQAutoConfiguration {

	@Configuration
	@EnableSocial
	@ConditionalOnWebApplication
	@ConditionalOnClass(value = { SocialConfigurerAdapter.class, QQConnectionFactory.class })
	protected static class QQAutoConfigurationAdapter extends SocialConfigurerAdapter implements EnvironmentAware {
		private static final Logger LOG = LoggerFactory.getLogger(QQAutoConfigurationAdapter.class);
		private RelaxedPropertyResolver properties;

		@Override
		public void addConnectionFactories(ConnectionFactoryConfigurer configurer, Environment environment) {
			configurer.addConnectionFactory(createConnectionFactory(this.properties));
		}

//		@Override
//		public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
//			return null;
//		}

		@Override
		public void setEnvironment(Environment environment) {
			this.properties = new RelaxedPropertyResolver(environment, getPropertyPrefix());
		}

		protected String getPropertyPrefix() {
			return "spring.social.qq.";
		}

		protected ConnectionFactory<?> createConnectionFactory(RelaxedPropertyResolver properties) {
			try {
				ConnectionFactory<QQ> factory = new QQConnectionFactory(properties.getRequiredProperty("app-id"),
						properties.getRequiredProperty("app-secret"));
				return factory;
			} catch (Exception e) {
				LOG.error("Error when createConnectionFactory", e);
				return null;
			}
		}

		@Bean
		@ConditionalOnMissingBean(QQ.class)
		@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
		public QQ qq(ConnectionRepository repository) {
			try {
				Connection<QQ> connection = repository.findPrimaryConnection(QQ.class);
				return connection != null ? connection.getApi() : null;
			} catch (Exception e) {
				LOG.error("Error when create qq api", e);
				return null;
			}
		}

		@Bean(name = { "connect/qqConnect", "connect/qqConnected" })
		@ConditionalOnProperty(prefix = "spring.social.", value = "auto-connection-views")
		public View qqConnectView() {
			return new GenericConnectionStatusView("qq", "qq");
		}
	}
}
