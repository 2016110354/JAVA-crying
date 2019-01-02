package ru.zhao.first;
/**
 * author:zhaoru
 * date:2018-11-15
 * version:1.0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
		public static void main(String[] args) {
			List <Integer> list = new ArrayList<Integer>();
			FrequencyCalculator list1 = new FrequencyCalculator(list);
			for(int i=0;i<8;i++) {
				list1.add(i);
			}
			int [] ary = {1,2,3,1,2,3,4,5};
			
			list1.add(ary);
			list1.add(2);
			List<Map<Integer,Integer>>list2 = list1.getHighest();
			List<Map<Integer,Integer>>list3 = list1.getLowest();
			System.out.println("list1前三名："+list2);
			System.out.println("list1后三位："+list3);	
			//测试前三位不够位数
			List <Integer> list4 = new ArrayList<Integer>();
			int [] ary1 = {2,3,3,3,3,3,3};
			FrequencyCalculator list5 = new FrequencyCalculator(list4);
			list5.add(ary1);
			List<Map<Integer,Integer>>list6 = list5.getHighest();
			List<Map<Integer,Integer>>list7 = list5.getLowest();
			System.out.println("list2前三名："+list6);
			System.out.println("list2后三位："+list7);	
			//测试重复的数
			int [] ary2 = {4,4,4,4,4,4,4,4};
			List <Integer> list8 = new ArrayList<Integer>();
			FrequencyCalculator list9 = new FrequencyCalculator(list8);
			list9.add(ary2);
			System.out.println("list3前三名："+list9.getHighest());
			System.out.println("list3后三位："+list9.getLowest());
			int [] ary3 = {};
			List <Integer> list10 = new ArrayList<Integer>();
			FrequencyCalculator list11 = new FrequencyCalculator(list10);
			list9.add(ary3);
			System.out.println("list4前三名："+list11.getHighest());
			System.out.println("list4后三位："+list11.getLowest());
			//测试clear
			int [] ary4 = {4,4,4,4,4,4,4,4};
			List <Integer> list12 = new ArrayList<Integer>();
			FrequencyCalculator list13 = new FrequencyCalculator(list12);
			list13.add(ary4);
			list13.clear();
			System.out.println("list3前三名："+list13.getHighest());
			System.out.println("list3后三位："+list13.getLowest());
		}	
		
	}
