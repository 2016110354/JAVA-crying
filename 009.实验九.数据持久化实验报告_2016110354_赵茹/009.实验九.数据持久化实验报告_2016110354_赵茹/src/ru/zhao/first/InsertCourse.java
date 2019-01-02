package ru.zhao.first;
/*
 * Author:zhaoru
 * Time:2018-12-28
 * Version:1-1
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class InsertCourse {
	//添加课程数据库
	public static void addCourse(Connection conn,StudentCourse course) {
		PreparedStatement psstmt = null;
		try {
			String sqlStr = "insert into course(cursno,name,credit) values (?,?,?)";
			psstmt = conn.prepareStatement(sqlStr);
			psstmt.setString(1, course.getCursNo());
			psstmt.setString(2, course.getName());
			psstmt.setInt(3, course.getCredit());
			psstmt.executeUpdate();
			System.out.println("添加课程信息成功！");
		} catch (SQLException e) {
			e.printStackTrace();
			// 记得完成一次数据库操作之后，一定要关闭Statement
		} finally { 
			if (psstmt != null) {
				try {
					psstmt.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//添加课程主函数提示
	public InsertCourse() {
		Connection conn = Connect.getConnection();
		int num = 0;
		if (conn != null) {
			String cursno = "";
			String name = "";
			int credit = 0;
			Scanner input = new Scanner(System.in);
			System.out.println("请输入需要添加的课程门数：");
			try {
			num = input.nextInt();
			input.nextLine();
			for(int i = 0; i < num; i++) {
				System.out.println("请输入课程编号：");
				cursno = input.nextLine();
				System.out.println("请输入课程名称：");
				name = input.nextLine();
				System.out.println("请输入学分：");
				credit = input.nextInt();
				if(credit < 0 || credit > 5) {
					System.out.println("请输入0-5之间的数字");
					credit = input.nextInt();
					break;
				}
				StudentCourse course = new StudentCourse(cursno,name,credit);
				if (course!= null) {
					addCourse(conn, course);
				}
			}
			// 关闭所使用的资源
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//input.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("输入格式错误，请重新输入");
			input = new Scanner(System.in);
		}
		}else {
			System.out.println("数据库连接建立失败，请检查！");
				}
			}

}
