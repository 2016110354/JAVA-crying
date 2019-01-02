package ru.zhao.second.menu;
/*
 * Auther:赵茹
 * Date:2018-10-2
 * Version:1.0
 *  */


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
public class  MenuMethod {
	//ArrayList类是一个动态数组类型，也就是说，ArrayList对象既有数组的特征，也有链表的特征。可以随时从链表中添加或删除一个元素。ArrayList实现了List接口。
    List<String> userName = new ArrayList<String>();
    List<String> showName = new ArrayList<String>();
    List<String> userPassword = new ArrayList<String>();
    List<String> TruePassword = new ArrayList<String>();
    List<String> userEmail = new ArrayList<String>();
    List<String> userAnswer = new ArrayList<String>();
    List<String> question = new ArrayList<String>();
    //
    static String[] userQuestion = {"1.你的生日在几月？",
            "2.你叫什么名字？",
            "3.你最喜欢的国家：",
            "4.你最喜欢的颜色：",
            "5.世界杯最喜欢哪个队？"};
	//分别将菜单写为方法,用对象调入
	public void showLoginMenu(){
		System.out.println("****欢迎进入水滴清单！****");
		System.out.println("1.登录系统");
		System.out.println("2.退出");
	}
	public void  showMainMenu(){
		System.out.println( "1.登陆方式:");
		System.out.println( "2.系统设置:");
		System.out.println( "3.新增备忘录:");
		System.out.println( "4.查找备忘录:");
		System.out.println( "5.备忘录分类:");
		System.out.println( "6.退出系统:");
	}
	public void showManyMenu(){
		System.out.println("正在执行某功能！");
	}
	public void noAnnotaion() {
		System.out.println("用户未登陆，请先登陆！");
	}
	public void showFindMenu(){
		System.out.println("1.按日期查找:");
		System.out.println("2.按分组查找:");
		System.out.println("3.按标签查找:");
		System.out.println("4.按提醒日期查找:");
		System.out.println("5.返回上一层菜单:");
	}
	public void showAnnotaion() {
		System.out.println("1.注册:");
		System.out.println("2.登陆:");
		System.out.println("3.找回密码:");
		System.out.println("4.返回上一层菜单:");		
	}
	public void showBybMenu() {
		System.out.println("谢谢使用，再见！");
	}
	
	//注册
    public  void userRegister() {
		Scanner input  = new Scanner(System.in);
		System.out.println("请输入用户名、显示名、密码、确认密码、邮箱:");
		inputUsername();
		inputShowName();
		userPassword.add(inputPassword());
		//inputPassword();
		//inputPasswordAgain(input);
		inputEmail();
		inputTips();

		System.out.println("请回答下面算术题:");
		while(!identifyCode()) {
			System.out.println("验证错误！");
			identifyCode();
		}
		
		count++;
		
		System.out.println("恭喜完成注册");
		
	}
	//输入用户名
	public void inputUsername() {
		String username = null;
		while(true) {
			System.out.print("用户名为：");
			Scanner in = new Scanner(System.in);
			username = in.nextLine();
			//用户名只能包含字母、数字、下划线，首字母只能为字母，不能少于6个、大于20个字符
			//用户名是不是只包含字符，首字母是否为大写
			if(username.matches("[\\w+]{6,20}") && Character.isLetter(username.charAt(0))) {
			//if(username.matches("^[a-zA-Z]\\w{6,20}$")){
				break;
			}else {
				System.out.println("用户名只能包含字母、数字、下划线，首字母只能为字母，不能少于6个、大于20个字符");
				System.out.println("用户名不合法，请重新输入用户名");
			}
		}
		userName.add(username);
	}

	//输入显示名
	public void inputShowName() {
		// TODO Auto-generated method stub
		String showname = null;
		while(true) {
			System.out.print("显示名为：");
			Scanner in = new Scanner(System.in);
			showname = in.nextLine();
			if(showname.length()>2&&showname.length()<21) {
				break;
			}else {
				System.out.println("（显示名不能少于3个、大于20个字符）");
				System.out.println("显示名不合法，请重新输入");
				
			}
		}
		showName.add(showname);
	}
	
	//输入密码
	public String inputPassword() {
		// TODO Auto-generated method stub
		String password = null;
		while(true) {
			System.out.print("密码为：");
			Scanner in = new Scanner(System.in);
			password = in.nextLine();
			//^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[-.!@#$%^&*()+?><]).{8,30}$
			if(password.matches("[\\w!@#$%^&]{8,}$")) {
				if(inputPasswordAgain(password)) {
					break;
				}
			}else {
				System.out.println("用户密码必须包含字母数字和特殊符号，大于8位，小于30位");
				System.out.println("密码不合法，请重新输入");
				
			}
		}
		return password;
	}

