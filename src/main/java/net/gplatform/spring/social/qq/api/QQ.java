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

import weibo4j.Account;
import weibo4j.Comments;
import weibo4j.Favorite;
import weibo4j.Friendships;
import weibo4j.Place;
import weibo4j.PublicService;
import weibo4j.Reminds;
import weibo4j.Search;
import weibo4j.ShortUrl;
import weibo4j.Suggestion;
import weibo4j.Tags;
import weibo4j.Timeline;
import weibo4j.Trend;
import weibo4j.Users;

public interface QQ extends ApiBinding {

	Account accountOperations();

	Comments commentsOperations();

	Favorite favoriteOperations();

	Friendships friendshipsOperations();

	Place placeOperations();

	PublicService publicServiceOperations();

	Reminds remindsOperations();

	Search searchOperations();

	ShortUrl shortUrlOperations();

	Suggestion suggestionOperations();

	Tags tagsOperations();

	Timeline timelineOperations();

	Trend trendOperations();

	Users usersOperations();
}
