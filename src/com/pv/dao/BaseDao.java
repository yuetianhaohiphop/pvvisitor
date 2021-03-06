package com.pv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseDao {

	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";// 定义MySql的驱动程序
	public static final String DBURL = "jdbc:mysql://localhost:3306/pvvisitor";// 定义连接地址
	public static final String DBUSER = "root";// 定义用户名
	public static final String DBPASS = "root";// 定义密码
	Connection conn = null;// 数据库连接
	Statement stmt = null;// 数据操作
	private  static BaseDao instance = null;

	public void  dbGo(){
		
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e1) {
			System.out.println("加载驱动失败T_T");
		}
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			System.out.println("无法连接至数据库O.O");
		}
		
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e1) {
			System.out.println("创建statment失败！");
		}
	}
	
	public static BaseDao getInstance(){
		if(instance==null){
			instance = new BaseDao();
		}
		return instance;
	}
	
	public void dbClose(){
	
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("数据库链接conn关闭失败！");
				}
		
	}
	
	public boolean add(String addSql) throws ClassNotFoundException{
		dbGo();	
		boolean isInsert = false;
		 try {
			stmt.execute(addSql);
			isInsert = true; 
		} catch (SQLException e) {
			System.out.println("******************");
			System.out.println("添加失败！错误的sql语句是："+addSql);
			System.out.println("******************");
			 isInsert = false;
		}
		 
		 return isInsert;
	}
	
	public ResultSet select(String selectSql) throws ClassNotFoundException{
		dbGo();
		ResultSet rs=null;
	
		try {
			rs = stmt.executeQuery(selectSql);
		} catch (SQLException e) {
			System.out.println("******************");
			System.out.println("查询失败！错误的sql语句是："+selectSql);
			System.out.println("******************");	
		}
		
	
		return rs; 
	}
	
	
	public void insert(String sql) throws SQLException{
		dbGo();
		
			stmt.execute(sql);
	
	}
	
}
