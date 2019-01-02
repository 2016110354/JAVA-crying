package ru.zhao;

import java.io.FileInputStream;
import java.io.IOException;
/*
 * Author:zhaoru
 * Time:2018-12-20
 * Version:1-1
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
/*
 * Author:zhaoru
 * Time:2018-12-20
 * Version:1-1
 */
//按条件查询日记数据库类

public class SelectdiarySql {
	private Diary seDiary;

//	查询日记
	public static ArrayList<SelectDiaryshow> selectDiary(int i,String weather, String mood, String dates,String title,String content,String username){
		ArrayList<SelectDiaryshow> diarys = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	
		PreparedStatement ppsttm=null;
		try {
			// 1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			conn = getConnection();
			if (conn != null && !conn.isClosed()) {
				stmt = conn.createStatement();
				String sql  = null;
				if(i==1){
					sql = "select * from diary where uname='" + username + "' and weather ='" + weather+ "'";
					System.out.println(sql);
				}
				if(i==2){
					sql = "select * from diary where uname='" + username + "' and mood ='" + mood+ "'";
					System.out.println(sql);
				}
				if(i==3){
					sql = "select * from diary where uname='" + username + "' and dates ='" + dates+ "'";
					System.out.println(sql);
				}
				if(i==4) {
					sql = "select * from diary where uname='" + username + "' and tital ='" + title+ "'";
					System.out.println(sql);
				}
				if(i==5) {
					sql = "select * from diary where uname='" + username + "' and content ='" + content+ "'";
					System.out.println(sql);
				}
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					String d1 = rs.getString(1);
					String d2 = rs.getString(3);
					String d3 = rs.getString(4);
					String d5 = rs.getString(5);
					String d6 = rs.getString(6);
					SelectDiaryshow d = new SelectDiaryshow(d1,d2, d3, d5,d6);
					System.out.println(d);
					diarys.add(d);
//					diarys.add(new Diary((Date)rs.getObject(1),rs.getString(2),
//							rs.getString(5),rs.getString(6)));
					System.out.println(diarys);
				}
				return diarys;
			}
				else {
				System.out.println("数据库连接建立失败，请检查数据库设置！");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			// 4、关闭Statement和数据库连接
			if (null != stmt) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
		
	}


	
	//将连接的方法单独写在函数里面
	public static Connection getConnection() {
		Connection conn = null;
		//遍历查询结果集
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties properties = new Properties();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream("mysql2.properties");
				properties.load(fis);

				String host = properties.getProperty("host");
				String port = properties.getProperty("port");
				String database = properties.getProperty("database");
				String user = properties.getProperty("user");
				String password = properties.getProperty("password");

				if (database != null && user != null && password != null && host != null && port != null) {
					String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=utf-8";
					conn = DriverManager.getConnection(url, user, password);
					
			if(conn!= null && !conn.isClosed()) {
				System.out.println("Succeeded connection to the diary Database!");
			}
				}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
			}
			return conn;
		}
			
}
