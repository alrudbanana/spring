package com.spring.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
		//DB ���� �����ϴ� Ŭ���� 
	
	//1. DB�� �����ϴ� �޼ҵ� 
		//static: ��ü ���� ���� Ŭ���� �̸����� �ٷ� ȣ�� 
		//connection ��ü�� �������� 
	
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
				
				System.out.println("Oracle DB�� �� ���� �Ǿ����ϴ�");
				return conn;
			
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("DB ���ῡ ���� �߽��ϴ�.");
			}
				return null;
			//���ϰ����� null
		}
		
	
	//2. DB������ �����ϴ� �޼ҵ� : Connection, PreparedStatement ��ü�� ���� 
		//Insert, Update, Delete => Resultset ���ʿ� 
		
		public static void close (PreparedStatement pstmt, Connection conn) {
			if( pstmt != null) {
					try {
						
						if(!pstmt.isClosed()) { //pstmt ��ü�� ���ŵ��� ���� ����	
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
		
	//3. DB������ �����ϴ� �޼ҵ� : Connection, PreparedStatement, ResultSet ��ü�� ���� 
		//Select �� ��� �ϴ� ��� 
		public static void close (PreparedStatement pstmt, Connection conn, ResultSet rs) {
			if( pstmt != null) {
					try {
						if(!pstmt.isClosed()) { //pstmt ��ü�� ���ŵ��� ���� ����
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
					if(!rs.isClosed()) { //pstmt ��ü�� ���ŵ��� ���� ����
						
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					rs =  null;
				}
			}

		}
		
		
		
		
		
		
		
		
		
}
