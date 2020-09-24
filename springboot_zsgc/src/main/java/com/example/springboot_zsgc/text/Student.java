package com.example.springboot_zsgc.text;

public class Student {
	public String name;
	public int age;
	public int gender;
	public String phone;
	public String address;
	public String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    public Student(String name, int age, int gender, String phone, String address, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public void eat() {
		System.out.println("吃...");
	}
	public void drink() {
		System.out.println("喝...");
	}
	public void play() {
		System.out.println("玩...");
	}
	public void sleep() {
		System.out.println("睡...");
	}
	

}
