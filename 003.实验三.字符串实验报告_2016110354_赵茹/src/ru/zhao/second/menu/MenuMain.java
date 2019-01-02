package ru.zhao.second.menu;
/*
 * Auther:赵茹
 * Date:2018-10-2
 * Version:1.0
 *  */



import java.util.Scanner;
public class MenuMain {
	public static void main(String[] args) {
		//创建菜单对象，引用方法
		MenuMethod meu=new MenuMethod();
		//登陆界面（登陆、退出）
		meu.showLoginMenu();
		//Scanner input=new Scanner(System.in);
		while(true) {
			try {
				Scanner input=new Scanner(System.in);
				System.out.println("请输入选择数字:");
				int n=input.nextInt();
				switch(n){
				
				   case 1:int b;
					   do {
						//主菜单（选择，退出）
					   meu.showMainMenu();
					   System.out.println("************************");
					   //System.out.print("请输入选择数字或按0返回上一级");
					   b=input.nextInt();
					   switch(b){
					   case 1:
						   int m;
						   do {
						   meu.showAnnotaion();
						   m=input.nextInt();
						   switch(m) {
						   case 1:
							   meu.userRegister();
							   meu.userPrint();
							   break;
						   case 2:
							   meu.login();
							   break;
						   case 3:
							   meu.backPassword(); 
							   break;
						   
					   	   case 4:
					   		   break;
						   }
						   }while(m!=0);
					   case 2:
					   case 3:
		               case 4:
		               case 5:   
					       meu.noAnnotaion();
					       break;
			               /*case 1:
			               case 2:
			               case 3:
			               case 5:
						int c;
						do {
							1,2,3,5菜单
			            	   meu.showManyMenu();
			            	   System.out.println("************************");
			            	   System.out.print("按0返回上一级:");
			            	   c=input.nextInt();
			               }while(c!=0);
		                   break;
			               case 4:
			               int s;
						   do {
			            	   meu.showFindMenu();
			            	   System.out.println("************************");
			                   System.out.print("请输入选择数字或按0返回上一级:");
			                   s=input.nextInt();
			                   switch(s) {
			                  case 1:
			                   case 2:
			                   case 3:
			                   case 4:
			                	   int a;
			                   do {
			                	   System.out.println("正在执行某功能！");
			                	   meu.showManyMenu();
			                	   System.out.println("************************");
			                	   System.out.print("按0返回上一级:");
			                	   a=input.nextInt();
			                   }while(a!=0);
			                   case 5:
			                	   meu.showManyMenu();
			                	   System.out.println("************************");
			                	   break;
			                   }
			               }while(s!=0)	;
			               break; 
			               case 6:
			            	   System.out.println("谢谢使用，再见！");
			            	   meu.showBybMenu();
			               break; */
					   
					   case 6:
						    input.close();
				            return;
					   }
				}while(b!=0);
				
				  case 2:System.out.println("退出水滴清单！！");
						  break;
						}
			break;
				
			}catch(Exception e) {
				System.out.println("输入错误(请输入整数），请按主菜单选择重新输入！！！");
				
				}
			}
		
		}
	}
	 
