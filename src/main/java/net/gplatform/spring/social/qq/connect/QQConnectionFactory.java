/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.gplatform.spring.social.qq.connect;

import net.gplatform.spring.social.qq.api.QQ;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;


public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

	public QQConnectionFactory(String consumerKey, String consumerSecret) {
		super("weibo", new QQServiceProvider(consumerKey, consumerSecret), new QQAdapter());
	}

}
