package ru.zhao.second;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class registerDiary extends JFrame{

	private JDialog myregisterDialog;
	/*用户名、显示名、密码、确认密码、邮箱*/
	private JLabel usernameJLab,displaynameLab,passwordLab,truepasswordLab,emailLab;
	private JTextField inputUsername,inputDisplayname,inputPassword,inputTruepassword,inputEmail;
	private JButton okButton,exitButton;
	//用户选择回答问题
	private JLabel questionOne,questionTwo,questionThree,questionForth;
	private JTextField  inputqOne,inputqTwo,inputqThree,inputqForth;
	
public registerDiary(JFrame begin, String name, boolean collect) {
		// TODO Auto-generated constructor stub
	myregisterDialog = new JDialog(begin, name, collect);
	
	myregisterDialog.setLayout(new GridBagLayout());
	GridBagConstraints regiGrid = new GridBagConstraints();
	//
	myregisterDialog.setBounds(200, 200, 300, 400);
	usernameJLab = new JLabel("用户名");
	//当组件没有空间大时，设置组件在单元格中的对齐方式
//	regiGrid.anchor = GridBagConstraints.WEST;
	regiGrid.gridx = 0;
	regiGrid.gridy = 0;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(20, 10, 2, 2);
//	regiGrid.anchor = GridBagConstraints.CENTER;
	regiGrid.anchor = GridBagConstraints.BASELINE_LEADING;
	myregisterDialog.add(usernameJLab,regiGrid);
	
	//输入用户名
	inputUsername = new JTextField();
	regiGrid.gridx = 1;
	regiGrid.gridy = 0;
	regiGrid.gridwidth = 3;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	//setsize不使用布局管理器的时候使用
	inputUsername.setPreferredSize(new Dimension(200, 30));
	inputUsername.setHorizontalAlignment(JTextField.LEFT);
	myregisterDialog.add(inputUsername,regiGrid);
	
	displaynameLab = new JLabel("显示名");
	regiGrid.gridx = 4;
	regiGrid.gridy = 0;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 2, 2, 2);
	myregisterDialog.add(displaynameLab,regiGrid);
	
	//输入显示名
	inputDisplayname = new JTextField();
	regiGrid.gridx = 5;
	regiGrid.gridy = 0;
	regiGrid.gridwidth = 3;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 2, 2, 2);
	inputDisplayname.setPreferredSize(new Dimension(200, 30));
	myregisterDialog.add(inputDisplayname,regiGrid);
	
	passwordLab = new JLabel("密码");
	regiGrid.gridx = 0;
	regiGrid.gridy = 1;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(passwordLab,regiGrid);
	
	//输入密码
	inputPassword = new JTextField();
	regiGrid.gridx = 1;
	regiGrid.gridy = 1;
	regiGrid.gridwidth = 3;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	inputPassword.setPreferredSize(new Dimension(200, 30));
	myregisterDialog.add(inputPassword,regiGrid);
//	
	truepasswordLab = new JLabel("确认密码");
	regiGrid.gridx = 4;
	regiGrid.gridy = 1;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 2, 2, 2);
	myregisterDialog.add(truepasswordLab,regiGrid);
	
	//输入确认密码
	inputTruepassword = new JTextField();
	regiGrid.gridx = 5;
	regiGrid.gridy = 1;
	regiGrid.gridwidth = 3;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 2, 2, 2);
	inputTruepassword.setPreferredSize(new Dimension(200, 30));
	myregisterDialog.add(inputTruepassword,regiGrid);
//	
	emailLab = new JLabel("邮箱");
	regiGrid.gridx = 0;
	regiGrid.gridy = 2;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	//控制组件之间的距离，依次为上左下右
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(emailLab,regiGrid);
	
	//输入邮箱
	inputEmail = new JTextField();
	regiGrid.gridx = 1;
	regiGrid.gridy = 2;
	regiGrid.gridwidth = 5;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
//	regiGrid.fill = GridBagConstraints.BOTH;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	inputEmail.setPreferredSize(new Dimension(250, 30));
	myregisterDialog.add(inputEmail,regiGrid);
	
	//用户回答问题
	questionOne = new JLabel("你的名字");
	regiGrid.gridx = 0;
	regiGrid.gridy = 3;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(questionOne, regiGrid);
	
	inputqOne = new JTextField();
	regiGrid.gridx = 1;
	regiGrid.gridy = 3;
	regiGrid.gridwidth = 3;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
//	regiGrid.fill = GridBagConstraints.BOTH;
	inputqOne.setPreferredSize(new Dimension(250, 30));
	myregisterDialog.add(inputqOne, regiGrid);
	
	questionTwo = new JLabel("最喜欢的国家");
	regiGrid.gridx = 0;
	regiGrid.gridy = 4;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(questionTwo, regiGrid);
	
	inputqTwo = new JTextField();
	regiGrid.gridx = 1;
	regiGrid.gridy = 4;
	regiGrid.gridwidth = 3;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
