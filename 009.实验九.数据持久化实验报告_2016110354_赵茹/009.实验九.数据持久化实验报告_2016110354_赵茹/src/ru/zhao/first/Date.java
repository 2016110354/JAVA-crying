package ru.zhao.first;
/*
 * Author:zhaoru
 * Time:2018-12-28
 * Version:1-1
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {
	String date;
	static boolean isDate = false;
	public static boolean testDate(String date){
		//使用正则表达式测试字符串是否符合dddd-dd-dd的格式
		//生成一个Pattern，同时编译一个正则表达式
		Pattern p = Pattern.compile("\\d{4}+[-]\\d{1,2}+[-]\\d{1,2}+");	
		//Matcher类提供对正则表达式的分组支持和多次匹配支持	
		Matcher m = p.matcher(date);
		//对整个字符串进行匹配  
		if(!m.matches()){												
			return false;
		}
		//得到年月日
		String[] arry = date.split("-");
		int year = Integer.valueOf(arry[0]);
		int month = Integer.valueOf(arry[1]);
		int day = Integer.valueOf(arry[2]);
		//判断月份是否正确
		if(month<1 || month>12){					
			return false;
		}
		int[] monthLengths = new int[]{0,31,-1,31,30,31,30,31,31,30,31,30,31};//定义数组存放每个月的天数
		if(year%4==0 && year%100!=0 || year%400==0){
			//是闰年，2月有29天
			monthLengths[2] = 29;					
		}
		//不是闰年，2月有28天
		else{										
			monthLengths[2] = 28;
		}
		int monthLength = monthLengths[month];	
		//判断每个月的天数
		if(day<1 || day>monthLength){				
			return false;
		}
		else{
			return true;
		}
	}
	public Date(String date){						
		if(testDate(date)){
			this.date = date;
			isDate = true;
			System.out.println("日期格式正确！");
		}
		else{
			System.out.println("日期不合法，构造失败！");
		}
	}

}
