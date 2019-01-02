package ru.zhao.first;

public interface ReList {
	//往列表尾部添加对象
	void add(Object obj);
	//向列表头部添加对象
	void addFirst(Object obj);
	//从列表中获取索引为index的对象
	Object get(int index);
	//清空所有对象
	void clear();
	//判断列表中是否有对象
	boolean isEmpty();
	//获取列表中对象个数
	int size();
	//所分配空间大小
	int capacity();

}
