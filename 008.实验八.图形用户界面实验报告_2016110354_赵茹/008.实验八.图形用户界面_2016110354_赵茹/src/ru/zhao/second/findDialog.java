package ru.zhao.second;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.ReflectionException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class findDialog {
	private JDialog findPass;
	private JLabel userName,newPass,okPass,userAnswer;
	private JTextField inputUname,inputPass,inputOkpass,inputAnsw;
	private JButton okBtn,exitBtn;
	
	public findDialog(JFrame begin,String name,boolean collect) {
		findPass = new JDialog(begin, name, collect);
		findPass.setLayout(new GridBagLayout());
		GridBagConstraints findGrid = new GridBagConstraints();
		findPass.setBounds(200, 200, 300, 400);

		userName = new  JLabel("用户名");
		findGrid.gridx = 0;
		findGrid.gridy = 0;
		findGrid.gridwidth = 1;
		findGrid.gridheight = 1;
		findGrid.weightx = 0;
		findGrid.weighty = 0;
		//单元格对齐方式
		findGrid.anchor = GridBagConstraints.CENTER;
//		findGrid.anchor = GridBagConstraints.BASELINE_LEADING;
		findGrid.insets = new Insets(20, 10, 2, 2);//控制组件之间的距离，依次为上左下右
		findPass.add(userName, findGrid);
		
		inputUname = new JTextField();
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
		
		
		newPass = new  JLabel("密码");
		findGrid.gridx = 0;
		findGrid.gridy = 1;
		findGrid.gridwidth = 1;
		findGrid.gridheight = 1;
		findGrid.weightx = 0;
		findGrid.weighty = 0;
		findGrid.anchor = GridBagConstraints.CENTER;
		findGrid.insets = new Insets(2, 10, 2, 2);
		findPass.add(newPass, findGrid);
		
		inputPass = new JTextField();
		findGrid.gridx = 1;
		findGrid.gridy = 1;
		findGrid.gridwidth = 3;
		findGrid.gridheight = 1;
		findGrid.weightx = 1.0;
		findGrid.weighty = 0;
		inputPass.setHorizontalAlignment(JTextField.LEFT);
		inputPass.setPreferredSize(new Dimension(200,30));
		findGrid.insets = new Insets(2, 2, 2, 2);
		findPass.add(inputPass, findGrid);
		
		
		okPass = new  JLabel("确认密码");
		findGrid.gridx = 0;
		findGrid.gridy = 2;
		findGrid.gridwidth = 1;
		findGrid.gridheight = 1;
		findGrid.weightx = 0;
		findGrid.weighty = 0;
		findGrid.anchor = GridBagConstraints.CENTER;
		findGrid.insets = new Insets(2, 10, 2, 2);
		findPass.add(okPass, findGrid);
		
		
		inputOkpass = new JTextField();
		findGrid.gridx = 1;
		findGrid.gridy = 2;
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
		findGrid.gridy = 3;
		findGrid.gridwidth = 1;
		findGrid.gridheight = 1;
		findGrid.weightx = 1.0;
		findGrid.weighty = 0;
		findGrid.insets = new Insets(2, 2, 2, 2);
		findPass.add(okBtn, findGrid);
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
//					Sql.sql(3, null,uname,ans,pwd);
					findPass.setVisible(false);
				}
			}
		});
		
		exitBtn = new JButton("退出");
		findGrid.gridx = 3;
		findGrid.gridy = 3;
		findGrid.gridwidth = 1;
		findGrid.gridheight = 1;
		findGrid.weightx = 1.0;
		findGrid.weighty = 0;
		findGrid.insets = new Insets(2, 2, 2, 2);
		findPass.add(exitBtn, findGrid);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				findPass.setVisible(false);
				
			}
		});
	}
	
	public boolean isNull(JTextField t) {
		return t.getText().toString().trim().equals("");
	}
	
	public void show() {
		findPass.pack();
		findPass.setVisible(true);
	}
}