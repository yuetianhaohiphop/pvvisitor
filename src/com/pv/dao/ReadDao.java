package com.pv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pv.model.BlogMsg;

public class ReadDao {
	
	BaseDao bd = new BaseDao() ;
	
	public List<BlogMsg> select() throws SQLException{
		ResultSet rs;
		String selectSql  =  "select * from blog_info";
		try {
		 rs=bd.select(selectSql);
		 if(rs.next()){
			 List<BlogMsg> resultList = this.resultSetTransToList(rs);
			 return resultList;
		 	}
		} catch (ClassNotFoundException e) {
			System.out.println("ReadDao未找到:"+selectSql+"");
		}
		return null;
	}
	
	//这个应该提到服务层 ，将取出的数据，包装到一个List中
	public List<BlogMsg> resultSetTransToList(ResultSet rs) throws SQLException{
		rs.beforeFirst();
		List<BlogMsg> resultList = new ArrayList<BlogMsg>();
		while(rs.next()){
			BlogMsg u = new BlogMsg();
			u.setId(rs.getInt("id"));
			u.setArticle_title(rs.getString("article_title"));
			u.setArticleNumber(rs.getString("articleNumber"));
			u.setIsPapered(rs.getInt("isPapered"));
			u.setPv_times(rs.getInt("pv_times"));
			u.setUsername(rs.getString("username"));
			resultList.add(u);
		}
		return resultList;
	}
}
