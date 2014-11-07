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
package net.gplatform.spring.social.qq.api;

import org.springframework.social.ApiBinding;

import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.api.weibo.Weibo;


public interface QQ extends ApiBinding {
	
	String getUserOpenID();

	UserInfo qzoneUserInfoOperations();
	
	com.qq.connect.api.weibo.UserInfo weiboUserInfoOperations();

	Weibo weiboOperations();
	
}
