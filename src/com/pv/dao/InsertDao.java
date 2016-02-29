package com.pv.dao;

import java.sql.SQLException;

import com.pv.model.BlogMsg;

public class InsertDao {
	BaseDao bd = new BaseDao() ;
	public void save(BlogMsg bs) throws SQLException{
		
		String article_title = bs.getArticle_title();
		String articleNumber =bs.getArticleNumber();
		int isPapered = bs.getIsPapered();
		int	pv_times = bs.getPv_times();
		String username = bs.getUsername();
		String sql = "insert blog_info(articleNumber,username,pv_times,article_title,isPapered) values('"+articleNumber+"','"+username+"',"+pv_times+",'"+article_title+"',"+isPapered+")";
		System.out.println("插入语句："+sql);
		bd.insert(sql);
	}
}
