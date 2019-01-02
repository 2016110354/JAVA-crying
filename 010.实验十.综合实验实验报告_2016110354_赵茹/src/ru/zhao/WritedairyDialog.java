package ru.zhao;

/*
 * Author:zhaoru
 * Time:2018-12-20
 * Version:1-1
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


//写日记类
public class WritedairyDialog extends JFrame{
	//定义组件
	private JLabel userBtn;
	private String uname;
	private JTextField userInformation;
	private JDialog diaryJframe = new JDialog();
	private JPanel lists = new JPanel();
	SelectDiarydiolog select;
	//	private JLabel  myFind;
	//左侧显示列表区
	private DefaultListModel<Diary> diaryModel = new DefaultListModel<>();
	//日记列表显示区
	private JList<Diary>listArea = new JList<>(diaryModel);
	//日记计数器
	private int listNum = 0;
	//左侧列表的按钮
	private JButton addBtn,deleteBtn,clearBtn;
	private JButton seleteBtn,userInfor;
    //	String [] finds = new String[] {"按日期排序","按标题排序","按内容排序"};
	//编辑日记曲组件
	private JPanel write = new JPanel();
	//显示输入内容（天气、心情、日期、题目、内容)
	private JLabel myWeath,myMood,myDate,myTitle,myContent;
	//输入日期、题目框
	private JTextField inputDate,inputTitle;
	//输入日记内容框
	private JTextArea inputContent;
	String [] weathers = new String[] {"晴朗","多云","阴雨","冬雪"};
	String [] moods = new String[] {"大笑","哭泣","沉默","气愤"};
	//天气心情的下拉框
	JComboBox<String> weather = new JComboBox<>(weathers);
	JComboBox<String> mood = new JComboBox<>(moods);
//	JComboBox<String> find = new JComboBox<>(finds);
	//用一个JPanel装三个最后的按钮
	private JButton editBtn,noBtn,okBtn,backBtn;
	private boolean isEdit = false;
	private boolean isAdd = false;
	///定义天气心情为选中的那个
//	String newWeather = weather.getSelectedItem().toString();
//	String newMood = mood.getSelectedItem().toString();
//	private String newWeath = (String)weather.getSelectedItem();
//	private String newMood = (String)mood.getSelectedItem();
	private JLabel backgroundJl= new JLabel();

	//设置需要的字体以及颜色
	Font font = new Font("楷体", Font.BOLD, 13);
    Font font1 = new Font("宋体",Font.BOLD,15);
    Color btnColor = new Color(181, 154, 122);
    Color topColor = new Color(132,231,171);
//	private String insFind = (String)find.getSelectedItem();
//	public writedairyDialog() {
//		mainMenu();
//	}
	public WritedairyDialog(String str) {
		//用户匹配日记
		diaryJframe.setTitle(str);
		this.uname = str;
		
		mainMenu();
	}
	private void mainMenu() {
		//背景图片
		diaryJframe.setMinimumSize(new Dimension(750, 500));
		diaryJframe.setLocation(200, 150);
		
	    //设置list只能单选
		listArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		buttonListen B = new buttonListen();
		//修改默认的盒式布局
		diaryJframe.setLayout(new GridBagLayout());
		GridBagConstraints diaryGrid = new GridBagConstraints();
		//列表区用GridBag布局
		lists.setLayout(new GridBagLayout());
		GridBagConstraints listGrid = new GridBagConstraints();
		//边框
		lists.setBorder(BorderFactory.createLoweredBevelBorder());
		//将listArea放到列表上方
		listArea.setBorder(BorderFactory.createRaisedBevelBorder());
		listArea.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				showInfo();
			}
		});
		
		//按钮组件
		seleteBtn = new JButton("分类查询");
		seleteBtn.setFont(font);
		seleteBtn.setBackground(topColor);
		//分类查询按钮最左边fin
		listGrid.fill = GridBagConstraints.HORIZONTAL;
		listGrid.gridx = 0;
		listGrid.gridy = 0;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(2, 23, 2, 20);
		lists.add(seleteBtn, listGrid);
		seleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				select =  new SelectDiarydiolog(uname);
				select.show();
				
			}
		});
		
		//按钮组件
//		JPanel inforJpanel = new JPanel();
		userInfor = new JButton("软件信息");
		userInfor.setFont(font);
		userInfor.setBackground(topColor);

		listGrid.fill = GridBagConstraints.HORIZONTAL;
		listGrid.gridx = 1;
		listGrid.gridy = 0;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(2, 30, 2, 2);
		
		lists.add(userInfor, listGrid);
		userInfor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(diaryJframe, "软件名：追忆.记事\n开发日期：2018-12-28\n本软件由计科学院\n"
						+ "网络工程专业赵茹开发\n学号为2016110354\n");
			}
		});
		
		//listArea组件
		listGrid.fill = GridBagConstraints.BOTH;
		listGrid.gridx = 0;
		listGrid.gridy = 1;
		listGrid.gridwidth = 4;
		listGrid.gridheight =4;
		listGrid.weightx = 1.0;
		listGrid.weighty = 1.0;
		listGrid.insets = new Insets(10, 23, 2, 20);
		listArea.setFont(font);
		lists.add(listArea,listGrid);
		//按钮组件
//		JPanel addJpanel = new JPanel();
		addBtn = new JButton("新建");
		addBtn.setFont(font);
		addBtn.setBackground(btnColor);
		addBtn.setFocusPainted(false);
		listGrid.gridx = 0;
		listGrid.gridy = 6;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 23, 2, 5);
		lists.add(addBtn, listGrid);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//			    Object source = e.getSource();
				
				//点击新建可以再右侧框进行重新输入日记
				inputDate.setEditable(true);
				inputTitle.setEditable(true);
				inputContent.setEditable(true);
				
				inputDate.setText("");
				inputTitle.setText("");
				inputContent.setText("");
				isAdd = true;
			}
		});
		
		deleteBtn = new JButton("删除");
		deleteBtn.setFont(font);
		deleteBtn.setBackground(btnColor);
		listGrid.fill = GridBagConstraints.HORIZONTAL;
		listGrid.gridx = 1;
		listGrid.gridy = 6;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 10, 2, 5);
		deleteBtn.setOpaque(true);
		
//		deleteBtn.setBackground(new Color(170, 116, 12));
//		deleteBtn.setFocusPainted(false);
		lists.add(deleteBtn,listGrid);
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(listArea.getSelectedIndex()>=0) {
					int answer = JOptionPane.showConfirmDialog(diaryJframe,"是否删除","警告", JOptionPane.YES_NO_OPTION);
					if(answer == JOptionPane.YES_OPTION) {
						Diary myDiary =listArea.getSelectedValue();
						Date myDate = myDiary.getDate();
						String content = myDiary.getContent();
						diaryModel.removeElementAt(listArea.getSelectedIndex());
						//匹配数据库第一种
						DiarySql.deleteDiary(myDate, uname);
//						diarySql.sql(1,myDate,uname,content);
						listNum--;
					}
				}else if(listNum <= 0) {
					JOptionPane.showMessageDialog(diaryJframe, "列表为空");
				}else {
					JOptionPane.showMessageDialog(diaryJframe, "没有选中");
				}
			}
		});

		
//		JPanel clearJPnel = new JPanel();
		clearBtn = new JButton("全部清除");
		clearBtn.setFont(font);
		clearBtn.setBackground(btnColor);
		listGrid.fill = GridBagConstraints.HORIZONTAL;
		listGrid.gridx = 2;
		listGrid.gridy = 6;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 1.0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10,10, 2, 20);
//		listBtnJpan.add(clearBtn, listGrid);
		lists.add(clearBtn,listGrid);
		clearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(listNum <= 0) {
					JOptionPane.showMessageDialog(diaryJframe, "列表框为空");
				}else {
					int answer = JOptionPane.showConfirmDialog(diaryJframe, "是否清空?","警告",JOptionPane.YES_NO_OPTION);
					if(answer == JOptionPane.YES_OPTION) {
//						for(int i=listNum-1;i>=0;i--) {
							diaryModel.clear();
							//引用删除
							DiarySql.clearDiary(uname);
//							diarySql.sql(2,null,uname,null);
							listNum = 0;
//						}
					}
				}
			}
		});
//		clearBtn.addActionListener(B);
		//将列表区放在主布局的左边
		diaryGrid.fill = GridBagConstraints.BOTH;
		lists.setFont(font);
//		lists.setOpaque(false);
		lists.setBackground(new Color(79, 124, 141));
		diaryGrid.gridx = 0;
		diaryGrid.gridy = 0;
		diaryGrid.gridwidth = 1;
		diaryGrid.gridheight = 1;
		diaryGrid.weightx = 1.0;
		diaryGrid.weighty = 1.0;
		diaryJframe.add(lists, diaryGrid);
		//编辑区用GridBagLayout布局
		write.setLayout(new GridBagLayout());
		GridBagConstraints wrGrid = new GridBagConstraints();
		//JPanel添加边框
		write.setBorder(BorderFactory.createLoweredBevelBorder());

		myWeath = new JLabel("天气");
		//当组件没有空间大时，设置组件在单元格中的对齐方式
		myWeath.setFont(font1);
		listGrid.anchor = GridBagConstraints.EAST;
		listGrid.fill = GridBagConstraints.NONE;
		listGrid.gridx = 0;
		listGrid.gridy = 0;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(20, 10, 2, 2);
		write.add(myWeath,listGrid);
		
		//选择
		listGrid.fill = GridBagConstraints.HORIZONTAL;
		weather.setFont(font);
		listGrid.gridx = 1;
		listGrid.gridy = 0;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 1.0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(20, 2, 2, 2);
		write.add(weather,listGrid);
		
		
		myMood = new JLabel("心情");
		myMood.setFont(font1);
		listGrid.fill = GridBagConstraints.NONE;
		listGrid.anchor = GridBagConstraints.EAST;
		listGrid.gridx = 2;
		listGrid.gridy = 0;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(20, 2, 2, 2);
		write.add(myMood,listGrid);
		
		//选择
		listGrid.fill = GridBagConstraints.HORIZONTAL;
		mood.setFont(font);
		listGrid.gridx = 3;
		listGrid.gridy = 0;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 1.0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(20, 2, 2, 20);
		write.add(mood,listGrid);
		
		myDate = new JLabel("日期");
		myDate.setFont(font1);
		listGrid.fill = GridBagConstraints.NONE;
		listGrid.anchor = GridBagConstraints.EAST;
		listGrid.gridx = 0;
		listGrid.gridy = 1;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 2);
		write.add(myDate,listGrid);
		
		//输入日期
		inputDate = new JTextField(8);
		inputDate.setFont(font1);
		listGrid.fill = GridBagConstraints.HORIZONTAL;
		inputDate.setHorizontalAlignment(JTextField.LEFT);
		listGrid.gridx = 1;
		listGrid.gridy = 1;
		listGrid.gridwidth = 3;
		listGrid.gridheight =1;
		listGrid.weightx = 1.0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 20);
		write.add(inputDate,listGrid);
		
		//标题
		myTitle = new JLabel("标题");
		myTitle.setFont(font1);
		listGrid.fill = GridBagConstraints.NONE;
		listGrid.anchor = GridBagConstraints.EAST;
		listGrid.gridx = 0;
		listGrid.gridy = 2;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 2);
		write.add(myTitle,listGrid);
		
		//输入标题
		inputTitle = new JTextField();
		inputTitle.setFont(font1);
		listGrid.fill = GridBagConstraints.HORIZONTAL;
		inputTitle.setHorizontalAlignment(JTextField.LEFT);
		listGrid.gridx = 1;
		listGrid.gridy = 2;
		listGrid.gridwidth = 3;
		listGrid.gridheight =1;
		listGrid.weightx = 1.0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 20);
		write.add(inputTitle,listGrid);
		
		//内容
		myContent = new JLabel("内容");
		myContent.setFont(font1);
		listGrid.fill = GridBagConstraints.NONE;
		listGrid.anchor = GridBagConstraints.EAST;
		listGrid.gridx = 0;
		listGrid.gridy = 5;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 2);
		write.add(myContent,listGrid);
		
		
		inputContent = new JTextArea(8,10);
		inputContent.setFont(font1);
		JScrollPane scroll = new JScrollPane(inputContent);
		listGrid.fill = GridBagConstraints.BOTH;
//		listGrid.anchor = GridBagConstraints.EAST;
		listGrid.gridx = 1;
		listGrid.gridy = 5;
		listGrid.gridwidth = 3;
		listGrid.gridheight =2;
		listGrid.weightx = 1.0;
		listGrid.weighty = 1.0;
		listGrid.insets = new Insets(10, 2, 2, 20);
		write.add(inputContent,listGrid);
		
		editBtn = new JButton("编辑");
		editBtn.setFont(font);
		editBtn.setBackground(btnColor);
		JPanel editJpanel = new JPanel();
		editJpanel.setOpaque(false);
		//默认
		editJpanel.setLayout(new BorderLayout());
		editJpanel.add(editBtn);
		listGrid.fill = GridBagConstraints.NONE;
		listGrid.anchor = GridBagConstraints.WEST;
		listGrid.gridx = 1;
		listGrid.gridy = 7;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 2);
		write.add(editJpanel,listGrid);
		editBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x = listArea.getSelectedIndex();
				if(x==-1) {
					JOptionPane.showMessageDialog(null, "没有选中任何项目！", "警告",JOptionPane.WARNING_MESSAGE);
				}else {
					inputContent.setEditable(true);
					inputDate.setEditable(false);
					inputTitle.setEditable(false);
					isEdit = true;
				}
			}
		});
//		editBtn.addActionListener(B);
		
		noBtn = new JButton("取消");
		noBtn.setFont(font);
		noBtn.setBackground(btnColor);
		JPanel noJpanel = new JPanel();
		noJpanel.setOpaque(false);
		noJpanel.add(noBtn);
		listGrid.fill = GridBagConstraints.NONE;
		listGrid.anchor = GridBagConstraints.CENTER;
		listGrid.gridx = 2;
		listGrid.gridy = 7;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 2);
		write.add(noJpanel, listGrid);
		write.setBackground(new Color(79, 124, 141));
		noBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = listArea.getSelectedIndex();
				if(i >= 0) {
					showInfo();
				}
			}
		});
//		noBtn.addActionListener(B);
		
		okBtn = new JButton("确认");
		okBtn.setFont(font);
		okBtn.setBackground(btnColor);
		JPanel okJpanel = new JPanel();
		okJpanel.setOpaque(false);
		okJpanel.add(okBtn);
		listGrid.fill = GridBagConstraints.NONE;
		listGrid.anchor = GridBagConstraints.EAST;
		listGrid.gridx = 3;
		listGrid.gridy = 7;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 20);
		write.add(okJpanel, listGrid);
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(isAdd) {
					if(!Date.JudgeDate(inputDate.getText().toString().trim())) {
						JOptionPane.showMessageDialog(diaryJframe, "日期格式不正确");
					}else if(inputTitle.getText().toString().trim().length()<0 || inputTitle.getText().toString().trim().length()>12) {
						JOptionPane.showMessageDialog(diaryJframe, "标题格式不正确");
					}else {
						Date date = new Date(inputDate.getText().toString().trim());
						Diary newDiary = new Diary(date, uname, inputTitle.getText().toString().trim(),
								inputContent.getText().toString().trim());
						
						diaryModel.addElement(newDiary);
						listNum++;
						listArea.setSelectedValue(newDiary, true);
						//建立与数据库的连接
						Connection conn = getConnection();
						String newWeather = weather.getSelectedItem().toString();
						String newMood = mood.getSelectedItem().toString();
						if(conn!=null) {
							DiarySql.addDiary(conn, newDiary, newWeather, newMood);
							try {
								conn.close();
							}catch (SQLException error) {
								// TODO: handle exception
								error.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(diaryJframe, "连接失败");
						}
						isAdd = false;
					}
				}if(isEdit) {
					Diary diary = listArea.getSelectedValue();
					System.out.println(inputContent.getText().toString().trim());
					diary.setContent(inputContent.getText().toString().trim());
				    DiarySql.updateDiary(diary.getDate(), uname, inputContent.getText().toString().trim());
//					diarySql.sql(3, diary.getDate(), uname, inputContent.getText().toString().trim());
				    isEdit = false;
					listArea.setSelectedValue(diary, true);
					showInfo();
				}
				
			}
		});
		
		diaryGrid.fill = GridBagConstraints.BOTH;
		diaryGrid.gridx = 1;
		diaryGrid.gridy = 0;
		diaryGrid.gridwidth = 1;
		diaryGrid.gridheight = 1;
		diaryGrid.weightx = 1.0;
		diaryGrid.weighty = 1.0;
		
		diaryJframe.add(write, diaryGrid);
		inputDate.setEditable(false);
		inputTitle.setEditable(false);
		inputContent.setEditable(false);
		
		//diaryJframe.pack();
		diaryJframe.setVisible(true);
		
	}

	//
	private void showInfo() {
		Diary diary = listArea.getSelectedValue();
		inputDate.setEditable(true);
		inputTitle.setEditable(true);
		inputContent.setEditable(true);
		inputDate.setText("");
		inputTitle.setText("");
		inputContent.setText("");
		if(diary != null) {
			inputDate.setText(diary.getDate().toString());
			inputTitle.setText(diary.getTitle());
			inputContent.setText(diary.getContent());
		}else {
		inputDate.setEditable(false);
		inputTitle.setEditable(false);
		inputContent.setEditable(false);
	}
	}
	//列表框显示
	public void show() {
		
		Diary showDiary;
		//设置连接
		Connection conn = getConnection();
		//结果集
		ResultSet rs = null;
		//查询并输出信息
		PreparedStatement stmt = null;
		ArrayList<Diary> diarys = new ArrayList<>();
		//加载驱动
		try {
			if(conn!=null && !conn.isClosed()) {
				System.out.println("Succeeded connection to the Diary Database!");
				PreparedStatement pstmt = null;
				
				//查询语句
				String sql = "select * from diary where uname = ?";
				pstmt = conn.prepareStatement(sql);
				//将用户名赋值给？
				pstmt.setString(1, uname);
				//将用户所对应的日记存放到结果集中
				rs = pstmt.executeQuery();
				//ResultSet的游标下移，类似于Iterator
				while(rs.next()) {
					//将用户名匹配的用户日记重新定义为新日记输出
					Date date = new Date(rs.getString(1));
					String uname = rs.getString(2);
					String tital = rs.getString(5);
					String content = rs.getString(6);
					showDiary = new Diary(date, uname, tital, content);
//					showDiary = new Diary((Date)rs.getObject(1),rs.getString(2),
//							rs.getString(5),rs.getString(6)); 
					diarys.add(showDiary);
					
					if (diarys.size()==0){
						JOptionPane.showMessageDialog(null, "不存在该关键字的日记");
					}else {
						System.out.println(diarys);
						diaryModel.clear();
						for(int i = 0;i<diarys.size();i++) {
							diaryModel.addElement(diarys.get(i));
						}
					}
//					diaryModel.addElement(showDiary);
					listNum++;
				}
				
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//关闭rs(结果集）、statement（查询语句）和connection(s），！！注意关闭顺序
			if(null!=rs) {
				try {
					rs.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}if(null!=stmt) {
				try {
					stmt.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}if(null!=conn) {
				try {
					conn.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		diaryJframe.setVisible(true);
		
		
	}

	//将连接的方法单独写在函数里面
	public static Connection getConnection() {
		Connection conn = null;
		//驱动程序名
		String  driver = "com.mysql.jdbc.Driver";
		//URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://localhost:3306/diary?characterEncoding=utf8";
		//MySQL配置时的用户名
		String user = "root";
		//MySQL配置时的密码
		String password = "root";
		//遍历查询结果集
		try {
			//加载驱动程序
			Class.forName(driver);
			//1.getConnection()方法，连接MySQL数据库!!
			conn = DriverManager.getConnection(url,user,password);
			if(conn!= null && !conn.isClosed()) {
				System.out.println("Succeeded connection to the diary Database!");
			}
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	public String getUname() {
		return uname;
	}

}
