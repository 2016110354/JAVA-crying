package ru.zhao.first;
/*
 * Date:2018-12-8
 * Author:2016110354-zhaoru
 * Version:1-1
 */


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;


public class Calcultor extends JFrame{
	private static final int Center = 0;
	//菜单条组件
	private JMenuBar jmb;
	//菜单组件
	private JMenu menu1,menu2,menu3;
	//菜单项
	private JMenuItem item11,item12,item31,item32;
	private JRadioButtonMenuItem  item21,item22,item23;
	//文本框
	private JTextField inputText;
	//容器
	private JPanel mainJpanel,buttonJpanel;
	/*JList，列表框。JList 以列表的形式展示多个选项，允许用户选择一个或多个选项。其中的选项内容由一个 ListModel 实例来维护*/
	//列表显示
	private JList<String> rightList;
	//传值
	private DefaultListModel<String> listModel;
	//按钮
	private JButton backspaceBtn,ceBtn,cBtn,mcBtn,mrBtn,msBtn,maBtn,
	        zeroBtn,amBtn,pointBtn,addBtn,minusBtn,asteriskBtn,slashBtn,
	        sqrtBtn,onexBtn,equalBtn;
	//列表
	private JList<String> jList;
	private int listCount = 0;
	//计算器数字,动态数组
	private StringBuffer textNumber = new StringBuffer("");
//	private String [] textNum;
	
	public void calcultorFrame() {
//		this.setTitle("计算器");
		JFrame calcultor = new JFrame("计算器");
		
		calcultor.setBounds(200,200,500,300);
		//菜单栏展示
		//创建菜单
		 jmb = new JMenuBar();
		 //创建一级菜单
		 menu1 = new JMenu("编辑(E)");
		 menu2 = new JMenu("查看(V)");
		 menu3 = new JMenu("帮助(H)");
		
		
		 //创建二级菜单
		 //编辑菜单
		 item11 = new JMenuItem("复制");
		 //设置快捷键
		 item11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
//		 item11.setAccelerator(KeyStroke.getKeyStroke((char)KeyEvent.VK_C));
		 item12 = new JMenuItem("粘贴");
		 item12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		 //查看菜单
		 item21 = new JRadioButtonMenuItem("普通");
		 item22 = new JRadioButtonMenuItem("科学");
		 item23 = new JRadioButtonMenuItem("程序员");
		 
		 // 其中三个单选按钮子菜单，要实现单选按钮的效果，需要将它们放到一个按钮组中
		 ButtonGroup btnGroup = new ButtonGroup();
		 btnGroup.add(item21);
		 btnGroup.add(item22);
		 btnGroup.add(item23);
		// 默认第一个单选按钮子菜单选中
		 item21.setSelected(true);
		 //帮助菜单
		 item31 = new JMenuItem("帮助");
		 item32 = new JMenuItem("关于");
		 //点击关于之后显示软件基本信息
		 item32.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(calcultor, "软件名：计算器\n开发日期：2018-12-09\n本软件由计科学院\n"
							+ "网络工程专业赵茹开发\n学号为2016110354\n");
			}
		});

		 //将二级菜单组件添加到一级菜单
		 menu1.add(item11);
		 menu1.add(item12);
		 
		 menu2.add(item21);
		 menu2.add(item22);
		 menu2.add(item23);
		 
		 menu3.add(item31);
		 //添加一条分割线
		 menu3.addSeparator();
		 menu3.add(item32);
		 //一级菜单加入菜单
		 jmb.add(menu1);
		 jmb.add(menu2);
		 jmb.add(menu3);
		 
		 calcultor.setJMenuBar(jmb);
		
		 //计算器主要界面
		 //主要的border布局构建
		 mainJpanel = new JPanel();
		 //定义为盒式布局（上下左右）
		 mainJpanel.setLayout( new BorderLayout());
		 //用户输入框
		 inputText = new JTextField();
		//只能显示，不能编辑
		 inputText.setEditable(false);
		 //将文本框固定到上边，高度为固定值，这是我们需要设置面板的高度
		 //setsize不使用布局管理器的时候使用
		 inputText.setPreferredSize(new Dimension(300,30));
		 //文本框输入水平对齐方式
		 inputText.setHorizontalAlignment(JTextField.RIGHT);
		
		 //右侧列表框
		 listModel = new DefaultListModel<>();
		 rightList = new JList<>(listModel);
		 //选择模式,一次只能选择一个
		 rightList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 //设置大小
		 rightList.setPreferredSize(new Dimension(100, 200));
		 
		 //主要按键布局,默认布局更改为网格布局
		 buttonJpanel = new JPanel();
		 buttonJpanel.setLayout(new GridBagLayout());
		 
		 //设置各个按键的位置大小等
		 GridBagConstraints gbConstraints = new GridBagConstraints();
		 backspaceBtn = new JButton("Backspace");
		 //组件左上角所在的位置,
		 gbConstraints.gridx = 1;
		 gbConstraints.gridy = 0;
		 //组件占据的行数和列数
		 gbConstraints.gridwidth = 2;
