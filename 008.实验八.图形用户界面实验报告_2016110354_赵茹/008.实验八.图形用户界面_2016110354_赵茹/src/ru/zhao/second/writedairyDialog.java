package ru.zhao.second;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class writedairyDialog {
	private JFrame diaryJframe = new JFrame();
	private JPanel lists = new JPanel();
//	private JLabel  myFind;
	//左侧显示列表区
	private DefaultListModel<Diary> diaryModel = new DefaultListModel<>();
	private JList<Diary>listArea = new JList<>(diaryModel);
	private int listNum = 0;
	private JButton addBtn,deleteBtn,clearBtn;
//	String [] finds = new String[] {"按日期排序","按标题排序","按内容排序"};
	//编辑日记曲组件
	private JPanel write = new JPanel();
	private JLabel myWeath,myMood,myDate,myTitle,myContent;
	private JTextField inputDate,inputTitle;
	private JTextArea inputContent;
	String [] weathers = new String[] {"晴朗","多云","阴雨","冬雪"};
	String [] moods = new String[] {"大笑","哭泣","沉默","气愤"};
	//天气心情的下拉框
	JComboBox<String> weather = new JComboBox<>(weathers);
	JComboBox<String> mood = new JComboBox<>(moods);
//	JComboBox<String> find = new JComboBox<>(finds);
	//用一个JPanel装三个最后的按钮
	private JButton editBtn,noBtn,okBtn;
	private boolean isEdit = false;
	private boolean isAdd = false;
	private String insWeath = (String)weather.getSelectedItem();
	private String insMood = (String)mood.getSelectedItem();
//	private String insFind = (String)find.getSelectedItem();
	
	public void mainMenu() {
		//设置list只能单选
		listArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		buttonListen B = new buttonListen();
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
//				showInfo();
			}
		});
		//listArea组件
		listGrid.fill = GridBagConstraints.BOTH;
		listGrid.gridx = 0;
		listGrid.gridy = 0;
		listGrid.gridwidth = 4;
		listGrid.gridheight =4;
		listGrid.weightx = 1.0;
		listGrid.weighty = 1.0;
		listGrid.insets = new Insets(10, 20, 2, 20);
		
		lists.add(listArea,listGrid);
		//按钮组件
		JPanel addJpanel = new JPanel();
		addBtn = new JButton("新建");
		addJpanel.setLayout(new BorderLayout());
		addJpanel.add(addBtn,BorderLayout.EAST);
		//分类查询按钮最左边fin
		listGrid.fill = GridBagConstraints.HORIZONTAL;
		listGrid.gridx = 0;
		listGrid.gridy = 5;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 1.0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 2);
		lists.add(addJpanel, listGrid);
		addBtn.addActionListener(B);
		
		deleteBtn = new JButton("删除");
		JPanel deleteJpanel = new JPanel();
		deleteJpanel.add(deleteBtn,BorderLayout.CENTER);
		listGrid.fill = GridBagConstraints.HORIZONTAL;
		listGrid.gridx = 1;
		listGrid.gridy = 5;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 1.0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 2);
		lists.add(deleteJpanel,listGrid);
		deleteBtn.addActionListener(B);
		
		JPanel clearJPnel = new JPanel();
		clearBtn = new JButton("全部清除");
		clearJPnel.setLayout(new BorderLayout());
		clearJPnel.add(clearBtn,BorderLayout.EAST);
		listGrid.fill = GridBagConstraints.HORIZONTAL;
		listGrid.gridx = 2;
		listGrid.gridy = 5;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 1.0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 10);
//		listBtnJpan.add(clearBtn, listGrid);
		lists.add(clearJPnel,listGrid);
		clearBtn.addActionListener(B);
		//将列表区放在主布局的左边
		diaryGrid.fill = GridBagConstraints.BOTH;
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
		listGrid.gridx = 1;
		listGrid.gridy = 0;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 1.0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(20, 2, 2, 2);
		write.add(weather,listGrid);
		
		
		myMood = new JLabel("心情");
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
		listGrid.gridx = 3;
		listGrid.gridy = 0;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 1.0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(20, 2, 2, 20);
		write.add(mood,listGrid);
		
		myDate = new JLabel("日期");
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
		listGrid.fill = GridBagConstraints.NONE;
		listGrid.anchor = GridBagConstraints.EAST;
		listGrid.gridx = 0;
		listGrid.gridy = 3;
		listGrid.gridwidth = 1;
		listGrid.gridheight =1;
		listGrid.weightx = 0;
		listGrid.weighty = 0;
		listGrid.insets = new Insets(10, 2, 2, 2);
		write.add(myContent,listGrid);
		
		inputContent = new JTextArea(8,10);
		JScrollPane scroll = new JScrollPane(inputContent);
		listGrid.fill = GridBagConstraints.BOTH;
