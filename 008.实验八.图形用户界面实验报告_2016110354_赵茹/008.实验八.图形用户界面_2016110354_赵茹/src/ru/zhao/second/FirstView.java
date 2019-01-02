package ru.zhao.second;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FirstView extends JFrame{
	private registerDiary myRegister;
	//找回密码
	private findDialog myfindDialog;
	//组件
	//输入用户名文本框,密码
	private JTextField inputUserName,inputPassword;
	//登陆按钮,注册,密码
	private JButton loginBtn,registerBtn,exitBtn,findPassword;
	//用户名,密码
	private JLabel usernameLab, passwordLab;

	
	public void firstdiaryView() {
		
	JFrame firstdiaryView = new JFrame("日记系统");
		//容器
	JPanel firstView = new JPanel();
	
	firstView.setLayout(new GridBagLayout());
	
	firstdiaryView.setBounds(200,200,600,400);
	firstdiaryView.setVisible(true);
	//用户名按钮
	usernameLab = new JLabel("用户名");
	GridBagConstraints firstGird = new GridBagConstraints();
	 //组件左上角所在的位置,
	 firstGird.gridx = 0;
	 firstGird.gridy = 0;
	 //组件占据的行数和列数
	 firstGird.gridwidth = 1;
	 firstGird.gridheight = 1;
	 //组件大小变化的增量值，随单元格的变化
	 firstGird.weightx = 0;
	 firstGird.weighty = 0;
	 //fill：当组件在其格内而不能撑满其格时，通过 fill的值来设定填充方式，填满整个格子
	 firstGird.fill = GridBagConstraints.BOTH;
	 //外部填充
	 firstGird.insets = new Insets(2, 2, 2, 2);
//	 usernameBtn.addActionListener();
	 firstView.add(usernameLab, firstGird);
	 
	 //用户名输入框
	 inputUserName = new JTextField();
	 //将文本框固定到上边，高度为固定值，这是我们需要设置面板的高度
	 //setsize不使用布局管理器的时候使用
	 inputUserName.setPreferredSize(new Dimension(200,30));
	 //文本框输入水平对齐方式
	 inputUserName.setHorizontalAlignment(JTextField.LEFT);
	//组件左上角所在的位置,
	 firstGird.gridx = 1;
	 firstGird.gridy = 0;
	 firstGird.weightx = 0;
	 firstGird.weighty = 0;
	 firstGird.gridwidth = 4;
	 firstGird.gridheight = 1;
	 firstView.add(inputUserName, firstGird);
	 
	 //密码按钮
	 passwordLab = new JLabel("密码");
	//组件左上角所在的位置,
	 firstGird.gridx = 0;
	 firstGird.gridy = 1;
	 firstGird.weightx = 0;
	 firstGird.weighty = 0;
	 firstGird.gridwidth = 1;
	 firstGird.gridheight = 1;
	 firstView.add(passwordLab, firstGird);
	 
	 //密码输入文本框
	 inputPassword = new JTextField();
	//组件左上角所在的位置,
	 firstGird.gridx = 1;
	 firstGird.gridy = 1;
	 firstGird.weightx = 0;
	 firstGird.weighty = 0;
	 firstGird.gridwidth = 4;
	 firstGird.gridheight = 1;
	 //将文本框固定到上边，高度为固定值，这是我们需要设置面板的高度
	 //setsize不使用布局管理器的时候使用
	 inputPassword.setPreferredSize(new Dimension(200,30));
	 //文本框输入水平对齐方式
	 inputPassword.setHorizontalAlignment(JTextField.LEFT);
	 firstView.add(inputPassword, firstGird);
//	 
	 //登陆按钮
	 loginBtn = new JButton("登陆");
	//组件左上角所在的位置,
	 firstGird.gridx = 1;
	 firstGird.gridy = 3;
	 firstGird.weightx = 0;
	 firstGird.weighty = 0;
	 firstGird.gridwidth = 4;
	 firstGird.gridheight = 1;
	 firstGird.fill = GridBagConstraints.BOTH;
	 firstView.add(loginBtn, firstGird);
	 
	 //注册按钮
	 registerBtn = new JButton("新用户注册");
	//组件左上角所在的位置,
	 firstGird.gridx = 1;
	 firstGird.gridy = 2;
	 firstGird.weightx = 0;
	 firstGird.weighty = 0;
	 firstGird.gridwidth = 1;
	 firstGird.gridheight = 1;
	 firstGird.insets = new Insets(2, 2, 2, 60);
	 firstGird.fill = GridBagConstraints.NONE;
	 firstView.add(registerBtn, firstGird);
	 //设置鼠标点击事件
	 registerBtn.addMouseListener(new MouseAdapter() {
		//鼠标移入的操作
		 public void mouseEntered(MouseEvent e) {
				registerBtn.setForeground(Color.BLUE);
				registerBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				//当鼠标按下时的操作
				myRegister = new registerDiary(firstdiaryView, "注册账号", true);
				myRegister.show();
			}
			
			public void mouseExited(MouseEvent e) {//鼠标离开的操作
				registerBtn.setForeground(Color.black);
			}
	});
	 //找回密码
	 findPassword = new JButton("忘记密码？");
	 firstGird.gridx = 3;
	 firstGird.gridy = 2;
	 firstGird.weightx = 0;
	 firstGird.weighty = 0;
	 firstGird.gridwidth = 1;
	 firstGird.gridheight = 1;
	 firstGird.insets = new Insets(2, 2, 2, 2);
	 firstGird.fill = GridBagConstraints.NONE;
	 firstView.add(findPassword, firstGird);
	 findPassword.addMouseListener(new MouseAdapter() {
		 @Override
		 //鼠标移入操作
		 public void mouseEntered(MouseEvent e) {
				findPassword.setForeground(Color.BLUE);
				findPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				//当鼠标按下时的操作
//				FindDialog = new findDialog(firstdiaryView, "注册账号", true);
//				FindDialog.show();
				myfindDialog = new findDialog(firstdiaryView, "找回密码", true);
				myfindDialog.show();
			}
			
			public void mouseExited(MouseEvent e) {//鼠标离开的操作
				findPassword.setForeground(Color.black);
			}
	});
	 //退出按钮
	 exitBtn = new JButton("退出");
//	//组件左上角所在的位置,
//	 firstGird.gridx = 1;
//	 firstGird.gridy = 5;
//	 firstGird.weightx = 0;
//	 firstGird.weighty = 0;
//	 firstGird.gridwidth = 2;
//	 firstGird.gridheight = 1;
//	 firstGird.fill = GridBagConstraints.NONE;
//	 firstView.add(exitBtn, firstGird);
	 firstdiaryView.add(firstView);
	
	}
	
	public static void main(String[] args) {
		FirstView firstLogin = new FirstView();
		firstLogin.firstdiaryView();
	}
}
