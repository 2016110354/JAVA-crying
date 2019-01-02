package ru.zhao.first;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/*
 * Author:zhaoru
 * Time:2018-12-28
 * Version:1-1
 */

public class Query {
	//查询学生
		public static void query(Connection conn,String str) {
			ResultSet stu_rs = null;
			PreparedStatement psstmt = null;
			try {
				String sqlStr = "select * from student where stdno in("
						+ "select stdno from sc where cursno in ("
						+ "select cursno from sc where stdno = ?));";
				psstmt = conn.prepareStatement(sqlStr);
				psstmt.setString(1, str);
				stu_rs = psstmt.executeQuery();
				if (stu_rs.next()) {  
				    //有的话 先获取第一条记录 
					//Resultset的第一行的第一列都是空的，要用rs.next()到第一行才能进行读取
				     do{  
						System.out.print(stu_rs.getString(1)+"\t");
						System.out.print(stu_rs.getString(2)+"\t");
						System.out.print(stu_rs.getString(3)+"\t");
						System.out.print(stu_rs.getString(4)+"\t");
						System.out.print(stu_rs.getString(5)+"\n");
				     } while(stu_rs.next()); 
				}
				else{
					System.out.println("查询内容为空！");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//关闭rs、statement和connection，！！注意关闭顺序
				if (null != stu_rs) {
					try {
						stu_rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (null != psstmt) {
					try {
						psstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		public Query() {
			Scanner input = new Scanner(System.in);
			String stdno;
			Connection conn = Connect.getConnection();
			System.out.println("输入一个学生的学号，然后查找出所有选了该同学所选的任何一门课程的所有学生");
			stdno = input.nextLine();
			query(conn,stdno);
			// 关闭所使用的资源
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

}
