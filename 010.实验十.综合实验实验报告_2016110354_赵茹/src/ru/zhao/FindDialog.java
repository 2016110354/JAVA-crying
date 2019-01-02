package ru.zhao;

/*
 * Author:zhaoru
 * Time:2018-12-20
 * Version:1-1
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//用户寻找密码对话框类
public class FindDialog extends JFrame {
	private JDialog findPass;
	//定义label，按钮、等组件
	private JLabel userName,newPass,okPass,userAnswer;
	private JTextField inputUname,inputPass,inputOkpass,inputAnsw;
	private JButton okBtn,exitBtn;
	private JLabel backgroundJl = new JLabel();
	public FindDialog(JFrame begin,String name,boolean collect) {
		//设置对话窗口属性
		findPass = new JDialog(begin, name, collect);
		findPass.setLayout(new GridBagLayout());
		findPass.setResizable(false);
		GridBagConstraints findGrid = new GridBagConstraints();
//		findPass.setBounds(200, 200, 300, 400);
		findPass.setMinimumSize(new Dimension(300,300));
		findPass.setLocation(300, 250);
		((JPanel)this.getContentPane()).setOpaque(false);
		Icon background = new ImageIcon("ico/find4.jpg");
	    backgroundJl = new JLabel(background); 
	    //加到控制面板
	    findPass.getLayeredPane().add(backgroundJl, new Integer(Integer.MIN_VALUE));
	    backgroundJl.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
	    Container cp=findPass.getContentPane();
	    //可以让图形可见
	    ((JPanel)cp).setOpaque(false);
	    
	    Font font = new Font("宋体", Font.BOLD, 16);

	    //组件具体布局
		userName = new  JLabel("用户名");
		userName.setFont(font);
		userName.setForeground(Color.white);
		findGrid.gridx = 0;
		findGrid.gridy = 0;
		findGrid.gridwidth = 1;
		findGrid.gridheight = 1;
		findGrid.weightx = 0;
		findGrid.weighty = 0;
		//单元格对齐方式
//		findGrid.anchor = GridBagConstraints.WEST;
		findGrid.anchor = GridBagConstraints.BASELINE_LEADING;
		findGrid.insets = new Insets(20, 10, 2, 2);//控制组件之间的距离，依次为上左下右
		findPass.add(userName, findGrid);
		
		inputUname = new RoundJTextField(20);
		inputUname.setFont(font);
		inputUname.setForeground(Color.WHITE);
		findGrid.gridx = 1;
		findGrid.gridy = 0;
		findGrid.gridwidth = 3;
		findGrid.gridheight = 1;
		findGrid.weightx = 1.0;
		findGrid.weighty = 0;
		//文本输入框水平对齐方式
		inputUname.setHorizontalAlignment(JTextField.LEFT);
		inputUname.setPreferredSize(new Dimension(200,30));
		findGrid.insets = new Insets(20, 2, 2, 2);
		findPass.add(inputUname, findGrid);
		
		userAnswer = new  JLabel("密保答案");
		userAnswer.setForeground(Color.WHITE);
		userAnswer.setFont(font);
		findGrid.gridx = 0;
		findGrid.gridy = 1;
		findGrid.gridwidth = 1;
		findGrid.gridheight = 1;
		findGrid.weightx = 0;
		findGrid.weighty = 0;
		//单元格对齐方式
//		findGrid.anchor = GridBagConstraints.CE/NTER;
		findGrid.anchor = GridBagConstraints.BASELINE_LEADING;
		findGrid.insets = new Insets(2, 10, 10, 2);//控制组件之间的距离，依次为上左下右
		findPass.add(userAnswer, findGrid);
		
		inputAnsw = new RoundJTextField(20);
		inputAnsw.setFont(font);
		inputAnsw.setForeground(Color.WHITE);
		findGrid.gridx = 1;
		findGrid.gridy = 1;
		findGrid.gridwidth = 3;
		findGrid.gridheight = 1;
		findGrid.weightx = 1.0;
		findGrid.weighty = 0;
		//文本输入框水平对齐方式
		inputAnsw.setHorizontalAlignment(JTextField.LEFT);
		inputAnsw.setPreferredSize(new Dimension(200,30));
		findGrid.insets = new Insets(2, 2, 2, 2);
		findPass.add(inputAnsw, findGrid);
		
		
		newPass = new  JLabel("密码");
		newPass.setForeground(Color.WHITE);
		newPass.setFont(font);
		findGrid.gridx = 0;
		findGrid.gridy = 2;
		findGrid.gridwidth = 1;
		findGrid.gridheight = 1;
		findGrid.weightx = 0;
		findGrid.weighty = 0;
		findGrid.anchor = GridBagConstraints.BASELINE_LEADING;
		findGrid.insets = new Insets(2, 10, 2, 2);
		findPass.add(newPass, findGrid);
		
		inputPass = new RoundJTextField(20);
		inputPass.setFont(font);
		inputPass.setForeground(Color.WHITE);
		findGrid.gridx = 1;
		findGrid.gridy = 2;
		findGrid.gridwidth = 3;
		findGrid.gridheight = 1;
		findGrid.weightx = 1.0;
		findGrid.weighty = 0;
		inputPass.setHorizontalAlignment(JTextField.LEFT);
		inputPass.setPreferredSize(new Dimension(200,30));
		findGrid.insets = new Insets(2, 2, 2, 2);
		findPass.add(inputPass, findGrid);
		
		
		okPass = new  JLabel("确认密码");
		okPass.setForeground(Color.white);
		okPass.setFont(font);
		findGrid.gridx = 0;
		findGrid.gridy = 3;
		findGrid.gridwidth = 1;
		findGrid.gridheight = 1;
		findGrid.weightx = 0;
		findGrid.weighty = 0;
		findGrid.anchor = GridBagConstraints.BASELINE_LEADING;
		findGrid.insets = new Insets(2, 10, 2, 2);
		findPass.add(okPass, findGrid);
		
		
		inputOkpass = new RoundJTextField(20);
		inputOkpass.setFont(font);
		inputOkpass.setForeground(Color.WHITE);
		findGrid.gridx = 1;
		findGrid.gridy = 3;
		findGrid.gridwidth = 3;
		findGrid.gridheight = 1;
		findGrid.weightx = 1.0;
		findGrid.weighty = 0;
		inputOkpass.setHorizontalAlignment(JTextField.LEFT);
		inputOkpass.setPreferredSize(new Dimension(200,30));
		findGrid.insets = new Insets(2, 2, 2, 2);
		findPass.add(inputOkpass, findGrid);
		
		okBtn = new JButton("确认");
		findGrid.gridx = 1;
		findGrid.gridy = 4;
		findGrid.gridwidth = 1;
		findGrid.gridheight = 1;
		findGrid.weightx = 1.0;
		findGrid.weighty = 0;
		findGrid.insets = new Insets(2, 2, 2, 2);
		findPass.add(okBtn, findGrid);
		//确认之后修改密码
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isNull(inputUname))
					JOptionPane.showMessageDialog(findPass, "用户名不能为空");
				else if(isNull(inputAnsw))
					JOptionPane.showMessageDialog(findPass, "密保答案不能为空");
				else if(isNull(inputPass) || inputPass.getText().toString().trim().length() > 30 || 
						inputPass.getText().toString().trim().length() < 8)
					JOptionPane.showMessageDialog(findPass, "新密码非法");
				else if(!inputOkpass.getText().toString().trim().equals(
						inputPass.getText().toString().trim()))
					JOptionPane.showMessageDialog(findPass, "密码不一致");
				else {
					String uname = inputUname.getText().toString().trim();
					String ans = inputAnsw.getText().toString().trim();
					String pwd = inputPass.getText().toString().trim();
					MySql.sql(3, null,uname,ans,pwd);
					findPass.setVisible(false);
				}
			}
		});
	
		exitBtn = new JButton("退出");
		findGrid.gridx = 2;
		findGrid.gridy = 4;
		findGrid.gridwidth = 1;
		findGrid.gridheight = 1;
		findGrid.weightx = 1.0;
		findGrid.weighty = 0;
		findGrid.insets = new Insets(2, 2, 2, 2);
		findGrid.anchor = GridBagConstraints.EAST;
		findPass.add(exitBtn, findGrid);
		
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				findPass.setVisible(false);
				
			}
		});
}
	
//	private JPanel getContentPane() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//判断文本框输入是否为空
	public boolean isNull(JTextField t) {
		return t.getText().toString().trim().equals("");
	}
	
	public void show() {
		findPass.pack();
		findPass.setVisible(true);
	}
}