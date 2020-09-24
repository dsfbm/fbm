package com.example.springboot_zsgc.text1.toos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {
/**
 * 	根据属性文件key(等候前面的字符串),得到value(等号后面的字符串)的值
 * @param key
 * @return
 */
	public static String getValue(String key) {
		
//		创建一个集合类，该集合对象装key---value元素
		Properties p=new Properties();
		try {//异常处理
//			读取bin目录下的db.properties文件，并且把该文件放入IO流中
			InputStream  readDB=FileUtils.class.getClassLoader().getResourceAsStream("com/example/springboot_zsgc/text1/ui/db.properties");
			
			p.load(readDB);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return null;
	}
	/**
	 * 根据uname和pwd检查用户是否可以登录
	 * @return 
	 * 
	 */
	public  static  boolean checkLogin(String uname,String pwd) {
		//从文件中，获取用户名和密码
//		String username=getValue("username");//从文件中，找出用户名值
//		String password=getValue("pwd");//从文件中，找出密码的值
//		//判断用户输入的用户名和密码是否跟文件中已经存在的用户名和密码一致，如果一致说明登录成功，否则登录失败
		String username="123";String password="123";
		if(username.equals(uname)&& password.equals(pwd)) {
			return true;
		}else {
		    return false;
	}
		}
	public static void main(String[] args) {
		//获取java文件的绝对路径
//		String path=FileUtils.class.getClassLoader().getResource("").getPath();
//		System.out.println(path);
	}

}