//	regiGrid.fill = GridBagConstraints.BOTH;
	inputqTwo.setPreferredSize(new Dimension(250, 30));
	myregisterDialog.add(inputqTwo, regiGrid);
	
	questionThree = new JLabel("最喜欢的颜色");
	regiGrid.gridx = 0;
	regiGrid.gridy = 5;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(questionThree, regiGrid);
	
	inputqThree = new JTextField();
	regiGrid.gridx = 1;
	regiGrid.gridy = 5;
	regiGrid.gridwidth = 3;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
//	regiGrid.fill = GridBagConstraints.BOTH;
	inputqThree.setPreferredSize(new Dimension(250, 30));
	myregisterDialog.add(inputqThree, regiGrid);
	
	questionForth = new JLabel("最喜欢的食物");
	regiGrid.gridx = 0;
	regiGrid.gridy = 6;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(questionForth, regiGrid);

	inputqForth = new JTextField();
	regiGrid.gridx = 1;
	regiGrid.gridy = 6;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
//	regiGrid.fill = GridBagConstraints.BOTH;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	inputqForth.setPreferredSize(new Dimension(250, 30));
	myregisterDialog.add(inputqForth, regiGrid);
	
	okButton = new JButton("确认");
	regiGrid.gridx = 1;
	regiGrid.gridy = 7;
	regiGrid.gridwidth = 2;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	okButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!getUsername(inputUsername.getText().toString().trim())) {
				JOptionPane.showMessageDialog(myregisterDialog, "用户名不合法");
			}else if(inputDisplayname.getText().toString().trim().length()>20 || inputDisplayname.getText().toString().trim().length()<3) {
				JOptionPane.showMessageDialog(myregisterDialog,"显示名非法");
			}else if(inputPassword.getText().toString().equals("") || inputPassword.getText().toString().trim().length()>20 || inputPassword.getText().toString().trim().length()<8 ) {
				JOptionPane.showMessageDialog(myregisterDialog, "密码不合法");
			}else if(!inputPassword.getText().toString().trim().equals(inputTruepassword.getText().toString().trim())) {
				JOptionPane.showMessageDialog(myregisterDialog, "两次输入密码不一致");
			}else if(!getMail(inputEmail.getText().toString().trim())) {
				JOptionPane.showMessageDialog(myregisterDialog, "邮箱输入不合法");
			}
			String userAnswer = null;
			int num = 0;
			while(true) {
				if(!isNull(inputqOne)) {
					userAnswer = inputqOne.getText().toString().trim();
					num = 1;
					break;
				}
				if(!isNull(inputqTwo)) {
					userAnswer = inputqTwo.getText().toString().trim();
					num = 2;
					break;
					
				}
				if(!isNull(inputqThree)) {
					userAnswer = inputqThree.getText().toString().trim();
					num = 3;
					break;
				}
				if(!isNull(inputqForth)) {
					userAnswer = inputqForth.getText().toString().trim();
					num = 4;
					break;
				}
				JOptionPane.showMessageDialog(myregisterDialog, "五个问题回答一个");
				break;
			}
			User user = new User();
			user.userName.add(inputUsername.getText().toString().trim());
			user.showName.add(inputDisplayname.getText().toString().trim());
			user.userPassword.add(inputPassword.getText().toString().trim());
			user.userEmail.add(inputEmail.getText().toString().trim());
			myregisterDialog.setVisible(false);
		}
	});
	myregisterDialog.add(okButton, regiGrid);
	
	exitButton = new JButton("退出");
	regiGrid.gridx = 5;
	regiGrid.gridy = 7;
	regiGrid.gridwidth = 2;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
//	regiGrid.insets = new Insets(2, 2, 2, 2);
	exitButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			myregisterDialog.setVisible(false);
			
		}
	});
	myregisterDialog.add(exitButton, regiGrid);
	
	}
    //判断输入的用户名是否合法
	public boolean getUsername(String str) {
		if(str.equals("")) {
			return false;
		}
		//首字母为字母
		char ch = str.charAt(0);
		Character.toLowerCase(ch);
		if(ch > 'z' || ch <'a') {
			return false;
			//大于6小于20的字符数
		}else if(str.length()>20 || str.length()<6) {
			return false;
		}else {
			return true;
		}
	}
	//判断邮箱是否合法
	public boolean getMail(String str) {
		//查找字符串中特殊字符的位置返回索引1600908508@qq.com
		int indexOfAt = str.indexOf('@');
		int indexOfDot = str.indexOf('.');
		//第一个字符不为@.,‘.’不在最后,@在.之前
		if(indexOfAt >0 && indexOfDot < str.length() -1 && indexOfDot > indexOfAt) {
			return true;
		}
		return false;
	}
	//检查用户输入是否为空
    public boolean isNull(JTextField t) {
    	//trim() 方法用于删除字符串的头尾空白符。
    	return t.getText().toString().trim().equals("");
    }
	@Override
	public void show() {
		// TODO Auto-generated method stub
		myregisterDialog.pack();
		myregisterDialog.setVisible(true);
	}

}
