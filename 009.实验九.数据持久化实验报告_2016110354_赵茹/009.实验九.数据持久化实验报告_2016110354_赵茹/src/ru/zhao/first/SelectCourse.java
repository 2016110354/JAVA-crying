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
import java.sql.Statement;
import java.util.Scanner;


public class SelectCourse {
	//定义接受学号
	static String stdno;
	//定义接受密码
	static String passwd;
	//定义学生密码
	static String password;
	//定义学生选课
	static String cursno;
	//密码是否正确
	static boolean isPasswd = false;
	//学生是否存在
	static boolean isStdno = false;
	//数据库连接
	static Connection conn = Connect.getConnection();
	
	//选课
	public static void select() {
		Scanner input = new Scanner(System.in);
		do{
			System.out.println("请输入学生学号：");
			stdno = input.nextLine();
			stuQuery(conn,stdno);
			if(isStdno) {
				do{
					System.out.println("请输入密码：");
					passwd = input.nextLine();
					if(passwd.equals(password)) {
						isPasswd = true;
						System.out.println("开始选课！");
						String select = "";
						do{
							courseQuery(conn);
							System.out.println("请输入所选课的课程编号（输入-1退出选课）：");
							select = input.nextLine();
							String cursno = select;
							if(!select.equals("-1")){
								StudentSC sc = new StudentSC(stdno,cursno);
								if(selectCursQuery(conn,sc)) {
									System.out.println("已选择这门课，请重新选择课程！");
								}else{
									infoInsert(conn,sc);
								}
							}else{
								System.out.println("选课结束！");
							}
						}while(!select.equals("-1"));
					}else{
						System.out.println("密码错误，请重新输入！");
					}
				}while(!isPasswd);
			}
			else{
				System.out.println("该学生不存在，请重新输入学号！");
			}
		}while(!isStdno);
		//input.close();
	}	
	//查询学生
	public static void stuQuery(Connection conn,String str) {
		ResultSet stu_rs = null;
		PreparedStatement psstmt = null;
		try {
			String sqlStr = "select * from student where stdno= ?";
			psstmt = conn.prepareStatement(sqlStr);
			psstmt.setString(1, str);
			stu_rs = psstmt.executeQuery();
			//判断是否存在记录  
			if (stu_rs.next()) {  
			    //有的话 先获取第一条记录 
				//Resultset的第一行的第一列都是空的，要用rs.next()到第一行才能进行读取
			     do{  
					isStdno = true;
					password = stu_rs.getString("password");//查询的学生存在，取出该学生的密码
			     } while(stu_rs.next()); 
			}
			else{
				isStdno = false;
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
	//查询课程
	public static void courseQuery(Connection conn) {
		Statement stmt = null;
		ResultSet course_rs = null;
		try {	
			if(conn != null && !conn.isClosed()) {
				//查询并输出信息
				stmt = conn.createStatement();
				course_rs = stmt.executeQuery("select * from course");
				System.out.println("课程编号\t课程名称\t学分");
				while (course_rs.next()) {		//ResultSet的游标下移，类似于Iterator
					System.out.print(course_rs.getString(1)+"\t");	//通过列号，!!列从1开始计数
					System.out.print(course_rs.getString("name")+"\t");//也可以通过列名
					System.out.print(course_rs.getString("credit")+"\n");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭rs、statement和connection，！！注意关闭顺序
			if (null != course_rs) {
				try {
					course_rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stmt) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//查询选课信息
	public static boolean selectCursQuery(Connection conn,StudentSC sc) {
		ResultSet stu_rs = null;
		PreparedStatement psstmt = null;
		try {
			String sqlStr = "select * from sc where stdno= ? and cursno= ?";
			psstmt = conn.prepareStatement(sqlStr);
			psstmt.setString(1, sc.getStdno());
			psstmt.setString(2, sc.getCursno());
			stu_rs = psstmt.executeQuery();
			//判断是否存在记录  
			if (stu_rs.next()) {  
			    //有的话 先获取第一条记录 
				//Resultset的第一行的第一列都是空的，要用rs.next()到第一行才能进行读取
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
	//插入信息
	public static void infoInsert(Connection conn, StudentSC sc) {
		PreparedStatement psstmt = null;
		try {
			String sqlStr = "insert into sc(stdno,cursno) values (?,?)";
			psstmt = conn.prepareStatement(sqlStr);
			psstmt.setString(1, sc.getStdno());
			psstmt.setString(2, sc.getCursno());
			psstmt.executeUpdate();
			System.out.println("添加选课信息成功！");

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
	public SelectCourse() {
		select();
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
