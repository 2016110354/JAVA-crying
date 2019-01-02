package ru.zhao.second;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Diary {//私有属性
	public Date date;
	public Weather weather;
	public Mood mood;
	public String title;
	public String content;
	//Diary diary = new Diary();
	//定义枚举类型
		
		//构造对象
	public Diary(Date date2,String title,String content) {
//		this.setDate(date);
		this.date =  date2;
//		this.weather = weather;
//		this.mood = mood;
		this.title = title;
		this.content = content;
	}
	
	//初始化日记
	public Diary() {
		InputDate();
		InputWeather();
		InputMood();
		InputTitle();
		InputContent();
	}

	//使用正则表达式 测试 字符 符合 dddd-dd-dd 的格式(d表示数字)
	public static boolean JudgeDate(String inputdate) {
			//这个正则匹配的是日期格式为:yyyy-MM-dd
			String rexp = "((\\d{2}(([02468][048])|([13579][26]))[\\-]((((0?[13578])|(1[02]))[\\-]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-]((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-]((((0?[13578])|(1[02]))[\\-]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-]((0?[1-9])|(1[0-9])|(2[0-8]))))))";
			Pattern p = Pattern.compile(rexp);
			Matcher judDate = p.matcher(inputdate);
			if(judDate.matches()) {
				return true;
			}else {
				return false;
			}
			}
	 public static String InputDate() {
		 String date = null ;
		 Scanner input = new Scanner(System.in);
		 while(true) {
		 
		 System.out.println("请以xxxx-xx-xx的格式输入日记日期:");
		 date = input.nextLine();
	 if(JudgeDate(date)){
		 break;
	 }else {
		 System.out.println("您输入的日期不合法，请重新输入！");
		 }
		 }
		 return date;
	 }
	 
	 public static Weather InputWeather() {
		    Scanner input = new Scanner(System.in);
			Weather weather = null;
			System.out.println("请输入您要选择的天气：");
		System.out.println("1.sunny");
	    System.out.println("2.rainy"); 
		System.out.println("3.windy");
		System.out.println("4.snowy");
		int choice = input.nextInt();
		switch(choice) {
		case 1:  
	        weather = Weather.sunny;  
	        break;  
	    case 2:  
	    	weather = Weather.rainy;  
	        break;  
	    case 3:  
	    	weather = Weather.windy;
	    	break;
	    case 4:
	    	weather = Weather.windy;
	        break;  
		default:
			System.out.println("请输入1-4的整数！");
				break;
			}
			return weather;
	 }
	 public static  Mood InputMood() {
		    Scanner input = new Scanner(System.in);
		    Mood mood = null;
		    System.out.println("请选择心情:");
		System.out.println("1.happy");
		System.out.println("2.sad"); 
		System.out.println("3.angry");
		System.out.println("4.sad");
		int choice = input.nextInt();
		switch(choice) {
		case 1:
			mood = Mood.happy;
			break;
		case 2:
			mood = Mood.sad;
			break;
		case 3:
			mood = Mood.angry;
			break;
		case 4:
			mood = Mood.fear;
			break;
		default:
			System.out.println("请输入1-4的整数！");
	    		break;
	    	 }
			return mood;
			}
	 public static String InputTitle() {
		 String title = null;
		 Scanner input = new Scanner(System.in);
		 while(true) {
		 System.out.println("请输入标题（不多于十二个字）");
	 title = input.nextLine();
	 if(title.length()<=12) {
		 break;
		 }else {
		 System.out.println("标题过长从，请重新输入！");
		 }
		 }
		 return title;
	 }
	 public static String InputContent() {
			Scanner in = new Scanner(System.in);
			System.out.println("请输入日记内容：");
			return in.nextLine();
	 }
	//重写 Diary 类的 toString()方法
	public String toString() {
		return ("日记日期为:" + date.toString() + "天气为：" + weather + "心情：" + mood + "标题为：" + title + "内容是：" + content); 
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	public Weather getWeather() {
		return weather;
	}
	public void setMood(Mood mood) {
		this.mood = mood;
	}
	public Mood getMood() {
		return mood;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}

}
enum Weather {
	sunny,rainy,
	windy,snowy
}
enum Mood {
	happy,sad,
	angry,fear	
}
