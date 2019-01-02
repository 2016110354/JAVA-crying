package ru.zhao.first;
/*
 * Author:zhaoru
 * Time:2018-12-28
 * Version:1-1
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Connection conn = Connect.getConnection();
		int option = 0;
		do{
			System.out.println("1.添加学生");
			System.out.println("2.添加课程");
			System.out.println("3.选课");
			System.out.println("4.条件查询");
			System.out.println("-1.退出");
			System.out.println("请输入选择：");
			try {
			option = input.nextInt();
			input.nextLine();
			switch(option) {
			case 1:
				new InsertStudent();
				break;
			case 2:
				new InsertCourse();
				break;
			case 3:
				new SelectCourse();
				break;
			case 4:
				new Query();
				break;
			case -1:
				System.out.println("Bye");
				break;
			default:
				System.out.println("输入有误，请重新输入");
			}
		}catch (Exception e) {
				// TODO: handle exception
				System.out.println("请输入正确的格式!");
				input = new Scanner(System.in);
		}
		}while(option != -1);
		// 关闭所使用的资源
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		input.close();
	}

}
