package com.example.springboot_zsgc.text1.toos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {
/**
 * 	���������ļ�key(�Ⱥ�ǰ����ַ���),�õ�value(�Ⱥź�����ַ���)��ֵ
 * @param key
 * @return
 */
	public static String getValue(String key) {
		
//		����һ�������࣬�ü��϶���װkey---valueԪ��
		Properties p=new Properties();
		try {//�쳣����
//			��ȡbinĿ¼�µ�db.properties�ļ������ҰѸ��ļ�����IO����
			InputStream  readDB=FileUtils.class.getClassLoader().getResourceAsStream("com/example/springboot_zsgc/text1/ui/db.properties");
			
			p.load(readDB);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return null;
	}
	/**
	 * ����uname��pwd����û��Ƿ���Ե�¼
	 * @return 
	 * 
	 */
	public  static  boolean checkLogin(String uname,String pwd) {
		//���ļ��У���ȡ�û���������
//		String username=getValue("username");//���ļ��У��ҳ��û���ֵ
//		String password=getValue("pwd");//���ļ��У��ҳ������ֵ
//		//�ж��û�������û����������Ƿ���ļ����Ѿ����ڵ��û���������һ�£����һ��˵����¼�ɹ��������¼ʧ��
		String username="123";String password="123";
		if(username.equals(uname)&& password.equals(pwd)) {
			return true;
		}else {
		    return false;
	}
		}
	public static void main(String[] args) {
		//��ȡjava�ļ��ľ���·��
//		String path=FileUtils.class.getClassLoader().getResource("").getPath();
//		System.out.println(path);
	}

}
