package ru.zhao;
/*
 * Author:zhaoru
 * Time:2018-12-20
 * Version:1-1
 */
//用户查寻得到的日记显示类
public class SelectDiaryshow {
	private String dates;
	private String weather;
	private String mood;
	private String title;
	private String content;
	
	public SelectDiaryshow(String d1, String d2, String d3, String d5, String d6) {
		// TODO Auto-generated constructor stub
		this.dates = d1;
		this.weather = d2;
		this.mood = d3;
		this.title = d5;
		this.content = d6;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getMood() {
		return mood;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "日期:" + dates + " 天气:" + weather + " 心情:" + mood + " 标题:" + title ;
	}
}
