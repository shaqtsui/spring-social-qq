package net.gplatform.spring.social.qq.connect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.FormMapHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class QQOAuth2Template extends OAuth2Template {

	private static final Log logger = LogFactory.getLog(QQOAuth2Template.class.getName());

	public QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
		super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
	}

	@Override
	protected RestTemplate createRestTemplate() {
		RestTemplate restTemplate =super.createRestTemplate();
		
		HttpMessageConverter<?> messageConverter = new FormMapHttpMessageConverter() {
			@Override
			public boolean canRead(Class<?> clazz, MediaType mediaType) {
				boolean result = false;
				if(mediaType == null){
					return result;
				}
				result = MediaType.TEXT_HTML.isCompatibleWith(mediaType);
				return result;
			}
		};
		
		restTemplate.getMessageConverters().add(messageConverter);

		return restTemplate;
	}

}
