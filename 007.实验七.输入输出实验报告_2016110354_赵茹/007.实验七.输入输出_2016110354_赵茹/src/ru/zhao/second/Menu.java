package ru.zhao.second;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
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
	
	public static void main(String[] args) {
		mainMenu();
	}
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
						   loginMethod();
						   break;
					   //写备忘录					   
					   case 3:
						  writeMethond();
						   mainMenu();
						   break;
					   case 2:
		               case 4:
		            	   findDiary();
		            	   break;
		               case 5:   
					       noAnnotaion();
					       mainMenu();
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
	public static void mainMenuPrint() {//主菜单栏
	
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
	public static int count=0;
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
				System.out.println(diary);
				users.addDiary(diary);
				count++;
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
	//查看日记功能
	private static  void findDiary() {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		if(users.loginFlag==true) {
		int inputNumber = 0;
		String inputString = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		findDiaryMenuPrint();
		while(true) {
			try {
				int choice =input.nextInt();
				if(choice>=1&&choice<=2) {	
					switch (choice) {
					case 1:
						//查看日记
						users.dateSort();//对该用户的已经存储的日记进行排序
						for(int i=0;i<users.diary.size();i++){
							System.out.println( "日记" + i+":" + "Date:" + users.diary.get(i).date.getDate()+"    Title:"+users.diary.get(i).title);
						}
						//选择用户想要查看的日记的序号
						System.out.println("请输入你想要查看日记的序号：");
								inputString = br.readLine();
								inputNumber = Integer.parseInt(inputString);
									 if(inputNumber>users.diary.size()||inputNumber<0){
										 System.out.println("您想找的日记不存在，请重新输入序号：");
										 		inputNumber = Integer.parseInt(inputString); 
								 }
									 else
									 {
										//显示输出选择日记的内容
										 System.out.println("content："+users.diary.get(inputNumber).content);
											findDiary();
										 break;
									 }
						break;
			case 2:
				mainMenu();
				break;
		    	}
				}else {
				  System.out.println("请输入1-2的整数");
				  findDiary();
				}
			}catch(Exception e) {
				System.out.println("输入错误(请输入整数），请按主菜单选择重新输入！！！");
		     } 
		}
	}else {
		System.out.println("用户未登录，请先登录!");
		mainMenu();
	}
}
		//查找日记菜单栏
		public static void findDiaryMenuPrint() {
			System.out.println("1.查看日记列表");
			System.out.println("2.返回上一层菜单");
			System.out.println("请选择：");
		}
	//二级菜单登陆方法
	public static void loginMethod()
	{
		users.showAnnotaion();
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		while(true) {
			try {
				if(m>=1&&m<=4) {
					switch(m) {
					case 1:
					  users.userRegister();
					  users.userPrint();
					  users.showAnnotaion();
					  m = input.nextInt();
					  break;
					case 2:
						users.login();
						mainMenu();
					    break;
					case 3:
						users.backPassword();
						break;
					case 4:
						mainMenu();
						break;
					default:
						break;
					}
				}else {
					System.out.println("请输入1-4的整数！");
					break;
				}
			
		}catch(Exception e) {
			System.out.println("输入错误(请输入整数），请按主菜单选择重新输入！！！");
	     } 
		}
	}
	
	//二级菜单写日记
	public static void writeMethond() {
		if(User.loginFlag == false) {
			System.out.println("用户未登陆,请先登录!");
			mainMenu();
		}else {
			writeDiary();
		}
	}
	
	}
		 
