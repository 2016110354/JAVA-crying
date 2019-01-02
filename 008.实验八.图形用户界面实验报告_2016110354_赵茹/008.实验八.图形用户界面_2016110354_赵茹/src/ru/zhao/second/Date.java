package ru.zhao.second;


public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date(String date){
		String[] strings = date.split("-");
		this.year = Integer.parseInt(strings[0]);
		this.month= Integer.parseInt(strings[1]);
		this.day = Integer.parseInt(strings[2]);
	}
	
	//�ж������Ƿ���ȷ
	public static boolean isCorrect(String date) {
		String[] strings = date.split("-");
		if (strings.length != 3) {
			return false;
		}
		int year =0,month = 0, day =0;
		try {
			year = Integer.parseInt(strings[0]);
			month= Integer.parseInt(strings[1]);
			day = Integer.parseInt(strings[2]);
		} catch (Exception e) {
			return false;
		}
		
		
		if (year<=1970 || year>2020) {
			return false;
		}
		
		if (month<=0 || month>12) {
			return false;
		}
		
		int maxDay = 30;
		if (month==1 || month==3 || month==5 || month==7 || month==8
				|| month==10 || month==12) {
			maxDay=31;
		}else if (month==2) {
			if ((year%4==0 && year%100 !=0) || year%400==0) {
				maxDay = 29;
			}else {
				maxDay = 28;
			}
		}
		
		if (day<=0 || day>maxDay) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return year+"-"+month+"-"+day;
	}

	public int compareTo(Date o) {
		
		if (year != o.year) {
			return year-o.year;
		}else if (month != o.month) {
			return month-o.month;
		}else if (day != o.day) {
			return day-o.day;
		}else {
			return 0;
		}
		
	}
}
