package ru.zhao.first;
/*
 * Author:zhaoru
 * Time:2018-12-28
 * Version:1-1
 */
public class Student {
	private String stdno = "";
	private String name = "";
	private String sex = "";
	private String birth = "";
	private String password = "";
	
	public Student(String stdNo,String name, String sex,String birth,String password) {
		this.stdno = stdNo;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getstdNo() {
		return stdno;
	}
	public void setstdNo(String stdNo) {
		this.stdno = stdNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getValues() {
		return "'"+getstdNo() + "','" + getName() + "', '" + getSex() + "', '" + getBirth() + "', '" + getPassword() + "'";
	}


}
