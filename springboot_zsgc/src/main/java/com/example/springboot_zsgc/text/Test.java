package com.example.springboot_zsgc.text;

import java.util.Scanner;

	public class Test {

		  static boolean isFind = false;
		      public static void main(String[] args) {
		    	  
		    	  Student[] p=new Student[3];
		    	  p[0]=new Student("李珊",18,4,"苹果","不知道","2640854698@qq.com");
		    	  p[1]=new Student("小豪豪",88,1,"vivo","不知道","2640854698@qq.com");
		    	  p[2]=new Student("小淘气",2,3,"huawei","不知道","2640854698@qq.com");

		    	  Test.SearchSomeOne(p);
		      }
		    	  public static void SearchSomeOne(Student[] p) {
		    		  System.out.println("请选择你需要的查询方式1.名字\\2.email\\3.address");
		    		  Scanner scanner=new Scanner(System.in);
		    		  int s=scanner.nextInt();

		    		  if(s==1) {
		    			  System.out.println("请输入名字");


		    			  scanner.nextLine();

		    			  String name =scanner.nextLine();



		    			    for (Student p1 : p) {
		    			        if(p1.getName().equals(name))
		    			        isFind = true;
		    			        }

		    			    if(isFind)
		    			        System.out.println("找到 " + name+"!");

		    			    else {
		    			        System.out.println("查无此人");
		    			    }
		    			     }

		    		  if(s==2) {
		    			  System.out.println("请输入你的：email");
		    			  String email=scanner.next();

		    		  for(Student p2:p) {
		    				if(p2.getEmail().equals(email)) {
		    					isFind=true;
		    			}
		    			if(isFind) {
		    				System.out.println("找到"+email+"!");
		    			}
		    			else {
	    				System.out.println("查无此此人");
		    			}

		    			}
		    			}
		    		  if(s==3) {
		    			  System.out.println("请输入你的:address");
		    			  String address=scanner.next();
		    			  for(Student p3:p) {
		    				  if(p3.getName().equals(address))
		    				  isFind=true;
		    			  }

		    			  if(isFind) {
		    				  System.out.println("找到"+address+"!");
		    			  }
		    			  else {
		    				  System.out.println("查无此人");
		    			  }
		    		  }
		    	  }

	}

		



		      






