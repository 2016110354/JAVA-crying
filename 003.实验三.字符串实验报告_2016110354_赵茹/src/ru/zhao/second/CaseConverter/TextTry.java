package ru.zhao.second.CaseConverter;
/*
 * Auther:赵茹
 * Date:2018-10-3
 * Version:1.0
 *  */


import java.util.Scanner;

public class TextTry {
	 public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);		
			System.out.println("请输入字符串:");		
			String sentence = scan.nextLine();
			//scan.close();		
			System.out.println("转换后的字符串为: "+ "\n"+ CaseConverter.convert(sentence) );			
			}

}
