package ru.zhao.first;
/*
 * Author:zhaoru
 * Date:2018-11-28
 * Version:1.0
 */
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;
import java.util.TreeMap;

public class LetterFrequencyCounter {
	
	//定义存储字符以及频率的Map接口
	
	private Map<String,Integer> letterFre = new TreeMap<String,Integer>();
	//记录总的字母次数
	private int letterCount;
	//存放文件里面字符
	private char[] fileletter;
	// public boolean loadFile(File file)方法读取文件，将次数以及字符存入treemap中
	public boolean loadFile(File file) {
		try {
			if(file.exists()) {
				//将文件中出现的二十六个字母转为键
				for(char i='a';i<='z';i++) {
					String str = String.valueOf(i);
					letterFre.put(str, 0);
				}
				//读取文件
					Reader reader = null;
					reader = new FileReader(file);
					//根据文件的长度定义接收字符的数组的长度
					fileletter = new char[(char)file.length()];
					//将文件里的东西以字符形式全部放入charFile数组中
					for(int j=0;j<fileletter.length;j++){
						fileletter[j] = (char)reader.read();
					}
					reader.close();
					//将字母出现的次数压入键值对中
					for(int m=0;m<fileletter.length;m++) {
						if((fileletter[m]>='a'&&fileletter[m]<='z') || (fileletter[m]>='A'&&fileletter[m]<='Z')) {
							//总字符数的统计
							letterCount++;
							//如果是大写字母，则转化为小写字母统计频率
							if(fileletter[m]>='A'&&fileletter[m]<='Z') {
								fileletter[m] = (char)((int)fileletter[m] + 32);
							}
							//遍历数组中的字母，取值
							String str = String.valueOf(fileletter[m]);
							//计算统计频率，数组中对应的字母则次数加一
							letterFre.put(str, letterFre.get(str)+1);
						}
					}

					System.out.println("字符总数为: "+letterCount);
					System.out.println("打印letterFre中每个字符次数的具体情况：");
					System.out.println(letterFre);				
					return true;
				}else {
					System.err.println("该文件不存在");
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	public boolean loadFile(String file) {
		try {
			File file1 = new File(file);
			if(file1.exists()) {
				//将文件中出现的二十六个字母转为键
				for(char i='a';i<='z';i++) {
					String str = String.valueOf(i);
					letterFre.put(str, 0);
				}
				//读取文件
					Reader reader = null;
					reader = new FileReader(file1);
					//根据文件的长度定义接收字符的数组的长度
					fileletter = new char[(char)file1.length()];
					//将文件里的东西以字符形式全部放入charFile数组中
					for(int j=0;j<fileletter.length;j++){
						fileletter[j] = (char)reader.read();
					}
					reader.close();
					//将字母出现的次数压入键值对中
					for(int m=0;m<fileletter.length;m++) {
						if((fileletter[m]>='a'&&fileletter[m]<='z') || (fileletter[m]>='A'&&fileletter[m]<='Z')) {
							//总字符数的统计
							letterCount++;
							//如果是大写字母，则转化为小写字母统计频率
							if(fileletter[m]>='A'&&fileletter[m]<='Z') {
								fileletter[m] = (char)((int)fileletter[m] + 32);
							}
							//遍历数组中的字母，取值
							String str = String.valueOf(fileletter[m]);
							//计算统计频率，数组中对应的字母则次数加一
							letterFre.put(str, letterFre.get(str)+1);
						}
					}

					System.out.println("字符总数为: "+letterCount);
					System.out.println("打印letterFre中每个字符次数的具体情况：");
					System.out.println(letterFre);				
					return true;
				}else {
					System.err.println("该文件不存在");
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	//public double getFrequency(char a)方法来获取某个字母出现的频率
	public double getFrequency(char letter) {
		double count = 0;
		//验证是否为字符型,大写转化小写
		if(letter>='A'&&letter<='Z') {
			letter = (char)((int)letter + 32);
		}
		String str = String.valueOf(letter);
		//单个字符出现次数
		count = letterFre.get(str);
		//但字符出现次数与总次数算频率
		if(letterCount == 0) {
			return letterCount;
		}
		return count/letterCount * 100;
	}
	//按 26 个字母的顺序打印出每个字母出现的频率
	public void printFrienquecies() {
		double value = 0;
		for(char i='a';i<='z';i++) {
			value = getFrequency(i);
			//打印打印每个字母出现的次数
//			System.out.printf("%s:%.1f%s\n",i,value);
			System.out.printf("%c:%.1f%%\n",i,value);

		}
	}
	public static void main(String[] args) {
		LetterFrequencyCounter lefrequency = new LetterFrequencyCounter();
		//定义文件
		File file2 = new File("D:" + File.separator + "demo.txt");
		//读取统计频率
		if(lefrequency.loadFile(file2)) {
			System.out.println("打印文件中每个字符出现的频率");
			lefrequency.printFrienquecies();
		}
		System.out.println("\n");
		LetterFrequencyCounter lefrequency1 = new LetterFrequencyCounter();
		if(lefrequency1.loadFile("demo3.txt")) {
			System.out.println("打印文件中每个字符出现的频率");
			lefrequency1.printFrienquecies();
		}
//		System.out.println("\n");
//		LetterFrequencyCounter lefrequency2 = new LetterFrequencyCounter();
//		if(lefrequency2.loadFile("demo3.txt")) {
//			System.out.println("打印文件中每个字符出现的频率");
//			lefrequency2.printFrienquecies();
//		}
		LetterFrequencyCounter lefrequency2 = new LetterFrequencyCounter();
		//定义文件
		File file3 = new File("D:" + File.separator + "demo6.txt");
		//读取统计频率
		if(lefrequency2.loadFile(file3)) {
			System.out.println("打印文件中每个字符出现的频率");
			lefrequency2.printFrienquecies();
		}
//		
	}		
}
			
