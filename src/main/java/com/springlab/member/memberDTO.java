package com.springlab.member;

import java.sql.Date;

public class memberDTO {
	//변수선언 
	private int idx;
	private String id;
	private String pass; 
	private String name; 
	private String email; 
	private int age; 
	private double weight; 
	private Date regdate;  
	private int cnt;
	
	//기본생성자 
	public memberDTO () {}
	
	//get//set
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	//변수의 값만 찍어주기 위해 toString
	@Override
	public String toString() {
		return "memberDTO [idx=" + idx + ", id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email
				+ ", age=" + age + ", weight=" + weight + ", regdate=" + regdate + ", cnt=" + cnt + "]";
	}
	
	
	
}