//		 gbConstraints.gridheight = 1;
		 //组件大小变化的增量值，随单元格的变化
		 gbConstraints.weightx = 1;
		 gbConstraints.weighty = 1;
		 //fill：当组件在其格内而不能撑满其格时，通过 fill的值来设定填充方式，填满整个格子
		 gbConstraints.fill = GridBagConstraints.BOTH;
		 //对齐方式
//		 gbConstraints.anchor = Center;
		 //内部填充,确定组件大小,xy方向上加ipad
		 gbConstraints.ipadx = 20;
		 gbConstraints.ipady = 20;
		 //外部填充
		 gbConstraints.insets = new Insets(2, 2, 2, 2);
		 
		 //为按钮增加点击事件
		 backspaceBtn.addActionListener(new buttonListener());
		 buttonJpanel.add(backspaceBtn, gbConstraints);
		 
		 //组件CE
		 ceBtn = new JButton("CE");
		 //组件左上角所在的位置
		 gbConstraints.gridx = 3;
		 gbConstraints.gridy = 0;
		 gbConstraints.gridwidth = 2;
		 buttonJpanel.add(ceBtn, gbConstraints);
		 
		 //组件C
		 cBtn = new JButton("C");
		//组件左上角所在的位置,
		 gbConstraints.gridx = 5;
		 gbConstraints.gridy = 0;
		//组件占据的行数和列数
		 gbConstraints.gridwidth = 1;
		 //按钮点击增加事件
		 cBtn.addActionListener(new buttonListener());
		 buttonJpanel.add(cBtn,gbConstraints);
		 
		 //组件MC
		 mcBtn = new JButton("MC");
		//组件左上角所在的位置,
		 gbConstraints.gridx = 0;
		 gbConstraints.gridy = 1;
		 gbConstraints.gridwidth = 1;
		 
		 mcBtn.addActionListener(new buttonListener());
		 buttonJpanel.add(mcBtn,gbConstraints);
		 
		 //组件MR
		 mrBtn = new JButton("MR");
		//组件左上角所在的位置,
		 gbConstraints.gridx = 0;
		 gbConstraints.gridy = 2;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(mrBtn,gbConstraints);
		 
		 //组件MS
		 msBtn = new JButton("MS");
		//组件左上角所在的位置,
		 gbConstraints.gridx = 0;
		 gbConstraints.gridy = 3;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(msBtn,gbConstraints);
		 
		 //组件M+
		 maBtn = new JButton("M+");
		 //组件左上角所在的位置
		 gbConstraints.gridx = 0;
		 gbConstraints.gridy = 4;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(maBtn,gbConstraints);
		 
		 //组件1-9
		 int number=1;
		 for(int i=3;i>0;i--) {
			 for(int j=1;j<4;j++) {
				 JButton numberButton = new JButton(""+number);
				//组件左上角所在的位置
				 gbConstraints.gridx = j;
				 gbConstraints.gridy = i;
				 gbConstraints.gridwidth = 1;
				 //实现计算器数字按钮，按键之后在文本框添加相应的数字
				 numberButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//动态添加numButton对应的数字
						textNumber.append(numberButton.getText());
//						numText.append(numberButton.getText());
						inputText.setText(textNumber.toString());

					}
				});
				 buttonJpanel.add(numberButton, gbConstraints);
				 number++;
			 }
		 }
	
			
		 //组件0
		 zeroBtn = new JButton("0");
		 //组件左上角所在的位置
		 gbConstraints.gridx = 1;
		 gbConstraints.gridy = 4;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(zeroBtn,gbConstraints);
		 
		 //组件+/-
		 amBtn = new JButton("+/-");
		//组件左上角所在的位置
		 gbConstraints.gridx = 2;
		 gbConstraints.gridy = 4;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(amBtn,gbConstraints);
		 
		 //组件.
		 pointBtn = new JButton(".");
		//组件左上角所在的位置
		 gbConstraints.gridx = 3;
		 gbConstraints.gridy = 4;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(pointBtn,gbConstraints);
		 
		 //组件+
		 addBtn = new JButton("+");
		//组件左上角所在的位置
		 gbConstraints.gridx = 4;
		 gbConstraints.gridy = 4;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(addBtn,gbConstraints);
		 
		 //minusBtn,asteriskBtn,slashBtn,
	      //  sqrtBtn,onexBtn,equalBtn;
		 
		 //组件-
		 minusBtn = new JButton("-");
		//组件左上角所在的位置
		 gbConstraints.gridx = 4;
		 gbConstraints.gridy = 3;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(minusBtn,gbConstraints);
		 
		 //组件=
		 asteriskBtn = new JButton("*");
		//组件左上角所在的位置
		 gbConstraints.gridx = 4;
		 gbConstraints.gridy = 2;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(asteriskBtn,gbConstraints);
		 
		//组件/
		 slashBtn = new JButton("/");
		//组件左上角所在的位置
		 gbConstraints.gridx = 4;
		 gbConstraints.gridy = 1;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(slashBtn,gbConstraints);
		 
		//组件sqrt
		 sqrtBtn = new JButton("sqrt");
		//组件左上角所在的位置
		 gbConstraints.gridx = 5;
		 gbConstraints.gridy = 1;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(sqrtBtn,gbConstraints);
		 
		//组件1根号x
		 onexBtn = new JButton("1/x");
		//组件左上角所在的位置
		 gbConstraints.gridx = 5;
		 gbConstraints.gridy = 2;
		 gbConstraints.gridwidth = 1;
		 buttonJpanel.add(onexBtn,gbConstraints);
		 
		//组件=
		 equalBtn = new JButton("=");
		//组件左上角所在的位置
		 gbConstraints.gridx = 5;
		 gbConstraints.gridy = 3;
		 gbConstraints.gridwidth = 1;
		 gbConstraints.gridheight = 2;
		 //按钮点击增加事件
		 equalBtn.addActionListener(new buttonListener());
		 buttonJpanel.add(equalBtn,gbConstraints);
		 
		 //主要按钮布局
		 mainJpanel.add(inputText,BorderLayout.NORTH);
		 mainJpanel.add(buttonJpanel,BorderLayout.CENTER);
		 mainJpanel.add(rightList,BorderLayout.EAST);
		 
		 calcultor.setResizable(true);
		 //默认为不可见,设置为可见
		 calcultor.setVisible(true);
		 calcultor.add(jmb,BorderLayout.NORTH);
		 calcultor.add(mainJpanel);
		 
		
	}
	public static void main(String[] args) {
		Calcultor myCalcultor= new Calcultor();
		myCalcultor.calcultorFrame();
	}

	
	//内部类
	class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object inputSource = e.getSource();
			//等号按钮
			if(inputSource == equalBtn) {
				//判断输入是否为空，若为空则提示用户警告
				if(inputText.getText().equals("")) {
					JOptionPane.showMessageDialog(jmb,"当前文本框为空","警告", JOptionPane.WARNING_MESSAGE);
				}else {
					//文本框数字显示到右侧列表
					listModel.addElement(inputText.getText());
					listCount++;
				}
				
				//实现 Backspace 按钮，每按下一次，文本框中的数字减少一个
			}else if(inputSource == backspaceBtn) {
				if(!inputText.getText().equals("")) {
					//文本框数字减少一个
					String repString = textNumber.substring(0,textNumber.length()-1);
					//代替原来的
					textNumber.replace(0, textNumber.length(), repString);
					//输出减少之后的用户输入
					inputText.setText(textNumber.toString());
				}else {
					JOptionPane.showMessageDialog(jmb,"当前文本框为空","警告", JOptionPane.WARNING_MESSAGE);
				}
				//实现 C 按钮，按下后，文本框中的数字全部清空
			}else if(inputSource == cBtn){
				if(inputText.getText().equals("")) {
					JOptionPane.showMessageDialog(jmb,"当前文本框为空","警告", JOptionPane.WARNING_MESSAGE);
				
				}else {
				textNumber.replace(0, textNumber.length(), "");
				inputText.setText(textNumber.toString());
				}
			}else if(inputSource == mcBtn ) {
				//判空
				if(rightList.getSelectedIndex()>=0) {
					//用户选中列表框中的选项，则提示用户删除该getSelectedIndex项
					int userAnswer = JOptionPane.showConfirmDialog(jmb, "是否删除？","警告",JOptionPane.YES_NO_OPTION);
					if(userAnswer == JOptionPane.YES_OPTION) {
						listModel.removeElement(rightList.getSelectedIndex());
						listCount--;
					}
					//列表中没有任何项目，则警告用户，列表框为空。
				}else if(listCount <= 0) {
					JOptionPane.showMessageDialog(jmb, "当前列表框为空", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					//如果用户未选中列表中的任何项目，则提示用户将清空列表中的所有项目。如果用户选择是，则清空列表
					int userAnswer = JOptionPane.showConfirmDialog(jmb, "是否清空整个列表?","警告",JOptionPane.YES_NO_OPTION);
				    listModel.clear();
					listCount = 0;
				}
			}else if(inputSource == zeroBtn) {
				textNumber.append(zeroBtn.getText());
				inputText.setText(textNumber.toString());
			}else if(inputSource == addBtn) {
				StringTokenizer st1 = new StringTokenizer(inputText.getText(),"+");
				double d1,d2 = 0;
				d1 = Double.parseDouble(st1.nextToken());
				while(st1.hasMoreTokens()) {
					StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "=");
					d2 = Double.parseDouble(st2.nextToken());
				}
				inputText.setText(inputText + "" + (d1+d2));
			}
			
		}
		
	}
}
	
	

	


