package ru.zhao.first;
/*
 * Author:zhaoru
 * Time:2018-12-28
 * Version:1-1
 */
public class StudentSC {
	private String stdno = "";
	private String cursno = "";
	public StudentSC(String stdno,String cursno) {
		this.setStdno(stdno);
		this.setCursno(cursno);
	}
	public String getCursno() {
		return cursno;
	}
	public void setCursno(String cursno) {
		this.cursno = cursno;
	}
	public String getStdno() {
		return stdno;
	}
	public void setStdno(String stdno) {
		this.stdno = stdno;
	}
	public String getValues() {
		return "'"+getStdno() + "','" + getCursno() + "'";
	}

}
