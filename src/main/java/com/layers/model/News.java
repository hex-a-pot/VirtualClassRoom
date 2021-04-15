package com.layers.model;

public class News {

	private long newsId;
	private String todayNews;

	News() {
		super();
	}
	public News(long newsId, String news) {
		this.newsId = newsId;
		this.todayNews = news;
	}

	public News(String news) {
		this.todayNews = news;
	}

	public long getNewsId() {
		return newsId;
	}

	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}

	public String getNews() {
		return todayNews;
	}

	public void setNews(String news) {
		this.todayNews = news;
	}

}
