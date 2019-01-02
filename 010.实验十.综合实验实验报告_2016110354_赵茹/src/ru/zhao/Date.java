package ru.zhao;

/*
 * Author:zhaoru
 * Time:2018-12-20
 * Version:1-1
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//此类用于日期定义
public class Date {
//	private int year;
//	private int month;
//	private int day;
//	
	public String date;
	public Date(String date) {
//		this.date = date;
		this.setDate(date);
	}
	@Override 
	public String toString() {
		return date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String printDate() {
		return getDate();
	}
	public boolean isCollect(String date) {
		//这个正则匹配的是日期格式为:yyyy-MM-dd
		String rexp = "((\\d{2}(([02468][048])|([13579][26]))[\\-]((((0?[13578])|(1[02]))[\\-]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-]((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-]((((0?[13578])|(1[02]))[\\-]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-]((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		Pattern p = Pattern.compile(rexp);
		Matcher judDate = p.matcher(date);
		if(judDate.matches()) {
			return true;
		}else {
			return false;
		}
	}

	public static  boolean JudgeDate(String date) {
		//这个正则匹配的是日期格式为:yyyy-MM-dd
		String rexp = "((\\d{2}(([02468][048])|([13579][26]))[\\-]((((0?[13578])|(1[02]))[\\-]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-]((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-]((((0?[13578])|(1[02]))[\\-]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-]((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		Pattern p = Pattern.compile(rexp);
		Matcher judDate = p.matcher(date);
		if(judDate.matches()) {
			return true;
		}else {
			return false;
		}
		}
//	public Date(String date){
//		String[] strings = date.split("-");
//		this.year = Integer.parseInt(strings[0]);
//		this.month= Integer.parseInt(strings[1]);
//		this.day = Integer.parseInt(strings[2]);
//	}
//	
	//判断日期是否正确
//	public static boolean isCorrect(String date) {
//		String[] strings = date.split("-");
//		if (strings.length != 3) {
//			return false;
//		}
//		int year =0,month = 0, day =0;
//		try {
//			year = Integer.parseInt(strings[0]);
//			month= Integer.parseInt(strings[1]);
//			day = Integer.parseInt(strings[2]);
//		} catch (Exception e) {
//			return false;
//		}
//		
//		
//		if (year<=1970 || year>2020) {
//			return false;
//		}
//		
//		if (month<=0 || month>12) {
//			return false;
//		}
//		
//		int maxDay = 30;
//		if (month==1 || month==3 || month==5 || month==7 || month==8
//				|| month==10 || month==12) {
//			maxDay=31;
//		}else if (month==2) {
//			if ((year%4==0 && year%100 !=0) || year%400==0) {
//				maxDay = 29;
//			}else {
//				maxDay = 28;
//			}
//		}
//		
//		if (day<=0 || day>maxDay) {
//			return false;
//		}
//		
//		return true;
//	}

//	@Override
//	public String toString() {
//		return year+"-"+month+"-"+day;
//	}

//	public int compareTo(Date o) {
//		
//		if (year != o.year) {
//			return year-o.year;
//		}else if (month != o.month) {
//			return month-o.month;
//		}else if (day != o.day) {
//			return day-o.day;
//		}else {
//			return 0;
//		}
//		
//	}
}