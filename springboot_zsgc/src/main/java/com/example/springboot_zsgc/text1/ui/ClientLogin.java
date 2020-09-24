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
	 * ��ʼ����� 
	 */
	private void init() {
		
		loginLogo=new ImageIcon("images/aifeilogo.jpg");//��ʼ��ͼƬ
		showLogoLabel=new JLabel(loginLogo,JLabel.CENTER);//��ʼ��JLabel���Ұ�ͼƬ����Label��
//		��ʼ��ʣ�����
		userLabel=new JLabel("�û���");
		pwdLabel=new JLabel("��   ��");
		usernameText=new JTextField();
		pwdText=new JPasswordField();
		loginBtn=new JButton("�� ¼");
		restBtn=new JButton("�� ��");
	}
//	�Ѹ�������ڸ÷�������װ
	private void addComponent() {
		this.setLayout(null);//���������Ĳ���Ϊnull,����û���κ�Ĭ�ϵĲ���
		this.add(showLogoLabel);//�����showLogoLabel��ӵ�������
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
//	�������ӹ���
	private void addListener() {
//		�رմ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		����¼��ť����¼�
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username=usernameText.getText();//��ȡusernameText�ı����ֵ
				String pwd=pwdText.getText();//��ȡpwdText�ı����ֵ
				
				boolean b= FileUtils.checkLogin(username,pwd);//�鿴�û��Ƿ��¼�ɹ�
				if(b==true) {//��½�ɹ�,�����������
					new ChatServerUI();//��ʾ�������
					ClientLogin.this.dispose();//�رյ�¼����
					}else {
//						������Ϣ�Ի���
						JOptionPane.showMessageDialog(null,"�û��������������");
					
				}
				System.out.println("��ɵ�¼");
				
			}
			
		});
//		�����ð�ť����¼�
		restBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				usernameText.setText("");
				pwdText.setText("");
				
			}
			
		});
		
	}
//	�ô�����ʾ����
	private void showFrame() {
//		�ô��ڴ���Ļ���м䵯��
		int screenWidth=(int)this.getToolkit().getScreenSize().getWidth();//�õ���Ļ�Ŀ��
		int screenHeight=(int)this.getToolkit().getScreenSize().getHeight();//�õ���Ļ�ĸ߶�
		int x=(screenWidth-width)/2;//��ȡ������ʾ��X����
		int y=(screenHeight-heigth)/2;//��ȡ������ʾ��y����
		this.setLocation(x, y);//��������Ļ����ʾ������
//		this.setLocation(800,300);
		this.setResizable(false);//�ô��ڵĴ�С���ܱ仯
		this.setSize(width,heigth);//���ô��ڵĿ�Ⱥ͸�
		this.setVisible(true);//�ô�����ʾ����
		
	}
	
	public static void main(String[] args) {
		new ClientLogin();
	}
	

}
