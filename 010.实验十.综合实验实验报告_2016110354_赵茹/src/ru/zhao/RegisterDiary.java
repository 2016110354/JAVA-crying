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
import javax.swing.border.MatteBorder;
//注册类
public class RegisterDiary extends JFrame{
//	private JPanel reJp = new JPanel();
	private JDialog myregisterDialog;
	/*用户名、显示名、密码、确认密 、邮箱*/
	private JLabel backgroundJl = new JLabel();
	private JLabel usernameJLab,displaynameLab,passwordLab,truepasswordLab,emailLab;
	private JTextField inputUsername,inputDisplayname,inputPassword,inputTruepassword,inputEmail;
	private JButton okButton,exitButton;
	//用户选择回答问题
	private JLabel questionOne,questionTwo,questionThree,questionForth;
	private JTextField  inputqOne,inputqTwo,inputqThree,inputqForth;
    //密保问题选择一个提示
	private JLabel choice;
	public RegisterDiary(JFrame begin, String name, boolean collect) {
		// TODO Auto-generated constructor stub
	myregisterDialog = new JDialog(begin, name, collect);
	myregisterDialog.setResizable(false);
	myregisterDialog.setLayout(new GridBagLayout());
	GridBagConstraints regiGrid = new GridBagConstraints();
	//把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
//	  reJp.setOpaque(false); 
//	myregisterDialog.setBounds(200, 200, 300, 400);
	myregisterDialog.setMinimumSize(new Dimension(350, 400));
	myregisterDialog.setLocation(300, 250);
	((JPanel)this.getContentPane()).setOpaque(false);
	Icon background = new ImageIcon("ico/re.png");
    backgroundJl = new JLabel(background); 
    myregisterDialog.getLayeredPane().add(backgroundJl, new Integer(Integer.MIN_VALUE));
    backgroundJl.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
    Container cp=myregisterDialog.getContentPane();
   // 把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
    ((JPanel)cp).setOpaque(false);
    
  //设置字体颜色
  	Font font = new Font("宋体", Font.BOLD, 16);
  	Font font1 = new Font("宋体", Font.PLAIN, 14);
  	Font font2 = new Font("宋体", Font.PLAIN, 16);

    //	backgroundJl.setMinimumSize(new Dimension(this.getHeight(), this.getWidth()));
//	// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
//	JPanel imagePanel = (JPanel) this.getContentPane();
//	imagePanel.setOpaque(false);
//	// 把背景图片添加到分层窗格的最底层作为背景
//	myregisterDialog.add(backgroundJl, new Integer(Integer.MIN_VALUE));


//	myregisterDialog.add(backgroundJl);
	
	usernameJLab = new JLabel("用户名");
	
//	Font.Style := [fsBold];
	usernameJLab.setFont(font);
	usernameJLab.setForeground(Color.WHITE);
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
	
	MatteBorder border = new MatteBorder(0, 0, 0, 0, new Color(192, 192,
			192));
	
	//输入用户名
	inputUsername = new RoundJTextField(15);
	inputUsername.setFont(font);
//	inputUsername.setBorder(border);
	inputUsername.setForeground(Color.white);
	regiGrid.gridx = 1;
	regiGrid.gridy = 0;
	regiGrid.gridwidth = 3;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	//setsize不使用布局管理器的时候使用
	inputUsername.setPreferredSize(new Dimension(200, 30));
//	inputUsername.setHorizontalAlignment(JTextField.LEFT);
	myregisterDialog.add(inputUsername,regiGrid);
	
	displaynameLab = new JLabel("显示名");
	displaynameLab.setFont(font);
	displaynameLab.setBorder(border);
	displaynameLab.setForeground(Color.WHITE);
	regiGrid.gridx = 4;
	regiGrid.gridy = 0;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(displaynameLab,regiGrid);
	
	//输入显示名
	inputDisplayname = new RoundJTextField(15);
	inputDisplayname.setFont(font);
	inputDisplayname.setForeground(Color.WHITE);
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
	passwordLab.setBorder(border);
	passwordLab.setFont(font);
	passwordLab.setForeground(Color.WHITE);
	regiGrid.gridx = 0;
	regiGrid.gridy = 1;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(passwordLab,regiGrid);
	
	//输入密码
	inputPassword = new RoundJTextField(15);
	inputPassword.setFont(font);
	inputPassword.setForeground(Color.white);
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
	truepasswordLab.setFont(font);
	truepasswordLab.setBorder(border);

	truepasswordLab.setForeground(Color.white);
	regiGrid.gridx = 4;
	regiGrid.gridy = 1;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 2, 2, 2);
	myregisterDialog.add(truepasswordLab,regiGrid);
	
	//输入确认密码
	inputTruepassword = new RoundJTextField(15);
	inputTruepassword.setFont(font);
	inputTruepassword.setForeground(Color.WHITE);
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
	emailLab.setBorder(border);

