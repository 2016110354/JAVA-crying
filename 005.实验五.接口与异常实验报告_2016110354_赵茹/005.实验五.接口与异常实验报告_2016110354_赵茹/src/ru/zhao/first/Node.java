package ru.zhao.first;

public class Node {
	public Object data;//数据域
	public Node next;//指针域
	//构造函数(有参无参)
	public Node(){
	}
	public Node(Object data){
		this.data = data;
	}
	public String toString() {
		return "data:" + data;
	}

}
