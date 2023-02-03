package com.springlab.common;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springlab.common.JDBCUtil;

public class Client_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");

		Connection conn = null; 
		
		JDBCUtil db= new JDBCUtil();
		conn = db.getConnection();
		System.out.println("DB연결 확인");
		//객체 생성 없이 클래스 이름으로 출력
		conn = JDBCUtil.getConnection();
		
	}

}
