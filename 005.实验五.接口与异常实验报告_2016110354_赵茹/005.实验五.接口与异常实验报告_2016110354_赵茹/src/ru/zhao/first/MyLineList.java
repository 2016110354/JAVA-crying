package ru.zhao.first;

public class MyLineList implements ReList{
		//单向链表类
		private Node head;   //头节点
		private Node tail;   //尾节点
		int size;  //节点个数
	
//		public void setHead(Node head) {
//			this.head = head;
//		}
//		public void setTail(Node tail) {
//			this.tail = tail;
//		}
		//初始化一个空的链表
		public MyLineList() {
			//初始化头结点，让指针指向头结点。
			this.head = new Node();
			//头结点和尾结点是同一个
			this.tail = this.head;
			//单向链表，初始长度为0
			this.size = 0;
	}
		//尾部添加元素
		public void add(Object obj){
			System.out.println("add方法开始执行，从尾部添加元素:" + obj);
			//添加一个结点
			Node node = new Node(obj);
			tail.next = node;
			tail = node;
			size++;//对象增加
		}
		
		public void addFirst(Object obj){//往列表头部铁架对想
			System.out.println("addFirst方法开始执行，从头部添加元素:" + obj);
			//添加结点obj
			Node node = new Node(obj);
			node.next = head.next;
			head.next = node;
			if(this.head == this.tail){
				this.tail = node;
			}
			size++;
			System.out.println("头部节点添加成功");
		}
		//定位函数，实现操作对象的前一个结点，也就是让当前结点对象定位到操作节点的前一个结点
		public Object get(int index){//获取结点
			System.out.println("查找元素脚标:" + index + "元素为：");
			if(index<=size && index>=0){
				Node node = new Node();
				node = head;
				for(int i=0;i<=index;i++){
					node = node.next;	
				}
				return node;
				
			}else{
				return null;
			}
		}
		 

		
		public void clear(){
			this.head = new Node();
			this.tail = this.head;
			this.size = 0;
			System.out.println("clear方法执行，当前链表为:" + this.size);
		}
		
		public boolean isEmpty(){
			System.out.println("isEmpty方法执行，数组为空!");
			if(size>0){
				return false;
			}else{
				return true;
			}
			
			
		}
		
		public int size(){//返回对象个数
			System.out.print("链表对象个数为：");
			return this.size;
		}
		
		public int capacity(){//分配空间大小
			System.out.print("链表分配空间大小为：");
			return size;
		}
		
		public String toString(){
			StringBuffer str = new StringBuffer();
			Node node = this.head;
			for(int i=0;i<size;i++){
				node = node.next;
				str.append(node.data);
				str.append(" ");
			}
			return str.toString();
		}
//	     public void toString(MyLineList mylinelist) {
//	  	   for (int i = 0; i<mylinelist.size; i++) {
//	  	             System.out.print(mylinelist.get(i) + " ");
//	  }
//	  	}
	  	   
			     
			     
			 }
	
	
