package ru.zhao.first;

import java.util.Arrays;

public class MyArrayList implements ReList{
	
	      int size;   //数组增量
	      Object[] elementDate;     //数组
	      int indexNumArray;        //对象数量
          int incSize = 5;
//	 public void setIndexNumArray(int indexNumArray) {
//			this.indexNumArray = indexNumArray;
//		}
//	 public void setSize(int size) {
//		this.size = size;
//	}
	 public MyArrayList() {
		// TODO Auto-generated constructor stub
	}
	 
	//构造函数 ReArrayList(int incSize)：参数 incSize 为数组初始化大小和空间的增量。
    public MyArrayList(int incSize) {
		//若用户调用 incSize 非法，则设为默认值 5。
		if(incSize < 1) {
			this.size = 5;
			this.elementDate = new Object[5];
			
		}else {
			this.size = incSize;
			this.elementDate = new Object[incSize];
			
		}
		System.out.println("数组被初始化，增量为:" + incSize);
		
	}
    ////往列表尾部添加对象
    public void add(Object obj) {
    	System.out.println("add方法开始执行，从尾部添加元素:" + obj);
//    	for(int i = 0; i<elementDate.length;i++) {
//    		if(elementDate[i] == null) {
//    			elementDate[i] = obj;
//    			return;
//    		}
//    		}
//    	System.out.println("内部数组已满，增加数组大小(复制），增量为:" + size);
//    	//复制的副本和返回的数组长度方法
//    	this.elementDate = Arrays.copyOf(elementDate, elementDate.length + size);
//    	System.out.println("新的数组长度为:"  + elementDate.length);
//    	System.out.println("数组内部元素为：" + this);
//    	this.add(obj);
//    }
    	if(indexNumArray == size) {
    		//增长数组
    		size += incSize;
    		Object[] newArray = new Object[size];
    		for(int i=0;i<elementDate.length;i++) {
    			newArray[i] = elementDate[i];
    		}
    		elementDate = newArray;
    	}
///    		this.elementDate = Arrays.copyOf(elementDate, elementDate.length + size);
    		elementDate[indexNumArray] = obj;
    		//对象增加
    		indexNumArray++;
    	}
    	
       //向列表头部添加对象
    public void addFirst(Object obj){
        System.out.println("addFirst方法开始执行，从头部添加元素:" + obj);
        
//        newArray[0] = obj;
// 		for(int i = 0;i<elementDate.length;i++) {
//		if(elementDate[i] == null) {
//			while(i==0) {
//				elementDate[0] = obj;	
//				return;
//			}
//			while(i>=1) {
//				elementDate[i] = elementDate[i-1];
//				elementDate[0] = obj;
//				return;
//			}
//
        if(indexNumArray == size) {
			size += incSize;
			Object[] newArray = new Object[size];
			newArray[0] = obj;
			for(int i=0;i<elementDate.length;i++) {
				newArray[i+1] = elementDate[i];
//				return;
			}
			elementDate = newArray;
			
		}else {
//			Object[] newArray3 = new Object[size];
//			newArray3[0] = obj;
		for(int i = indexNumArray;i>0;i--) {
			elementDate[i] = elementDate[i-1];		
		}
		elementDate [0] = obj;
		indexNumArray++;
		}
    }
    
  //从列表中获取索引为index的对象
    public Object get(int index) {
    	System.out.print("查找元素脚标:" + index + ",元素为:");
    	if(index >= elementDate.length) {
    		System.err.println("参数错误！" + index);
    		return null;
    	}
    	return elementDate[index];
    }
    
  //清空所有对象
    public void clear() {
    	this.elementDate = new Object[size];
    	System.out.println("clear方法执行,数组为:");
    	
    }
  //判断列表中是否有对象
    public boolean isEmpty() {
    	System.out.print("isEmpty方法执行，");
    	for(Object t: elementDate) {
    		if(t != null) {
    			System.out.print("列表中没有对象，为空:");
    			return false;
    		}
    	}
    	System.out.print("列表中没有对象，为空:");
    	return true;
    }
  //获取列表中对象个数
    public int size() {
    	System.out.print("size方法执行，数组对象个数为:" );
//    	return (int) Arrays.stream(elementDate).filter(e ->e != null).count();
    	return this.indexNumArray;
    }
  //所分配空间大小
    public int capacity() {
    	System.out.print("capacity方法执行，" );
    	return elementDate.length;
    }
    //打印数组
    public String toString() {
    	return "ReArrayList [size = " + size + ",elementDate =" + Arrays.toString(elementDate) + "]";
    }

//	public void ReArrayList(int i) {
//		// TODO Auto-generated method stub
//		
//	}
   
	

}
