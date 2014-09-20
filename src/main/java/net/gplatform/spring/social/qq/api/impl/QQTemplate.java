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
package net.gplatform.spring.social.qq.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.connect.api.OpenID;
import com.qq.connect.api.weibo.UserInfo;
import com.qq.connect.api.weibo.Weibo;

import net.gplatform.spring.social.qq.api.QQ;

public class QQTemplate implements QQ {
	private static final Logger LOG = LoggerFactory.getLogger(QQTemplate.class);

	private String accessToken;

	private String openID;

	private UserInfo userInfoOperations;
	private Weibo weiboOperations;

	public QQTemplate(String accessToken) {
		try {
			this.accessToken = accessToken;
			OpenID openIDObj = new OpenID(accessToken);
			openID = openIDObj.getUserOpenID();
			userInfoOperations = new UserInfo(accessToken, openID);
			weiboOperations = new Weibo(accessToken, openID);
		} catch (Exception e) {
			LOG.error("Can not create QQTemplate", e);
		}
	}


	@Override
	public boolean isAuthorized() {
		return accessToken != null;
	}

	@Override
	public UserInfo userInfoOperations() {
		return userInfoOperations;
	}

	@Override
	public Weibo weiboOperations() {
		return weiboOperations;
	}

}