	//确认密码
	public boolean inputPasswordAgain(String password) {
		String passwordAgain = null;

		System.out.print("确认密码：");
		Scanner in = new Scanner(System.in);
		passwordAgain = in.nextLine();
		if(passwordAgain.equals(password)) {
			return true;
		}else {
			System.out.println("两次密码不一致，请重新输入密码");
			return false;	
		}
	}
	public void setPassword(String password, int modifyIndex) {
		userPassword.set(modifyIndex, password);
	}
	//输入邮箱
	public void inputEmail() {
		String useremail = null;
		while(true) {
			System.out.print("邮箱：");
			Scanner in = new Scanner(System.in);
			useremail = in.nextLine();
			   
		   int indexOfAt = useremail.indexOf('@');
		   int indexOfDot = useremail.indexOf('.');

		   if(indexOfAt > 0 && indexOfDot < useremail.length() - 1 
		   		&& indexOfDot > indexOfAt){  
		     break;
		   } //else {
			//if(useremail.matches("^[\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{0,50}")) {
			//	break;
			else {
				System.out.println("邮箱不合法，请重新输入");
			}
		}
		userEmail.add(useremail);
	}		
	
	//输入密码提示
	public void inputTips() {
		// TODO Auto-generated method stub
		int choice = 0;
		String answer = null;
		while(true) {
			try {
				for(String question:userQuestion) {	
					System.out.println(question);
				}
				System.out.println("请输入你选择的问题的序号：");
				Scanner in = new Scanner(System.in);
				choice = in.nextInt();
				if(choice>0 && choice < 6) {
					break;
				}
				//System.out.println("请输入1-5的整数：");
			} catch (InputMismatchException e) {
				
				System.out.println("请输入1-5的整数：");
			}
		}
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println(userQuestion[choice-1]);
			answer = in.nextLine();
			if(answer.length()>0 && answer.length()<20){
				break;
			}
			System.out.println("回答不能为空且不能大于20个字符，请重新输入。");
		}
		question.add(userQuestion[choice-1]);
		userAnswer.add(answer);
	}

	//验证码

	//验证码
	public static boolean identifyCode() {
		Scanner input = new Scanner(System.in);
		boolean judge = true;
		int count = 1;
		double result2 = calculate();
		double result1 = input.nextDouble();
		while(count<5 && result1 != result2) {
			result2=calculate();
			result1=input.nextDouble();
			count++;
		}
		return judge;
	}
	//验证码计算
	public static int calculate(){
	   int result=0;
       int a=(int)(Math.random()*10);
       int b=(int)(Math.random()*10+1);
       int c=(int)(Math.random()*10+1);
       int symbol=(int)(Math.random()*6);
       if(symbol==0){
    	   System.out.println(a+"*"+b+"-"+c+"=");
    	   result=a*b-c;
       }
       if(symbol==1){
    	   System.out.println(a+"/"+b+"-"+c+"=");
    	   result=a/b-c;
       }
       if(symbol==2){
    	   System.out.println(a+"+"+b+"-"+c+"=");
    	   result=a+b-c;
    	   return result;
       }
       if(symbol==3) {
    	   System.out.println(a+"+"+b+"*"+c+"=");
    	   result=a+b*c;
       }
       if(symbol==4) {
    	   System.out.println(a+"*"+b+"+"+c+"=");
    	   result=a*b+c;
       }
       if(symbol==5){
    	   System.out.println(a+"-"+b+"+"+c+"=");
    	   result=a-b+c;
       }
       return result;
	}
	
	//登录
	public void login() {
		while(true) {
			String username = null;
			int isLogin = -1;
			int record = -1;
			while(true) {
				System.out.print("用户名：");
				Scanner in = new Scanner(System.in);
				username = in.nextLine();
				//用户名是不是只包含字符，首字母是否为大写
				for (int i = 0; i < userName.size(); i++) {
					if (userName.get(i).equals(username)) {
						record = i;
					} 
				}
				if(record>-1) {
					break;
				}else {
					System.out.println("不存在该用户，请重新输入");	
				}			
			}
			String password = null;
			System.out.println("密码：");
			Scanner in = new Scanner(System.in);
			password = in.nextLine();
			if (userPassword.get(record).equals(password)) {
				System.out.println("登陆成功");
				isLogin = record;
				break;
			} else {
				System.out.println("密码错误");
			}	
		}
	}
	
	//找回密码
	public void backPassword() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("请输入要找回密码的用户名：");
			String username = null;
			int record = -1;
			while(true) {
				System.out.print("用户名：");
				Scanner in = new Scanner(System.in);
				username = in.nextLine();
				//用户名是不是只包含字符，首字母是否为大写
			
				for (int i = 0; i < userName.size(); i++) {
					if (userName.get(i).equals(username)) {
						record = i;
					} 
				}
				if(record>-1) {
					break;
				}else {
					System.out.println("不存在该用户，请重新输入");	
				}			
			}
			System.out.println("请回答验证问题：");
			System.out.println(question);
			Scanner in = new Scanner(System.in);
			String answer = in.nextLine();
			String password = null;
			if(answer.equals(userAnswer.get(record))) {
				password = inputPassword();
				setPassword(password, record);
				System.out.println("修改成功");
				break;
			}else {
				System.out.println("答案不正确！");
			}
		}
	}
	
	/*//退出登录
	public void exitLogin() {
		
	    isLogin = -1;
	}
	*/


	//输出
	static int count=0;
	public void userPrint() {
		for (int i = 0; i < count; i++) {
			System.out.println("username:"+ userName.get(i));
			System.out.println("displayname:"+showName.get(i));
			System.out.println("password:"+userPassword.get(i));
			System.out.println("email:"+userEmail.get(i));
			System.out.println("question:"+question.get(i));
			System.out.println("answers:"+userAnswer.get(i));
			System.out.println();
		}
	}
	
	
	
}

