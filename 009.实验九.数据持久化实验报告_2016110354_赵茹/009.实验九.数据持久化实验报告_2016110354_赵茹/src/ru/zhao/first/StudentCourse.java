package ru.zhao.first;
/*
 * Author:zhaoru
 * Time:2018-12-28
 * Version:1-1
 */
public class StudentCourse {
	private String cursno = "";
	private String name = "";
	private int credit = 0;
	
	public StudentCourse(String cursNo,String name, int credit) {
		this.setCursNo(cursNo);
		this.setName(name);
		this.setCredit(credit);
	}

	public String getCursNo() {
		return cursno;
	}

	public void setCursNo(String cursNo) {
		this.cursno = cursNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getValues() {
		return "'"+getCursNo() + "','" + getName() + "', '" + getCredit() + "'";
	}

}
