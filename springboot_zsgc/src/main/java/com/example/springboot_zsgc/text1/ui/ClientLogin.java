package com.example.springboot_zsgc.text1.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.example.springboot_zsgc.text1.toos.FileUtils;

public class ClientLogin extends JFrame{
	private ImageIcon loginLogo=null;
	private JLabel showLogoLabel=null;
	private int width=375,heigth=350;
	private JLabel userLabel=null,pwdLabel=null;
	private JTextField usernameText=null;
	private JPasswordField pwdText=null;
	private JButton loginBtn=null,restBtn=null;
	
	private ClientLogin() {
		init();
		addComponent();
		addListener();
		showFrame();
	}
	/*
	 * 初始化组件 
	 */
	private void init() {
		
		loginLogo=new ImageIcon("images/aifeilogo.jpg");//初始化图片
		showLogoLabel=new JLabel(loginLogo,JLabel.CENTER);//初始化JLabel并且把图片放入Label中
//		初始化剩余组件
		userLabel=new JLabel("用户名");
		pwdLabel=new JLabel("密   码");
		usernameText=new JTextField();
		pwdText=new JPasswordField();
		loginBtn=new JButton("登 录");
		restBtn=new JButton("重 置");
	}
//	把各种组件在该方法中组装
	private void addComponent() {
		this.setLayout(null);//设置容器的布局为null,容器没有任何默认的布局
		this.add(showLogoLabel);//把组件showLogoLabel添加到容器中
		showLogoLabel.setBounds(0,0,width-10,75);
		
		this.add(userLabel);
		userLabel.setBounds(50,90,180,30);
		this.add(usernameText);
		usernameText.setBounds(120,90,200,30);
		this.add(pwdLabel);
		pwdLabel.setBounds(50,130,180,30);
		this.add(pwdText);
		pwdText.setBounds(120,130,200,30);
		this.add(loginBtn);
		loginBtn.setBounds(100,180,100,30);
		this.add(restBtn);
		restBtn.setBounds(220,180,100,30);
		
		
	}
//	给组件添加功能
	private void addListener() {
//		关闭窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		给登录按钮添加事件
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username=usernameText.getText();//获取usernameText文本框的值
				String pwd=pwdText.getText();//获取pwdText文本框的值
				
				boolean b= FileUtils.checkLogin(username,pwd);//查看用户是否登录成功
				if(b==true) {//登陆成功,跳往聊天界面
					new ChatServerUI();//显示聊天界面
					ClientLogin.this.dispose();//关闭登录窗口
					}else {
//						弹出消息对话框
						JOptionPane.showMessageDialog(null,"用户名或者密码错误");
					
				}
				System.out.println("完成登录");
				
			}
			
		});
//		给重置按钮添加事件
		restBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				usernameText.setText("");
				pwdText.setText("");
				
			}
			
		});
		
	}
//	让窗口显示出来
	private void showFrame() {
//		让窗口从屏幕的中间弹出
		int screenWidth=(int)this.getToolkit().getScreenSize().getWidth();//得到屏幕的宽度
		int screenHeight=(int)this.getToolkit().getScreenSize().getHeight();//得到屏幕的高度
		int x=(screenWidth-width)/2;//获取窗口显示的X坐标
		int y=(screenHeight-heigth)/2;//获取窗口显示的y坐标
		this.setLocation(x, y);//窗口在屏幕中显示的坐标
//		this.setLocation(800,300);
		this.setResizable(false);//让窗口的大小不能变化
		this.setSize(width,heigth);//设置窗口的宽度和高
		this.setVisible(true);//让窗口显示出来
		
	}
	
	public static void main(String[] args) {
		new ClientLogin();
	}
	

}
