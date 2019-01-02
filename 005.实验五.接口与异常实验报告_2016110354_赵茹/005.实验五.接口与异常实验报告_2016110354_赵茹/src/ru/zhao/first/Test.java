package ru.zhao.first;

public class Test {
	public static void main(String[] args) {
		MyArrayList array = new MyArrayList(6);
		//头插法测试
		for(int i=0;i<10;i++) {
			array.add(i);
		}
		//尾插法测试
		array.addFirst(100);
		array.add(200);
		array.addFirst(300);
		array.addFirst(400);
//		array.addFirst(66);
       
		System.out.println(array);
		System.out.println(array.get(3));
		System.out.println(array.size());
		System.out.println(array.isEmpty());
		System.out.println("当前数组空间大小为:" + array.capacity());
		array.clear();
		System.out.println(array);
		System.out.println(array.size());
		System.out.println(array.isEmpty());
		System.out.println("当前数组空间大小为:" + array.capacity());

		MyLineList list = new MyLineList();
		//头插法测试
		for(int i=10;i<20;i++) {
			list.add(i);
		}
		//尾插法测试
		list.addFirst(111);
		list.addFirst(222);
		list.add(333);
		list.add(444);
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println("当前数组空间大小为:" + list.capacity());
		list.clear();
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println("当前数组空间大小为:" + list.capacity());
		
		
	}

}
