package ru.zhao.first;
/*
 * Author:zhaoru
 * Time:2018-12-28
 * Version:1-1
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection getConnection() {
		Connection conn = null;
		//驱动程序名
		String  driver = "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://localhost:3306/scores?characterEncoding=utf8";
		//MySQL配置时的用户名
		String user = "root";
		//MySQL配置时的密码
		String password = "root";
		//遍历查询结果集
		try {
			//加载驱动程序
			Class.forName(driver);
			//1.getConnection()方法，连接MySQL数据库!!
			conn = DriverManager.getConnection(url,user,password);
			if(conn!= null && !conn.isClosed()) {
				System.out.println("Succeeded connection to the diary Database!");
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
