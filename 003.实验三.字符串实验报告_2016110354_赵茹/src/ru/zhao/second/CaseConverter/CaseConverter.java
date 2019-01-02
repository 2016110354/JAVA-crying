package ru.zhao.second.CaseConverter;
/*
 * Auther:赵茹
 * Date:2018-10-3，10.12修改
 * Version:1.0
 *  */


import java.util.HashMap;
import java.util.Map;
public class CaseConverter {	
	public static String convert(String sentence) 
	{
		//定义数组来存储被分割了成单词的字符串,定义到足够大
		String[] newWords = new String[200];
		
		//定义一个map来存储用户输入的字符串中的特殊符号及其位置
		Map<Integer, String> symbolMap = new HashMap<Integer, String>();
		for(int i =0;i < sentence.length();i++) {
			//判断是否是特殊符号
			if(String.valueOf(sentence.charAt(i)).matches("\\W")) {
				//如果是则存入map中
				symbolMap.put(i, String.valueOf(sentence.charAt(i)));		
			}
		}
	
		//将用户输入的字符串中特殊字符等替换成空格
		sentence = sentence.replaceAll("\\W", " ");
		//遍历时遇到空格则分割单词
		newWords = sentence.split(" ");
		//存储改变之后的的字符串
		StringBuffer newSentence = new StringBuffer(sentence.length());
		//循环遍历数组，进行大小写转化
		for(int i=0;i < newWords.length;i++) {
			for(int j=0;j<newWords[i].length();j++) {
				//遍历截取单词的每个字母判断
				char newCharacter = newWords[i].charAt(j);
				if(j==0) {
					//判断是不是字母
					if(Character.isLetter(newCharacter)) {
						//若是字母，则首字符进行大写转换
						newSentence.append(Character.toUpperCase(newCharacter));
					}else {
						//若不是字母，则直接拼接
						newSentence.append(newWords[i].charAt(j));
					}
				}else {
					//剩下字母转小写				
					newSentence.append(Character.toLowerCase(newCharacter));			
				}
			}
		}
		
			for(int m = 0; m < sentence.length(); m++){
				if(symbolMap.get(m)!=null&&symbolMap.get(m)!=""){				
					//如果Map中存在符号则插入字符串
					newSentence.insert(m, symbolMap.get(m));
				}
		}
		for (int i = 0; i < newSentence.length(); i++) {
			////如果读到-
			if(String.valueOf(newSentence.charAt(i)).matches("-")) {
				//判断-后是否为字母，是则改为小写
				if(newSentence.length()>i+1&&Character.isLetter(newSentence.charAt(i+1))){	
					newSentence.replace(i+1, i+2, String.valueOf(Character.toLowerCase(newSentence.charAt(i+1))));
				}
			}
		}
		return newSentence.toString();
		}
	}


		
	 
	


		
		
		

