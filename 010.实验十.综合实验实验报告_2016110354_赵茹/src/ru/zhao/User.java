package ru.zhao;
/*
 * Author:zhaoru
 * Time:2018-12-20
 * Version:1-1
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
//用户定义类
public class User {
	private String userName;
	private String userShowname;
	private String userPassword;
	private String okPassword;
	private String userMail;
	private int choiceQuestion;
	private String userAnswer;
	public User(String userName,String userShowname,String userPassword,String userMail,int choiceQuestion,String userAnswer) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.userShowname = userShowname;
		this.userPassword = userPassword;
		this.userMail = userMail;
		this.choiceQuestion = choiceQuestion;
		this.userAnswer = userAnswer;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserShowname() {
		return userShowname;
	}
	public void setUserShowname(String userShowname) {
		this.userShowname = userShowname;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getOkPassword() {
		return okPassword;
	}
	public void setOkPassword(String okPassword) {
		this.okPassword = okPassword;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public int getChoiceQuestion() {
		return choiceQuestion;
	}
	public void setChoiceQuestion(int choiceQuestion) {
		this.choiceQuestion = choiceQuestion;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	
	public String getValues() {
		// TODO Auto-generated method stub
		return "'"+ getUserName() + ',' + getUserShowname() + ',' + getUserPassword() + ',' + getUserMail() + ',' + getChoiceQuestion() + ',' + getUserAnswer()+"'";
	}
	
    
}
		
		
		
		
    


		
    

