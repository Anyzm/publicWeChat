package com.anyzm.wechat.message.imp;
import com.anyzm.wechat.message.BaseMessage;

import java.util.List;

public class NewsMessage extends BaseMessage {
	private int ArticleCount;
	private List<News> Articles;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<News> getArticles() {
		return Articles;
	}
	public void setArticles(List<News> articles) {
		Articles = articles;
	}
}
