package ru.zhao.second;
import java.util.InputMismatchException;
/*
 * Auther:赵茹
 * Date:2018-10-2
 * Version:1.0
 *  */
import java.util.Scanner;

import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;
public class Menu {
	//static boolean loginFlag = false;
	static User users = new User();
    public static void mainMenu() {
		//Scanner input=new Scanner(System.in);
    	 mainMenuPrint();
    	 Boolean hasError = true;
		while(true) {
			try {
				Scanner input=new Scanner(System.in);
					   System.out.println("************************");
					   int  b=input.nextInt();
					   switch(b){
					   case 1:
						    users.showAnnotaion();
							int m = input.nextInt();
						   switch(m) {
						  //注册
						   case 1:
							   users.userRegister();
							   users.userPrint();
							   users.showAnnotaion();
							   m = input.nextInt();
						   //登陆
						   case 2:
							   users.login();
							   mainMenu();
							   break;
						   //找回密码
						   case 3:
							   users.backPassword(); 
							   break;
					   	   case 4:
					   		   break;
					   	   default:
					   		   break;
						   }
						   break;
					   //写备忘录					   
					  case 3:
						   if(users.loginFlag == false) {
							   System.out.println("用户未登录，请先登录。"); 
							   mainMenu();
						   }else {
							   writeDiary();
						   }
						   mainMenu();
						   break;
					
					   case 2:
		               case 4:
		               case 5:   
					       noAnnotaion();
					       break;
					   case 6:
						    input.close();
				            return;
				        
					   }
				break;	
			}catch(Exception e) {
				System.out.println("输入错误(请输入整数），请按主菜单选择重新输入！！！");
     }
	}
     }
     
	
public static void showLoginMenu(){
	System.out.println("****欢迎进入水滴清单！****");
	System.out.println("1.登录系统");
	System.out.println("2.退出");
}
public static void  showMainMenu(){
	System.out.println( "1.登陆方式:");
	System.out.println( "2.系统设置:");
	System.out.println( "3.备忘写录:");
	System.out.println( "4.查找备忘录:");
	System.out.println( "5.备忘录分类:");
	System.out.println( "6.退出系统:");
}

public static void showManyMenu(){
	System.out.println("正在执行某功能！");
}
public static void noAnnotaion() {
		System.out.println("用户未登陆，请先登陆！");
}
public static void showFindMenu(){
	System.out.println("1.按日期查找:");
	System.out.println("2.按分组查找:");
	System.out.println("3.按标签查找:");
	System.out.println("4.按提醒日期查找:");
	System.out.println("5.返回上一层菜单:");
}

public static void showBybMenu() {
	System.out.println("谢谢使用，再见！");
}
private static void mainMenuPrint() {//主菜单栏

	if(users.loginFlag == false) {
		System.out.println("1.登录系统;");
	}else {
		System.out.println("1.["+users.getshowName()+"]退出登录;");

	}
	System.out.println("2.系统设置;");
	System.out.println("3.写日记;");
	System.out.println("4.查找日记;");
	System.out.println("5.退出系统;");
	System.out.println("请选择：");
}
public static void writeDiary() {
	while(true) {
		Weather weather = Diary.InputWeather();
		Mood mood = Diary.InputMood();
		String date = Diary.InputDate();
		String title = Diary.InputTitle();
		String content = Diary.InputContent();
		Scanner in = new Scanner(System.in);
		System.out.println("是否提交(y/n)?");
		if(in.nextLine().equals("y")) {
			Diary diary =new Diary(date,weather,mood,title,content); 
			users.addDiary(diary);
		}else {
			System.out.println("未提交");
		}	
		System.out.println("是否继续写日记(y/n)");
		if(in.nextLine().equals("y")) {
		}else {
			break;
		}	
	}
}
public static void main(String[] args) {
	mainMenu();
}

}
		 
