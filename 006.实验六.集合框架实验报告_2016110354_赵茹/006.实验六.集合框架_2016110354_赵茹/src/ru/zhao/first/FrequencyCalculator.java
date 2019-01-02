package ru.zhao.first;

/**
 * author:zhaoru
 * date:2018-11-15
 * version:1.0
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FrequencyCalculator {
	//存数
	private List<Integer> list = null;

	//无参构造函数
	public FrequencyCalculator(){
		list = new ArrayList<Integer>();
	}
	public FrequencyCalculator(List<Integer> list){
		this.list = list;
	}
	public List<Integer> getList() {
		return list;
	}
	//添加一个整数
	public void add(int num){
		list.add(num);
	}
	//添加多个整数（数组）
	private int count = 0;
	public void add(int [] nums){
		if(nums==null){
			list.add(count);
		}else{
			for(int i=0;i<nums.length;i++){
				list.add(nums[i]);
				count++;
			}
		}
	}
	//进行频率的排序，之后返回前三位
	public List<Map<Integer, Integer>> getHighest() throws NoNumberException{
		Map<Integer,Integer> hightest = new LinkedHashMap<Integer,Integer>();
		List<Map<Integer, Integer>> height = new ArrayList<>();

		int count = 0;
		//遍历，把所有的数都放进map里面
		for(int i=0;i<list.size();i++){
			count=0;
			for(int j=0;j<list.size();j++){
				if(list.get(i)==list.get(j)){
					count++;
				}			
			}		
			hightest.put((Integer) list.get(i), count++);
		}
		//判断是否为空，非检查型异常 NoNumberException
		if(list.isEmpty()){
			throw new  NoNumberException("无整数不可以排序");
		}
		//按value排序
		List<Entry<Integer, Integer>> heightMap = new ArrayList<Map.Entry<Integer,Integer>>(hightest.entrySet());
		Collections.sort(heightMap,new Comparator<Map.Entry<Integer,Integer>>(){
			public int compare(Entry<Integer,Integer>o1,Entry<Integer,Integer>o2){
				//按降序排列
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		return pickTopThree(heightMap);
	}
	//返回频率排名最低的后三位
	public List<Map<Integer, Integer>> getLowest() throws NoNumberException{
		Map<Integer,Integer> hightest = new LinkedHashMap<Integer,Integer>();
		List<Map<Integer, Integer>> low = new ArrayList<>();
		int count = 0;
		//遍历，把所有的数都放进map里面
		for(int i=0;i<list.size();i++){
			count=0;
			for(int j=0;j<list.size();j++){
				if(list.get(i)==list.get(j)){
					count++;
				}			
			}
			hightest.put((Integer) list.get(i), count++);
		}
		//判断是否为空，非检查型异常 NoNumberException
		if(list.isEmpty()){
			throw new  NoNumberException("无整数不可以排序");
		}
		//按value排序
		List<Entry<Integer, Integer>> lowMap = new ArrayList<Map.Entry<Integer,Integer>>(hightest.entrySet());
		Collections.sort(lowMap,new Comparator<Map.Entry<Integer,Integer>>(){
			public int compare(Entry<Integer,Integer>o1,Entry<Integer,Integer>o2){
				//按升序排列
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		 return pickTopThree(lowMap);
	}
	private List<Map<Integer, Integer>> pickTopThree(List<Map.Entry<Integer, Integer>> beforePickList) {
		List<Map<Integer, Integer>> resultList = new ArrayList<Map<Integer, Integer>>();
		Map<Integer, Integer> mapFirst = new HashMap<>();
		Map<Integer, Integer> mapSecond = new HashMap<>();
		Map<Integer, Integer> mapThird = new HashMap<>();
		int count = 0;
		for (int i = 0; i < beforePickList.size()&&count<3; i++) {
			if(i>0&&beforePickList.get(i-1).getValue()!=beforePickList.get(i).getValue()) {
				count++;
			}
			switch (count) {
			case 0:
				mapFirst.put(beforePickList.get(i).getKey(), beforePickList.get(i).getValue());
				break;
			case 1:
				mapSecond.put(beforePickList.get(i).getKey(), beforePickList.get(i).getValue());
				break;
			case 2:
				mapThird.put(beforePickList.get(i).getKey(), beforePickList.get(i).getValue());
				break;
			}
		}
		resultList.add(mapFirst);
		resultList.add(mapSecond);
		resultList.add(mapThird);
		return resultList;
	}
	//清空已经填加了的整数
	public void clear(){
		list.clear();
	}
}
