package com.qf.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;

public class  text1 extends JFrame{
    public void text01(){

        JFrame frame=new JFrame("测算前世");    //创建Frame窗口
        BorderLayout layout=new BorderLayout();
        frame.setSize(400,200);
        frame.setLayout(layout);    //为Frame窗口设置布局为BorderLayout
        //文本域创建

        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();

//        final JTextArea jt=new JTextArea(50,50);
        //创建文字
        JLabel label=new JLabel("输入信息");
        JLabel label1=new JLabel("输入信息");
        JLabel label2=new JLabel("输入信息");


        //文本框的创建
        final JTextField textField1=new JTextField();
        textField1.setColumns(20);


        JButton button5=new JButton("确定");

        frame.add(panel2,BorderLayout.CENTER);
        frame.add(panel1,BorderLayout.NORTH);

//        panel2.add(jt);
        panel1.add(label);
        panel1.add(textField1);
        panel1.add(button5);

        textField1.setSize(20,5);

//        button5.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e) {
//                // TODO Auto-generated method stub
//
//                String aaa=textField1.getText();
//                if(aaa.length()>=1){
//                    jt.append("本人输入的信息是:\n"+aaa);
//                }else{
//                    jt.append("不能为空\n");
//                }
//            }
//
//        });

        frame.setBounds(300,200,600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[]args){
        text1 example=new text1();
        example.text01();
    }
}