//		listGrid.anchor = GridBagConstraints.EAST;
		listGrid.gridx = 1;
		listGrid.gridy = 3;
		listGrid.gridwidth = 3;
		listGrid.gridheight =2;
		listGrid.weightx = 1.0;
		listGrid.weighty = 1.0;
		listGrid.insets = new Insets(10, 2, 2, 20);
		write.add(inputContent,listGrid);
		
		editBtn = new JButton("编辑");
		JPanel editJpanel = new JPanel();
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
		editBtn.addActionListener(B);
		
		noBtn = new JButton("取消");
		JPanel noJpanel = new JPanel();
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
		noBtn.addActionListener(B);
		
		okBtn = new JButton("确认");
		JPanel okJpanel = new JPanel();
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
		okBtn.addActionListener(B);
		
		diaryGrid.fill = GridBagConstraints.BOTH;
		diaryGrid.gridx = 1;
		diaryGrid.gridy = 0;
		diaryGrid.gridwidth = 1;
		diaryGrid.gridheight = 1;
		diaryGrid.weightx = 1.0;
		diaryGrid.weighty = 1.0;
		
		diaryJframe.add(write, diaryGrid);
		inputDate.setEditable(true);
		inputTitle.setEditable(true);
		inputContent.setEditable(true);
//		inputDate.setEditable(false);
//		inputTitle.setEditable(false);
//		inputContent.setEditable(false);
		
		diaryJframe.pack();
		diaryJframe.setVisible(true);
		
		
		
	}
	class buttonListen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource();
			if(source == addBtn) {
				inputDate.setEnabled(true);
				inputTitle.setEnabled(true);
				inputContent.setEditable(true);
				inputDate.setText("");
				inputTitle.setText("");
				inputContent.setText("");
				isAdd = true;
				
			}else if(source == deleteBtn) {
				if(listArea.getSelectedIndex()>=0) {
					int answer = JOptionPane.showConfirmDialog(diaryJframe,"是否删除","警告", JOptionPane.YES_NO_OPTION);
					if(answer == JOptionPane.YES_OPTION) {
						Diary myDiary =listArea.getSelectedValue();
						Date myDate = myDiary.getDate();
						String content = myDiary.getContent();
						diaryModel.removeElementAt(listArea.getSelectedIndex());
//						diarySql.sql(1,dates,uname,content);
						listNum--;
					}
				}else if(listNum <= 0) {
					JOptionPane.showMessageDialog(diaryJframe, "列表为空");
				}else {
					JOptionPane.showMessageDialog(diaryJframe, "没有选中");
				}
			}else if(source == clearBtn) {
				if(listNum <= 0) {
					JOptionPane.showMessageDialog(diaryJframe, "列表框为空");
				}else {
					int answer = JOptionPane.showConfirmDialog(diaryJframe, "是否清空?","警告",JOptionPane.YES_NO_OPTION);
					if(answer == JOptionPane.YES_OPTION) {
						for(int i=listNum-1;i>=0;i--) {
							diaryModel.removeElementAt(i);
//							diarySql.sql(2,null,uname,null);
							listNum = 0;
						}
					}
				}
			}else if(source == okBtn) {
				if(isAdd) {
					if(!Date.isCorrect(inputDate.getText().toString().trim())) {
						JOptionPane.showMessageDialog(diaryJframe, "日期格式不正确");
					}else if(inputTitle.getText().toString().trim().length()<0 || inputTitle.toString().trim().length()>12) {
						JOptionPane.showMessageDialog(diaryJframe, "标题格式不正确");
					}else {
						Date date = new Date(inputDate.getText().toString().trim());
						Diary newDiary = new Diary(date,inputTitle.getText().toString().trim(),inputContent.getText().toString().trim());
						diaryModel.addElement(newDiary);
						listNum++;
						listArea.setSelectedValue(newDiary, true);
						isAdd = false;
					}
				}if(isEdit) {
					Diary diary = listArea.getSelectedValue();
					diary.setContent(inputContent.getText().toString().trim());
//					DiarySql.sql(3, diary.getDate(), uname, contentTxt.getText().toString().trim());
					isEdit = false;
					listArea.setSelectedValue(diary, true);
					showInfo();
				}
				
			}
		}
	}

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
		}
		inputDate.setEditable(false);
		inputTitle.setEditable(false);
		inputContent.setEditable(false);
	}
	
	public static void main(String[] args) {
		writedairyDialog writeDiary = new writedairyDialog();
		writeDiary.mainMenu();
		
		
	}

}
