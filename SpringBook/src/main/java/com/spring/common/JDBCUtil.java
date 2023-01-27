package com.spring.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
		//DB 연결 절정하는 클래스 
	
	//1. DB를 연결하는 메소드 
		//static: 객체 생성 없이 클래스 이름으로 바로 호출 
		//connection 객체로 리턴해줌 
	
		public static Connection getConnection() {
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			//String driver = "org.h2.Driver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
			//String url = "jdbc:h2:tcp://localhost/~/test";
			
			Connection conn = null; 
			
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection (url, "C##HR", "1234"); 
				//conn = DriverManager.getConnection (url, "sa", "1234"); 
				
				System.out.println("Oracle DB에 잘 연결 되었습니다");
				return conn;
			
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("DB 연결에 실패 했습니다.");
			}
				return null;
			//리턴값으로 null
		}
		
	
	//2. DB연결을 제거하는 메소드 : Connection, PreparedStatement 객체를 제거 
		//Insert, Update, Delete => Resultset 불필요 
		
		public static void close (PreparedStatement pstmt, Connection conn) {
			if( pstmt != null) {
					try {
						
						if(!pstmt.isClosed()) { //pstmt 객체가 제거되지 않은 상태	
						}
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						pstmt =  null;
					}
			}
			
			if(conn != null) {
				try {
					if(!conn.isClosed()) {
						conn.close();
					}
				}catch (Exception e){
					
				}finally {
					conn = null; 
				}
					
			}
		}
		
	//3. DB연결을 제거하는 메소드 : Connection, PreparedStatement, ResultSet 객체를 제거 
		//Select 를 사용 하는 경우 
		public static void close (PreparedStatement pstmt, Connection conn, ResultSet rs) {
			if( pstmt != null) {
					try {
						if(!pstmt.isClosed()) { //pstmt 객체가 제거되지 않은 상태
						}
					}catch(Exception e) {
						e.printStackTrace();
					}finally{
						pstmt =  null;
					}
			}
				
			if(conn != null) {
				try {
					if(!conn.isClosed()) {
						conn.close();
					}
				}catch (Exception e){
					
				}finally {
					conn = null; 
				}
					
				}
			
			if( rs != null) {
				try {
					if(!rs.isClosed()) { //pstmt 객체가 제거되지 않은 상태
						
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					rs =  null;
				}
			}

		}
		
		
		
		
		
		
		
		
		
}
