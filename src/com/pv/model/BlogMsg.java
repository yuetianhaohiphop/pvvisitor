package com.pv.model;

public class BlogMsg {
	private int id;
	private String username;
	private String articleNumber;
	private int pv_times;
	private String article_title;
	private int isPapered;//该博文 是否 处于 被选中增加的状态
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getArticleNumber() {
		return articleNumber;
	}
	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}
	public int getPv_times() {
		return pv_times;
	}
	public void setPv_times(int pv_times) {
		this.pv_times = pv_times;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public int getIsPapered() {
		return isPapered;
	}
	public void setIsPapered(int isPapered) {
		this.isPapered = isPapered;
	}
	
	
}