	emailLab.setFont(font);
	emailLab.setForeground(Color.white);
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
	inputEmail = new RoundJTextField(20);
	inputEmail.setFont(font);
	inputEmail.setForeground(Color.white);
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
	questionOne.setBorder(border);

	questionOne.setFont(font);
	questionOne.setForeground(Color.white);

	regiGrid.gridx = 0;
	regiGrid.gridy = 3;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(questionOne, regiGrid);
	
	inputqOne = new RoundJTextField(20);
	inputqOne.setForeground(Color.white);
	inputqOne.setFont(font);
	regiGrid.gridx = 1;
	regiGrid.gridy = 3;
	regiGrid.gridwidth = 3;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
//	regiGrid.fill = GridBagConstraints.BOTH;
	inputqOne.setPreferredSize(new Dimension(250, 30));
	myregisterDialog.add(inputqOne, regiGrid);
	
	choice = new JLabel("(请选择一个回答)");
	choice.setForeground(Color.BLACK);
	choice.setFont(font1);
	regiGrid.gridx = 4;
	regiGrid.gridy = 3;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	myregisterDialog.add(choice, regiGrid);
	
	questionTwo = new JLabel("家庭住址");
	questionTwo.setBorder(border);
	questionTwo.setFont(font);
	questionTwo.setForeground(Color.white);
	regiGrid.gridx = 0;
	regiGrid.gridy = 4;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(questionTwo, regiGrid);
	
	inputqTwo = new RoundJTextField(20);
	inputqTwo.setForeground(Color.white);
	inputqTwo.setFont(font);
	regiGrid.gridx = 1;
	regiGrid.gridy = 4;
	regiGrid.gridwidth = 3;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
//	regiGrid.fill = GridBagConstraints.BOTH;
	inputqTwo.setPreferredSize(new Dimension(250, 30));
	myregisterDialog.add(inputqTwo, regiGrid);
	
	JLabel choice1 = new JLabel("(请选择一个回答)");
	choice1.setForeground(Color.BLACK);
	choice1.setFont(font1);
	regiGrid.gridx = 4;
	regiGrid.gridy = 4;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	myregisterDialog.add(choice1, regiGrid);
	
	questionThree = new JLabel("你的年龄");
	questionThree.setBorder(border);

	questionThree.setFont(font);
	questionThree.setForeground(Color.white);

	regiGrid.gridx = 0;
	regiGrid.gridy = 5;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(questionThree, regiGrid);
	
	inputqThree = new RoundJTextField(20);
	inputqThree.setForeground(Color.white);
	inputqThree.setFont(font);
	regiGrid.gridx = 1;
	regiGrid.gridy = 5;
	regiGrid.gridwidth = 3;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
//	regiGrid.fill = GridBagConstraints.BOTH;
	inputqThree.setPreferredSize(new Dimension(250, 30));
	myregisterDialog.add(inputqThree, regiGrid);
	
	JLabel choice2 = new JLabel("(请选择一个回答)");
	choice2.setForeground(Color.BLACK);
	choice2.setFont(font1);
	regiGrid.gridx = 4;
	regiGrid.gridy = 5;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	myregisterDialog.add(choice2, regiGrid);
	
	questionForth = new JLabel("电话号码");
	questionForth.setBorder(border);
	questionForth.setFont(font);
	questionForth.setForeground(Color.white);
	regiGrid.gridx = 0;
	regiGrid.gridy = 6;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	
	regiGrid.insets = new Insets(2, 10, 2, 2);
	myregisterDialog.add(questionForth, regiGrid);

	inputqForth = new RoundJTextField(20);
	inputqForth.setForeground(Color.white);
	inputqForth.setFont(font);
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
	
	JLabel choice3 = new JLabel("(请选择一个回答)");
	choice3.setForeground(Color.BLACK);
	choice3.setFont(font1);
	regiGrid.gridx = 4;
	regiGrid.gridy = 6;
	regiGrid.gridwidth = 1;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	myregisterDialog.add(choice3, regiGrid);
	
	okButton = new JButton("确认");
	regiGrid.gridx = 1;
	regiGrid.gridy = 7;
	regiGrid.gridwidth = 2;
	regiGrid.gridheight = 1;
	regiGrid.weightx = 1.0;
	regiGrid.weighty = 0;
	regiGrid.insets = new Insets(20, 2, 2, 2);
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
			User user = new User(inputUsername.getText().toString().trim(),inputDisplayname.getText().toString().trim(),inputPassword.getText().toString().trim(),inputEmail.getText().toString().trim(),num,userAnswer);
			MySql.sql(1, user, null, null, null);
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
	regiGrid.insets = new Insets(20, 2, 2, 2);
	exitButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			myregisterDialog.setVisible(false);
			
		}
	});
	myregisterDialog.add(exitButton, regiGrid);
//	myregisterDialog.add(reJp);
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
