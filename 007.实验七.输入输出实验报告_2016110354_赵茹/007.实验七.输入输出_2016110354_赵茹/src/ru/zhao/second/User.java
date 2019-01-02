package ru.zhao.second;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class User {
	//ArrayList类是一个动态数组类型，也就是说，ArrayList对象既有数组的特征，也有链表的特征。可以随时从链表中添加或删除一个元素。ArrayList实现了List接口。
    List<String> userName = new ArrayList<String>();
    List<String> showName = new ArrayList<String>();
    List<String> userPassword = new ArrayList<String>();
    List<String> TruePassword = new ArrayList<String>();
    List<String> userEmail = new ArrayList<String>();
    List<String> userAnswer = new ArrayList<String>();
    List<String> question = new ArrayList<String>();
    List<Diary> diary = new ArrayList<Diary>();
    //登陆状态验证
    int JudgeLogin = -1;
    static Boolean loginFlag = false;
    static String[] userQuestion = {"1.你的生日在几月？",
            "2.你叫什么名字？",
            "3.你最喜欢的国家：",
            "4.你最喜欢的颜色：",
            "5.世界杯最喜欢哪个队？"};
    //设置静态变量计数器
	static int count = 0;
	//获取用户名
		public List<String> getuserName() {
			return userName;
		}
		
		//获取显示名
		public List<String> getshowName() {
			return showName;
		}
		
		//获取密码
		public List<String> getuserPassword() {
			return userPassword;
		}
		//获取重复密码
		public List<String> getTruePassword() {
			return TruePassword;
		}
		
		//获取邮箱
		public List<String> getuserEmail() {
			return userEmail;
		}

		//获取密码提示
		//获取问题
		public List<String> getQuestion() {
			return question;
		}
		
		//获取答案
		public List<String> getAnswer() {
			return userAnswer;
		}
		
		//获取问题集
		public String[] getQuestions() {
			return userQuestion;
		}
		
		//获取登录状态
		public int getJudgeLogin() {
			return JudgeLogin;
		}
		
		//获取用户个数
		public static int getCount() {
			return count;
		}
		//修改密码
		public void setchagePassword(String userPassword, int modifyIndex) {
			this.userPassword.set(modifyIndex, userPassword);
		}
		//输出用户信息
		//static int count=0;
		public void userPrint() {
			for (int i = 0; i < count; i++) {
				System.out.println("username" + i + ":"+ userName.get(i));
				System.out.println("displayname:"+showName.get(i));
				System.out.println("password:"+userPassword.get(i));
				System.out.println("email:"+userEmail.get(i));
				System.out.println("question:"+question.get(i));
				System.out.println("answers:"+userAnswer.get(i));
					System.out.println();
				}
			}
		//构造函数
		public User() {
			
		}
		//登陆系统菜单
		public void showAnnotaion() {
			System.out.println("请选择：");
			System.out.println("1.注册:");
			System.out.println("2.登陆:");
			System.out.println("3.找回密码:");
			System.out.println("4.返回上一层菜单:");		
		}
		//实现注册功能
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
		////输入用户名
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
		//修改密码
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
					loginFlag = true;
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
		//退出登录
		public void exitLogin() {
			this.JudgeLogin = -1;
		}
		
		public void addDiary(Diary diary) {
			this.diary.add(diary);
		}
		//主菜单栏
//		public void loginMenuPrintuser() {//主菜单栏
//			System.out.println("1.["+showName.get(JudgeLogin)+"]退出登录;");
//			System.out.println("2.系统设置;");
//			System.out.println("3.写日记;");
//			System.out.println("4.查找日记;");
//			System.out.println("5.退出系统;");
//			System.out.println("请选择：");
//		}
		
		public  void dateSort(){
			Collections.sort(diary,new Comparator<Diary>(){
				@Override
				public int compare(Diary d1,Diary d2){
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					try{
						java.util.Date date1 = format.parse(d1.date.printDate());
						java.util.Date date2 = format.parse(d2.date.printDate());
						if(date1.getTime()>date2.getTime()){
							return 1;
						}else if(date1.getTime()<date2.getTime()){
							return -1;
						}else{
							return 0;
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					return 0;
				}
			});
		}
		//显示多篇日记
		public void showDiary(){
			for(int i=0;i<diary.size();i++){
				System.out.println(diary.get(i));
			}
		}
}
		
		
		
		
    


		
    

