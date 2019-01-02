package ru.zhao;
/*
 * Author:zhaoru
 * Time:2018-12-20
 * Version:1-1
 */


import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
//日记添加、删除、查询、跟新、数据库类
public class DiarySql {

	//添加日记
	public static void addDiary(Connection conn,Diary diary,String newWeather,String newMood) {
	//数据库查询语句
	Statement stmt = null;
	try {
		stmt = conn.createStatement();
		String sqlStr = "insert into diary values('"+diary.getDate().toString()+"','"+diary.getUname()+"','"+ newWeather +"','"+ newMood +"','"+diary.getTitle()+"','"+diary.getContent()+"')";
		//查询语句
		stmt.executeUpdate(sqlStr);
		JOptionPane.showMessageDialog(null, "添加成功");
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		if(stmt!=null) {
			try {
				// 记得完成一次数据库操作之后，一定要关闭Statement
				stmt.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}if(null!=conn) {
				try {
					conn.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
}
	//删除日记
	public static void deleteDiary(Date myDate,String uname) {
		String dates = myDate.toString();
		PreparedStatement pstmt = null;
		Connection conn = getConnection();
		try {
			String sql = "delete from diary where dates = ? and uname = ?";
			//传递sql语句
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dates);
			pstmt.setString(2, uname);
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "日记已删除");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//清空日记da
	public static void clearDiary(String uname) {
		PreparedStatement pstmt = null;
		Connection conn = getConnection();
		try {
			String sql = "delete from diary where uname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,uname);
//			System.out.println(pstmt.toString());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "日记已清空");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//更新日记
	
	public static void updateDiary(Date date,String uname,String content) {
		String dates = date.toString();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update diary set content = ? where uname = ? and dates = ?";
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dates);
		System.out.println(uname);
		System.out.println(content);
		try {
			pstmt.setString(1, content);
			pstmt.setString(2, uname);
			pstmt.setString(3, dates);
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "更新日记成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

