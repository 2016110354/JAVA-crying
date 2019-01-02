package ru.zhao.first;
/*
 * Author:zhaoru
 * Time:2018-12-28
 * Version:1-1
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class InsertStudent {
	//添加学生数据库
	public static void addStudent(Connection conn, Student student) {
		PreparedStatement psstmt = null;
		try {
			String sqlStr = "insert into student(stdno,name,sex,birthday,password) values (?,?,?,?,?)";
			psstmt = conn.prepareStatement(sqlStr);
			psstmt.setString(1, student.getstdNo());
			psstmt.setString(2, student.getName());
			psstmt.setString(3, student.getSex());
			psstmt.setString(4, student.getBirth());
			psstmt.setString(5, student.getPassword());
			psstmt.executeUpdate();
			System.out.println("添加学生信息成功！");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 必须放在finally模块中执行
			if (psstmt != null) {
				try {
					psstmt.close(); // 记得完成一次数据库操作之后，一定要关闭Statement
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//查询学生选课信息
	public static boolean stuQuery(Connection conn,String stdno) {
		ResultSet stu_rs = null;
		PreparedStatement psstmt = null;
		try {
			String sqlStr = "select * from student where stdno= ? ";
			psstmt = conn.prepareStatement(sqlStr);
			psstmt.setString(1, stdno);
			stu_rs = psstmt.executeQuery();
			//判断是否存在记录  
			if (stu_rs.next()) {  
				return true;
			}
			else{
				return false;
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
		return false;
	}
	//添加学生主函数提示
	public InsertStudent() {
		Connection conn = Connect.getConnection();
		int num = 0;
		if (conn != null) {
			String stdno = "";
			String name = "";
			String sex = "";
			String birth = "";
			String password = "";
			Scanner input = new Scanner(System.in);
			System.out.println("请输入需要添加的学生人数：");
			try {
			num = input.nextInt();
			input.nextLine();
			for(int i = 0; i < num; i++) {
				do{
					System.out.println("请输入学生学号(示例：2018001)：");
					stdno = input.nextLine();
					if(stuQuery(conn,stdno)) {
						System.out.println("该学号已存在，请重新输入！");
					}
					//判断学号是否输入正确
					if(!confirmNo(stdno)) {
						System.out.println("输入格式错误，请重新输入");
						stdno = input.nextLine();
					}
				}while(stuQuery(conn,stdno));
				System.out.println("请输入学生姓名：");
				name = input.nextLine();
				//判断姓名不能全是数字
				if(confirmNo(name)) {
					System.out.println("输入格式错误，请重新输入");
					name = input.nextLine();
				}
				System.out.println("请输入学生性别(female/male)：");
				sex = input.nextLine();
				//判断性别输入是否正确
				if(!confirmGender(sex)) {
					System.out.println("输入格式错误，请重新输入");
					sex = input.nextLine();
				}
				do{
					System.out.println("请输入学生出生日期：");
					birth = input.nextLine();
					new Date(birth);
				}while(!Date.isDate);
				System.out.println("请输入学生密码：");
				password = input.nextLine();
				Student student = new Student(stdno,name,sex,birth,password);
				if (student!= null) {
					addStudent(conn, student);
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
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("输入格式错误，请重新输入!");
			input = new Scanner(System.in);
		}
		}else {
			System.out.println("数据库连接建立失败，请检查！");
			}
		}
	
	public  boolean confirmNo(String no) {
		if(no.matches("\\d{0,}")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean confirmGender(String gender) {
		if(gender.equals("female")||gender.equals("male")) {
			return true;
		} else {
			return false;
		}
	}
	

}
