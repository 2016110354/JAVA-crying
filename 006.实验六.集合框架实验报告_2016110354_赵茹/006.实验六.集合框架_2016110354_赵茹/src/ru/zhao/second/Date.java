package ru.zhao.second;

public class Date {
	public String date;
	public Date(String date) {
		//this.date = date;
		this.setDate(date);
	}
	public Date() {
		
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

	}


