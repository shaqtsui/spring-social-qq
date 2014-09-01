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

import net.gplatform.spring.social.qq.api.QQ;
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

public class QQTemplate implements QQ {
	private String accessToken;

	private Account accountOperations;
	private Comments commentsOperations;
	private Favorite favoriteOperations;
	private Friendships friendshipsOperations;
	private Place placeOperations;
	private PublicService publicServiceOperations;
	private Reminds remindsOperations;
	private Search searchOperations;
	private ShortUrl shortUrlOperations;
	private Suggestion suggestionOperations;
	private Tags tagsOperations;
	private Timeline timelineOperations;
	private Trend trendOperations;
	private Users usersOperations;

	public QQTemplate(String accessToken) {
		this.accessToken = accessToken;
		init();
	}

	private void init() {
		accountOperations = new Account();
		accountOperations.setToken(accessToken);
		commentsOperations = new Comments();
		commentsOperations.setToken(accessToken);
		favoriteOperations = new Favorite();
		favoriteOperations.setToken(accessToken);
		friendshipsOperations = new Friendships();
		friendshipsOperations.setToken(accessToken);
		placeOperations = new Place();
		placeOperations.setToken(accessToken);
		publicServiceOperations = new PublicService();
		publicServiceOperations.setToken(accessToken);
		remindsOperations = new Reminds();
		remindsOperations.setToken(accessToken);
		searchOperations = new Search();
		searchOperations.setToken(accessToken);
		shortUrlOperations = new ShortUrl();
		shortUrlOperations.setToken(accessToken);
		suggestionOperations = new Suggestion();
		suggestionOperations.setToken(accessToken);
		tagsOperations = new Tags();
		tagsOperations.setToken(accessToken);
		timelineOperations = new Timeline();
		timelineOperations.setToken(accessToken);
		trendOperations = new Trend();
		trendOperations.setToken(accessToken);
		usersOperations = new Users();
		usersOperations.setToken(accessToken);
	}

	@Override
	public boolean isAuthorized() {
		return accessToken != null;
	}

	@Override
	public Account accountOperations() {
		return accountOperations;
	}

	@Override
	public Comments commentsOperations() {
		return commentsOperations;
	}

	@Override
	public Favorite favoriteOperations() {
		return favoriteOperations;
	}

	@Override
	public Friendships friendshipsOperations() {
		return friendshipsOperations;
	}

	@Override
	public Place placeOperations() {
		return placeOperations;
	}

	@Override
	public PublicService publicServiceOperations() {
		return publicServiceOperations;
	}

	@Override
	public Reminds remindsOperations() {
		return remindsOperations;
	}

	@Override
	public Search searchOperations() {
		return searchOperations;
	}

	@Override
	public ShortUrl shortUrlOperations() {
		return shortUrlOperations;
	}

	@Override
	public Suggestion suggestionOperations() {
		return suggestionOperations;
	}

	@Override
	public Tags tagsOperations() {
		return tagsOperations;
	}

	@Override
	public Timeline timelineOperations() {
		return timelineOperations;
	}

	@Override
	public Trend trendOperations() {
		return trendOperations;
	}

	@Override
	public Users usersOperations() {
		return usersOperations;
	}

}
