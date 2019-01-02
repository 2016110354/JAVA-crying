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
	
	//����洢�ַ��Լ�Ƶ�ʵ�Map�ӿ�
	
	private Map<String,Integer> letterFre = new TreeMap<String,Integer>();
	//��¼�ܵ���ĸ����
	private int letterCount;
	//����ļ������ַ�
	private char[] fileletter;
	// public boolean loadFile(File file)������ȡ�ļ����������Լ��ַ�����treemap��
	public boolean loadFile(File file) {
		try {
			if(file.exists()) {
				//���ļ��г��ֵĶ�ʮ������ĸתΪ��
				for(char i='a';i<='z';i++) {
					String str = String.valueOf(i);
					letterFre.put(str, 0);
				}
				//��ȡ�ļ�
					Reader reader = null;
					reader = new FileReader(file);
					//�����ļ��ĳ��ȶ�������ַ�������ĳ���
					fileletter = new char[(char)file.length()];
					//���ļ���Ķ������ַ���ʽȫ������charFile������
					for(int j=0;j<fileletter.length;j++){
						fileletter[j] = (char)reader.read();
					}
					reader.close();
					//����ĸ���ֵĴ���ѹ���ֵ����
					for(int m=0;m<fileletter.length;m++) {
						if((fileletter[m]>='a'&&fileletter[m]<='z') || (fileletter[m]>='A'&&fileletter[m]<='Z')) {
							//���ַ�����ͳ��
							letterCount++;
							//����Ǵ�д��ĸ����ת��ΪСд��ĸͳ��Ƶ��
							if(fileletter[m]>='A'&&fileletter[m]<='Z') {
								fileletter[m] = (char)((int)fileletter[m] + 32);
							}
							//���������е���ĸ��ȡֵ
							String str = String.valueOf(fileletter[m]);
							//����ͳ��Ƶ�ʣ������ж�Ӧ����ĸ�������һ
							letterFre.put(str, letterFre.get(str)+1);
						}
					}

					System.out.println("�ַ�����Ϊ: "+letterCount);
					System.out.println("��ӡletterFre��ÿ���ַ������ľ��������");
					System.out.println(letterFre);				
					return true;
				}else {
					System.err.println("���ļ�������");
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
				//���ļ��г��ֵĶ�ʮ������ĸתΪ��
				for(char i='a';i<='z';i++) {
					String str = String.valueOf(i);
					letterFre.put(str, 0);
				}
				//��ȡ�ļ�
					Reader reader = null;
					reader = new FileReader(file1);
					//�����ļ��ĳ��ȶ�������ַ�������ĳ���
					fileletter = new char[(char)file1.length()];
					//���ļ���Ķ������ַ���ʽȫ������charFile������
					for(int j=0;j<fileletter.length;j++){
						fileletter[j] = (char)reader.read();
					}
					reader.close();
					//����ĸ���ֵĴ���ѹ���ֵ����
					for(int m=0;m<fileletter.length;m++) {
						if((fileletter[m]>='a'&&fileletter[m]<='z') || (fileletter[m]>='A'&&fileletter[m]<='Z')) {
							//���ַ�����ͳ��
							letterCount++;
							//����Ǵ�д��ĸ����ת��ΪСд��ĸͳ��Ƶ��
							if(fileletter[m]>='A'&&fileletter[m]<='Z') {
								fileletter[m] = (char)((int)fileletter[m] + 32);
							}
							//���������е���ĸ��ȡֵ
							String str = String.valueOf(fileletter[m]);
							//����ͳ��Ƶ�ʣ������ж�Ӧ����ĸ�������һ
							letterFre.put(str, letterFre.get(str)+1);
						}
					}

					System.out.println("�ַ�����Ϊ: "+letterCount);
					System.out.println("��ӡletterFre��ÿ���ַ������ľ��������");
					System.out.println(letterFre);				
					return true;
				}else {
					System.err.println("���ļ�������");
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	//public double getFrequency(char a)��������ȡĳ����ĸ���ֵ�Ƶ��
	public double getFrequency(char letter) {
		double count = 0;
		//��֤�Ƿ�Ϊ�ַ���,��дת��Сд
		if(letter>='A'&&letter<='Z') {
			letter = (char)((int)letter + 32);
		}
		String str = String.valueOf(letter);
		//�����ַ����ִ���
		count = letterFre.get(str);
		//���ַ����ִ������ܴ�����Ƶ��
		if(letterCount == 0) {
			return letterCount;
		}
		return count/letterCount * 100;
	}
	//�� 26 ����ĸ��˳���ӡ��ÿ����ĸ���ֵ�Ƶ��
	public void printFrienquecies() {
		double value = 0;
		for(char i='a';i<='z';i++) {
			value = getFrequency(i);
			//��ӡ��ӡÿ����ĸ���ֵĴ���
//			System.out.printf("%s:%.1f%s\n",i,value);
			System.out.printf("%c:%.1f%%\n",i,value);

		}
	}
	public static void main(String[] args) {
		LetterFrequencyCounter lefrequency = new LetterFrequencyCounter();
		//�����ļ�
		File file2 = new File("D:" + File.separator + "demo.txt");
		//��ȡͳ��Ƶ��
		if(lefrequency.loadFile(file2)) {
			System.out.println("��ӡ�ļ���ÿ���ַ����ֵ�Ƶ��");
			lefrequency.printFrienquecies();
		}
		System.out.println("\n");
		LetterFrequencyCounter lefrequency1 = new LetterFrequencyCounter();
		if(lefrequency1.loadFile("demo3.txt")) {
			System.out.println("��ӡ�ļ���ÿ���ַ����ֵ�Ƶ��");
			lefrequency1.printFrienquecies();
		}
//		System.out.println("\n");
//		LetterFrequencyCounter lefrequency2 = new LetterFrequencyCounter();
//		if(lefrequency2.loadFile("demo3.txt")) {
//			System.out.println("��ӡ�ļ���ÿ���ַ����ֵ�Ƶ��");
//			lefrequency2.printFrienquecies();
//		}
		LetterFrequencyCounter lefrequency2 = new LetterFrequencyCounter();
		//�����ļ�
		File file3 = new File("D:" + File.separator + "demo6.txt");
		//��ȡͳ��Ƶ��
		if(lefrequency2.loadFile(file3)) {
			System.out.println("��ӡ�ļ���ÿ���ַ����ֵ�Ƶ��");
			lefrequency2.printFrienquecies();
		}
//		
	}		
}
			
