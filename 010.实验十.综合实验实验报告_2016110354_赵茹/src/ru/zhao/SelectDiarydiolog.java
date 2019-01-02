package ru.zhao;

/*
 * Author:zhaoru
 * Time:2018-12-20
 * Version:1-1
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//查询日记类


public class SelectDiarydiolog extends JFrame {
	//局面定义三个容器
	private JDialog selectDiary = new JDialog();
	private JPanel leftJp = new JPanel();
	private JPanel rightJp = new JPanel();
	private JPanel bottomJp = new JPanel();
	public String unameSelect ;
	//定义lable
//	private JPanel username;
	private JLabel weather;
	private JLabel mood;
	private JLabel date;
	private JLabel title;
	private JLabel content;
	//定义查询输入框
//	private JTextField inputUsername;
	private JTextField inputWeather;
	private JTextField inputMood;
	private JTextField inputDate;
	private JTextField inputTitle;
	private JTextArea inputContent;
	
	private DefaultListModel driayModel = new DefaultListModel();
	private JList listArea = new JList(driayModel);
	private JScrollPane listJs;
	//定义底部选择按钮
	JRadioButton weaherSe = new JRadioButton("按天气查询", false);
	JRadioButton moodSe = new JRadioButton("按心情查询", false);
	JRadioButton dateSe = new JRadioButton("按日期查询", false);
	JRadioButton titleSe = new JRadioButton("按标题查询", false);
	JRadioButton contentSe = new JRadioButton("按内容查询", false);
	//定义底部按钮
	JButton selectBtn = new JButton("查询");
	JButton exitBtn = new JButton("退出");
	ButtonGroup bg = new ButtonGroup();
	
	//定义背景以及按钮颜色、字体
	Font font3 = new Font("楷体", Font.BOLD, 12);
	Font font = new Font("楷体", Font.BOLD, 15);
    Font font1 = new Font("仿宋",Font.BOLD,15);
    Color bacColor = new Color(93, 129, 119);
    Color btnColor = new Color(189,125,33);
    
    private static int chooseFagle;
    private static String choice;
    private static String text;
	public SelectDiarydiolog(String str) {
		selectDiary.setTitle(str);
		this.unameSelect = str;
		init();
	}
//	public static void main(String[] args) {
//		selectDiarydiolog select  = new selectDiarydiolog();
//		select.init();
//		select.show();
//		
//	}

	public void init() {
//		selectDiary.setVisible(true);
		selectDiary.setLocation(250, 250);
		selectDiary.setMinimumSize(new Dimension(800, 450));
		//修改默认布局
//		selectDiary.setLayout(new GridBagLayout());
		leftJp.setLayout(new GridBagLayout());
		rightJp.setBackground(bacColor);
		rightJp.setLayout(new GridBagLayout());
		bottomJp.setBackground(bacColor);
		bottomJp.setLayout(new GridBagLayout());
		
		GridBagConstraints seGrid = new GridBagConstraints();
		
		driayModel.addElement("  ");
		//详细布局
		weather = new JLabel("*按天气查询*");
		weather.setFont(font1);
		seGrid.fill = GridBagConstraints.NONE;
		seGrid.anchor = GridBagConstraints.EAST;
		seGrid.gridx = 0;
		seGrid.gridy = 0;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 10, 2);
		leftJp.add(weather,seGrid);
		
		
		inputWeather = new JTextField(20);
		inputWeather.setFont(font1);
//		inputWeather.setOpaque(true);
//		inputWeather.setBackground(Color.white);
		seGrid.fill = GridBagConstraints.HORIZONTAL;
		seGrid.gridx = 1;
		seGrid.gridy = 0;
		seGrid.gridwidth = 1;
		seGrid.gridheight = 1;
		seGrid.weightx = 1.0;
		seGrid.weighty = 0;
		inputWeather.setHorizontalAlignment(JTextField.LEFT);
		inputWeather.setPreferredSize(new Dimension(200,30));
		seGrid.insets = new Insets(10, 2, 10, 2);
		leftJp.add(inputWeather,seGrid);
		
		mood = new JLabel("*按心情查询*");
		mood.setFont(font1);
		seGrid.fill = GridBagConstraints.NONE;
		seGrid.anchor = GridBagConstraints.EAST;
		seGrid.gridx = 0;
		seGrid.gridy = 1;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 10, 2);
		leftJp.add(mood,seGrid);
		
		
		inputMood = new JTextField(20);
		inputMood.setFont(font1);
		seGrid.fill = GridBagConstraints.HORIZONTAL;
		inputMood.setHorizontalAlignment(JTextField.LEFT);
		seGrid.gridx = 1;
		seGrid.gridy = 1;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 1.0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 10, 2);
		inputMood.setPreferredSize(new Dimension(200,30));

		leftJp.add(inputMood,seGrid);
		
		date = new JLabel("*按日期查询*");
		date.setFont(font1);
		seGrid.fill = GridBagConstraints.NONE;
		seGrid.anchor = GridBagConstraints.EAST;
		seGrid.gridx = 0;
		seGrid.gridy = 2;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 10, 2);
		leftJp.add(date,seGrid);
		
		
		inputDate = new JTextField(20);
		inputDate.setFont(font1);
		seGrid.fill = GridBagConstraints.HORIZONTAL;
		inputDate.setHorizontalAlignment(JTextField.LEFT);
		seGrid.gridx = 1;
		seGrid.gridy = 2;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 1.0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 10, 2);
		inputDate.setPreferredSize(new Dimension(200,30));

		leftJp.add(inputDate,seGrid);
		
		title = new JLabel("*按标题查询*");
		title.setFont(font1);
		seGrid.fill = GridBagConstraints.NONE;
		seGrid.anchor = GridBagConstraints.EAST;
		seGrid.gridx = 0;
		seGrid.gridy = 3;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 10, 2);
		leftJp.add(title,seGrid);
		
		
		inputTitle = new JTextField(20);
		inputTitle.setFont(font1);
		seGrid.fill = GridBagConstraints.HORIZONTAL;
		inputTitle.setHorizontalAlignment(JTextField.LEFT);
		seGrid.gridx = 1;
		seGrid.gridy = 3;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 1.0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 10, 2);
		inputTitle.setPreferredSize(new Dimension(200,30));

		leftJp.add(inputTitle,seGrid);
		
		content = new JLabel("*按内容查询*");
		content.setFont(font1);
		seGrid.fill = GridBagConstraints.NONE;
		seGrid.anchor = GridBagConstraints.EAST;
		seGrid.gridx = 0;
		seGrid.gridy = 4;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 10, 2);
		leftJp.add(content,seGrid);
		
		
		inputContent = new JTextArea();
//		inputContent.setOpaque(false);
		inputContent.setFont(font1);
		seGrid.fill = GridBagConstraints.HORIZONTAL;
//		inputContent.setHorizontalAlignment(JTextField.LEFT);
		seGrid.gridx = 1;
		seGrid.gridy = 4;
		seGrid.gridwidth = 1;
		seGrid.gridheight = 5;
		seGrid.weightx = 1.0;
		seGrid.weighty = 0;
		inputContent.setPreferredSize(new Dimension(250, 100));
		seGrid.insets = new Insets(10, 2, 10, 2);
		leftJp.add(inputContent,seGrid);
		
		leftJp.setBackground(bacColor);
		leftJp.setBorder(BorderFactory.createLoweredBevelBorder());
		rightJp.setBorder(BorderFactory.createLoweredBevelBorder());
		
//		listArea.setBorder(BorderFactory.createRaisedBevelBorder());
		//将列表去添加再右侧jp里面
		
//		seGrid.fill = GridBagConstraints.BOTH;
		listArea.setPreferredSize(new Dimension(400,300));
		seGrid.gridx = 0;
		seGrid.gridy = 0;
		seGrid.gridwidth = 1;
		seGrid.gridheight = 1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(0, 0, 0, 0);
//		listArea.setBackground(Color.blue);
		listArea.setFont(font3);
		
//		listArea.setSize(300,450);
//		listArea.setVisibleRowCount(20);
		//设置滚动条
//		listJs = new JScrollPane(listArea);
//		rightJp.add(listJs);
		listArea.setOpaque(true);
		rightJp.add(listArea, seGrid);
		
		//底部选择按钮加入群组
		bg.add(weaherSe);
		bg.add(moodSe);
		bg.add(dateSe);
		bg.add(titleSe);
		bg.add(contentSe);
	
		weaherSe.setFont(font);
		moodSe.setFont(font);
		dateSe.setFont(font);
		titleSe.setFont(font);
		contentSe.setFont(font);
		seGrid.gridx = 0;
		seGrid.gridy = 0;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 2, 20);  
		weaherSe.setOpaque(false);
		bottomJp.add(weaherSe,seGrid);
		weaherSe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputWeather.setEditable(true);
				inputWeather.setText("");
				chooseFagle = 1;
				choice = "weather";
			}
		});
		
		seGrid.gridx = 1;
		seGrid.gridy = 0;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 2, 20);  
		moodSe.setOpaque(false);
		bottomJp.add(moodSe,seGrid);
		moodSe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputMood.setEditable(true);
				inputMood.setText("");
				chooseFagle = 2;
				choice = "mood";
			}
		});
		
		seGrid.gridx = 2;
		seGrid.gridy = 0;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 2, 20);  
		dateSe.setOpaque(false);
		bottomJp.add(dateSe,seGrid);
		dateSe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputDate.setEditable(true);
				inputDate.setText("");
				chooseFagle = 3;
				choice = "dates";
			}
		});
		
		seGrid.gridx = 3;
		seGrid.gridy = 0;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 2, 20); 
		titleSe.setOpaque(false);
		bottomJp.add(titleSe,seGrid);
		titleSe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputTitle.setEditable(true);
				inputTitle.setText("");
				chooseFagle = 4;
				choice = "tital";
			}
		});
		
		seGrid.gridx = 4;
		seGrid.gridy = 0;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 2, 20);  
		contentSe.setOpaque(false);
		bottomJp.add(contentSe,seGrid);
		contentSe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputContent.setEditable(true);
				inputContent.setText("");
				chooseFagle = 5;
				choice = "content";
			}
		});
		
		
		seGrid.gridx = 1;
		seGrid.gridy = 1;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 2, 2);  
		exitBtn.setFont(font);
		exitBtn.setBackground(btnColor);
		bottomJp.add(exitBtn,seGrid);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectDiary.setVisible(false);
			}
		});
		
		seGrid.gridx = 3;
		seGrid.gridy = 1;
		seGrid.gridwidth = 1;
		seGrid.gridheight =1;
		seGrid.weightx = 0;
		seGrid.weighty = 0;
		seGrid.insets = new Insets(10, 2, 2, 2);  
		selectBtn.setFont(font);
		selectBtn.setBackground(btnColor);
		bottomJp.add(selectBtn,seGrid);
		
		selectBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chooseSelect();
			}
		});
		
		selectDiary.add(leftJp, BorderLayout.WEST);
		selectDiary.add(rightJp, BorderLayout.CENTER);
		selectDiary.add(bottomJp, BorderLayout.SOUTH);
		
		inputWeather.setEditable(false);
		inputMood.setEditable(false);
		inputDate.setEditable(false);
		inputTitle.setEditable(false);
		inputContent.setEditable(false);
		

	}
	public void show() {
		selectDiary.setVisible(true);
//		selectDiary.pack();
	}
	
	//点击选择按钮之后进行数据库查询
	public void chooseSelect()
	{
		if(chooseFagle==1)
		{
			text=inputWeather.getText().toString().trim();
			ArrayList<Diary> aList = new ArrayList(SelectdiarySql.selectDiary(1, text, null, null, null, null, unameSelect));
			if (aList.size()==0){
				JOptionPane.showMessageDialog(rightJp, "不存在该关键字的日记");
			}else {
				System.out.println(aList);
				for(int i = 0;i<aList.size();i++) {
					driayModel.addElement(aList.get(i));
				}
			}

		}
		else if(chooseFagle==2)
		{
			text=inputMood.getText().toString().trim();
//			finddiarySql.selectDiary(2, null, text, null, null, null, unameSelect);
			ArrayList<Diary> aList = new ArrayList(SelectdiarySql.selectDiary(2, null, text, null, null, null, unameSelect));
			if (aList.size()==0){
				JOptionPane.showMessageDialog(rightJp, "不存在该关键字的日记");
			}else {
				System.out.println(aList);
				for(int i = 0;i<aList.size();i++) {
					driayModel.addElement(aList.get(i));
				}
			}
		}
		else if(chooseFagle==3)
		{
			text=inputDate.getText().toString().trim();
//			finddiarySql.selectDiary(4, null, null, text, null, null, unameSelect);
			ArrayList<Diary> aList = new ArrayList(SelectdiarySql.selectDiary(3, null, null, text, null, null, unameSelect));
			if (aList.size()==0){
				JOptionPane.showMessageDialog(rightJp, "不存在该关键字的日记");
			}else {
				System.out.println(aList);
				for(int i = 0;i<aList.size();i++) {
					driayModel.addElement(aList.get(i));
				}
			}
		}
		else if(chooseFagle==4)
		{
			text=inputTitle.getText().toString().trim();
//			finddiarySql.selectDiary(4, null, null, null, text, null, unameSelect);
			ArrayList<Diary> aList = new ArrayList(SelectdiarySql.selectDiary(4, null, null, null, text, null, unameSelect));
			if (aList.size()==0){
				JOptionPane.showMessageDialog(rightJp, "不存在该关键字的日记");
			}else {
				System.out.println(aList);
				for(int i = 0;i<aList.size();i++) {
					driayModel.addElement(aList.get(i));
				}
			}
		}
		else 
		{
			
			text=inputContent.getText().toString().trim();
			SelectdiarySql.selectDiary(5, null, null, null, null, text, unameSelect);
			ArrayList<Diary> aList = new ArrayList(SelectdiarySql.selectDiary(5, null, null, null, null, text, unameSelect));
			if (aList.size()==0){
				JOptionPane.showMessageDialog(rightJp, "不存在该关键字的日记");
			}else {
				System.out.println(aList);
				for(int i = 0;i<aList.size();i++) {
					driayModel.addElement(aList.get(i));
				}
			}
		}
	}
	
	
	

}
