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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

//用户登陆，找回密码、注册类
public class MySql {
	//判断登陆状态
	public static boolean isLog = false;
	//传入相应数据进行相应操作
	public static void sql(int n,Object obj,String name,String ans,String pwd) {
		//建立连接,建立连接
		Connection conn = null;
		//数据库查询语句
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties properties = new Properties();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream("mysql.properties");
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
				System.out.println("Succeeded connection to the Database!");
				if(n==1) {
					//创建statement类对象，用来执行sql语句
					Statement pstmt = null;
					pstmt = conn.createStatement();
					User newUser = (User) obj;
					//构建查询语句
					String sql="insert into user values('"+newUser.getUserName()+"','"+newUser.getUserShowname()+"','"+newUser.getUserPassword()+"','"+newUser.getUserMail()+"','"+newUser.getChoiceQuestion()+"','"+newUser.getUserAnswer()+"')";
					pstmt.executeUpdate(sql);
//					
					JOptionPane.showMessageDialog(null, "注册成功");
				}if(n==3) {
					//用户名验证方法
					PreparedStatement pstmt = null;
					String sql = "select * from user where uname=?";
					pstmt = conn.prepareStatement(sql);
					//给第一个问号赋值,将name赋值到第一个问好处
					pstmt.setString(1,name);
					//将查询结果存入结果集(name,password,emil,choice,answer)
					//结果集
					rs = pstmt.executeQuery();
					// ResultSet的游标下移，类似于Iterator，放在while循环里面做循环条件
					while(rs.next()) {
						//取出结果集中的密保答案answer
						String answer = rs.getString("answer");
						//判断用户输入是否相同
						if(answer.trim().equals(ans)) {
							PreparedStatement udp = null;
							//相同则跟新密码
							String upSql = "update user set pwd=? where uname=?";
							udp = conn.prepareStatement(upSql);
							//pwd赋值到第一个问好，name赋值到第二个问号
							udp.setString(1, pwd);
							udp.setString(2, name);
							udp.executeUpdate();
							JOptionPane.showMessageDialog(null, "修改成功");
						}else {
							JOptionPane.showMessageDialog(null, "密保答案错误");
						}
					}
					//用户登陆验证
				}if(n==4) {
					PreparedStatement pstmt = null;
					////创建prepareStatement类对象，用来执行sql语句
					String sql = "select * from user where uname=?";
					pstmt = conn.prepareStatement(sql);
					//将name赋值给uname
					pstmt.setString(1, name);
					//将查询结果存入结果集，所有的用户名
//					ResultSet rs2 = null;
					rs2 = pstmt.executeQuery();
					//判断用户是否注册
					if(!rs2.next())
						{
						JOptionPane.showMessageDialog(null, "您尚未注册");
						}
					//第一遍查询之后，将查询指针指向第一个数据继续查询
					rs2.previous();
					//遍历查询用户名匹配用户密码
					while(rs2.next()) {
						//提取用户名相对应的密码
						String getPwd = rs2.getString("pwd");
						//判断密码是否与数据库中保存的一致，若一致则登陆，反之提示错误
						if(getPwd.trim().equals(pwd)) {
							//登陆标签为true
							isLog = true;
//							new secondView().show();
							new WritedairyDialog(name).show();
						}else {
							JOptionPane.showMessageDialog(null, "密码错误");
						}
					}
					
				}
					
				//if n
			}//if conn
			
				}
		}catch (IOException e) {
				e.printStackTrace();
			}
		}catch(ClassNotFoundException e) {

			//数据库驱动类异常处理
			System.out.println("Sorry,connot find the Driver!");
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//.关闭rs、statement和connection，！！注意关闭顺序
			if(null != rs) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}if(null != rs2) {
				try {
					rs2.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}if(null != stmt) {
				try {
					stmt.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}if(null != conn) {
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
	
	
	
	

