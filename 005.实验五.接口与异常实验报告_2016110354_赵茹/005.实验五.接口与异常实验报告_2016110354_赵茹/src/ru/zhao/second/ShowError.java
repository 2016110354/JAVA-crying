package ru.zhao.second;

import ru.zhao.first.MyArrayList;

public class ShowError {
		public static void main(String[] args) {
			MyArrayList test_overflow = new MyArrayList(5);//声明构造数组
			long start = System.currentTimeMillis();
			try {
				while(true){
					int []array=new int [100000000];
					for(int i=0;i<100000000;i++) {
						array[i]=i;
					}
					test_overflow.add(array);//分配内存
				}
			}catch(OutOfMemoryError e) {
				System.err.println("内存已满");
				System.err.println("总内存是"+Runtime.getRuntime().totalMemory()+"KB");
				System.err.println("空闲内存是"+Runtime.getRuntime().freeMemory()+"KB");
				test_overflow.clear();
				System.gc();
				System.out.println("清理内存之后");
				System.out.println("总内存是"+Runtime.getRuntime().totalMemory()+"KB");
				System.out.println("空闲内存是"+Runtime.getRuntime().freeMemory()+"KB");
			}finally{
				System.gc();
				long end = System.currentTimeMillis();

				System.out.println("执行此程序总共花费了" + ( end - start ) / 1000 + "秒");
			}
		}
	}



