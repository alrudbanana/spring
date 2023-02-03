package com.springlab.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.springlab.common.JDBCUtil;

@Repository("memberDAO")
public class memberDAO {
	
		//1. JDBC 관련 변수를 선언 : Connection, Statement/PreparedStatement, ResultSet 
		private Connection conn = null;
		private PreparedStatement pstmt = null; 		//주로사용 
		private ResultSet rs = null; 
	
		//2. SQL 쿼리를 담는 상수에 담아서 처리, 변수 생성후 할당 : 상수명 : 전체 대문자로 사용 
		private final String INSERT_MEMBER ="insert into member(idx, id, pass, name, email, age, weight) values( (select nvl(max(idx),0)+1 from member),?,?,?,?,?,?)"; 
		private final String UPDATE_MEMBER = "update member set id=?, pass=?, name=?, age=?, weight=? where idx=?"; //수정메소드
		private final String DELETE_MEMBER ="delete member where idx=?"; //정보삭제 메소드 
		private final String GET_MEMBER ="select * from member where idx=?"; 		//DataBase의 테이블에서 1개의 레코드만 출력 (상세보기)
		private final String MEMBER_LIST ="select * from member order by idx desc"; 
		
		//로그인 메소드 
		private final String USER_LOGIN = "SELECT * FROM member where id = ? AND pass =?";
		
		//3. 메소드 
		
		//로그인 
		public boolean login(memberDTO dto) {
			
			boolean result = false;
		
			
			try {
				conn = JDBCUtil.getConnection();
				pstmt = conn.prepareStatement(USER_LOGIN);
				
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPass());
				
				rs = pstmt.executeQuery();
				
					if(rs.next()) {
						result = true;
						System.out.println("로그인 - 실행");
					}
				
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("로그인- 실패");
				}finally {
					JDBCUtil.close(rs,pstmt, conn);
					System.out.println("모든 객체가 잘 close() 되었습니다.");
				}
				
				return result;
			}
		
	
		
		//회원 가입 insertmember
		public void insertmember(memberDTO dto) {
			System.out.println("==> JDBC로 insertBoard() 기능처리 - 시작");
			//Connection 객체를 사용해서 PreparedStatement 객체 활성화 
			
			try {
				// 오류가 발생시 프로그램이 종료되지 않도록 try catch 블락으로 처리
				
				conn = JDBCUtil.getConnection();
				// INSERT_MEMBER ="insert into member(idx, id, pass, name, email, age, weight) 
				// values( (select nvl(max(idx),0)+1 from member),?,?,?)";
				pstmt = conn.prepareStatement(INSERT_MEMBER); 
				
				// pstmt 에 ? 에 변수값을 할당. 
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPass());
				pstmt.setString(3, dto.getName());
				pstmt.setString(4, dto.getEmail());
				pstmt.setInt(5, dto.getAge());
				pstmt.setDouble(6, dto.getWeight());
				
				pstmt.executeUpdate(); 
				
				System.out.println("==> JDBC로 insertMember() 기능처리 - 완료");
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("==> JDBC로 insertMember() 기능처리 - 실패");
			}finally {
				JDBCUtil.close(pstmt, conn);
				System.out.println("모든 객체가 잘 close() 되었습니다.");
			}
		}
		
		//회원정보수정
		public void updatemember(memberDTO dto) {
			System.out.println("==> JDBC로 updateMember() 기능처리 - 시작");
			
			try {
				conn = JDBCUtil.getConnection();
				//UPDATE_MEMBER = " id=?, pass=?, name=?, age=?, weight=? where idx=?";
				pstmt = conn.prepareStatement(UPDATE_MEMBER);
				
				pstmt.setString(1,dto.getId());
				pstmt.setString(2,dto.getPass());
				pstmt.setString(3,dto.getName());
				pstmt.setInt(4,dto.getAge());
				pstmt.setDouble(5,dto.getWeight());
				pstmt.setInt(6,dto.getIdx());
				
				pstmt.executeUpdate(); 
				
				System.out.println("==> JDBC로 insertMember() 기능처리 - 완료");
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("==> JDBC로 updateMember() 기능처리 - 실패");
			}finally {
				JDBCUtil.close(pstmt, conn);
				System.out.println("모든 객체가 잘 close() 되었습니다.");
			}
		}
		
		//회원 정보 삭제
		public void deletemember(memberDTO dto) {
			System.out.println("==> JDBC로 deletemember() 기능처리 - 시작");
			
			try{
				conn = JDBCUtil.getConnection();
				//private final String DELETE_MEMBER ="delete member where idx=?";
				pstmt = conn.prepareStatement(DELETE_MEMBER);
				pstmt.setInt(1, dto.getIdx());
				
				pstmt.executeUpdate();
				
				System.out.println("==> JDBC로 insertMember() 기능처리 - 완료");
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("==> JDBC로 updateMember() 기능처리 - 실패");
			}finally {
				JDBCUtil.close(pstmt, conn);
				System.out.println("모든 객체가 잘 close() 되었습니다.");
			}
		}
		
		//3-4. 회원 상세 조회 처리 메소드: getmember() : 레코드 1개를 DB에서 select 해서 DTO 객체에 담아서 리턴
		public memberDTO getmember(memberDTO dto) {
			System.out.println("==> JDBC로 getmember() 기능처리 - 시작");
			//리턴으로 돌려줄 변수 선언 
			memberDTO member = new memberDTO();
			try {
				conn = JDBCUtil.getConnection();
				pstmt = conn.prepareStatement(GET_MEMBER);
				//private final String GET_MEMBER ="select * from member where idx=?";
				pstmt.setInt(1,dto.getIdx());
				
				//rs에 실행결과 담아줌 
				rs = pstmt.executeQuery(); 
				
				if (rs.next()) {	//rs의 값이 존재한다면 , rs의 값을 DTO에 담아서 리턴
					member.setIdx(rs.getInt("IDX"));
					member.setId(rs.getString("ID"));
					member.setPass(rs.getString("PASS"));
					member.setName(rs.getString("NAME"));
					member.setEmail(rs.getString("EMAIL"));
					member.setAge(rs.getInt("AGE"));
					member.setWeight(rs.getDouble("WEIGHT"));
					member.setRegdate(rs.getDate("REGDATE"));
					member.setCnt(rs.getInt("CNT"));
					
				}else {
					System.out.println("레코드의 결과가 없습니다. ");
				}
				
				System.out.println("==> JDBC로 getMember() 기능처리 - 완료");
			
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("==> JDBC로 getMember() 기능처리 - 실패");
			}finally {
				
			}
			return member;
		}
		
		
		
		
		//5. memberList 
		
		//private final String MEMBER_LIST ="select * from member order by idx desc"; 
		
		public List<memberDTO> getmemberList(memberDTO dto) {
			System.out.println("==> JDBC로 getBoardList() 기능처리 - 시작");
			
			//리턴 돌려줄 변수 선언 : List <= 인터페이스 , 
				// ArrayList, Vector, LinkedList  <== List 인터페이스를 구현한 클래스
					//ArrayList : 싱글 쓰레드 환경, 	<== 80% 
					//Vector : 멀티쓰레드 환경 
					//LinkedList : 자주 수정, 삭제시 성능이 빠르게 처리됨 
			
			List<memberDTO> memberList = new ArrayList<memberDTO>(); 
			memberDTO member ; 
			
			try {
				conn = JDBCUtil.getConnection(); 
				pstmt = conn.prepareStatement(MEMBER_LIST); 
				rs = pstmt.executeQuery(); 
				
				if (rs.next()) {
					do {
						//DTO 객체는 여기서 만들어야함. ( 별도의 객체에 담기게됨 )
						member = new memberDTO();
						
						//rs에서 가져온 1개의 레코드를 board (DTO) 
						member.setIdx(rs.getInt("IDX"));
						member.setId(rs.getString("ID"));
						member.setName(rs.getString("NAME"));
						member.setEmail(rs.getString("EMAIL"));
						member.setRegdate(rs.getDate("REGDATE"));
						member.setCnt(rs.getInt("CNT"));
						
						//boardList : ArrayList에 add () 메소드를 사용해서 board(DTO) 를 저장
						 memberList.add(member); 
											
					}while (rs.next()); 			
					
				}else {
					System.out.println("테이블에 레코드가 비어 있습니다. ");
				}
				
				System.out.println("==> JDBC로 getmemberList 기능처리 - 완료");
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("==> JDBC로 getmemberList 기능처리 - 실패");
			}finally {
				JDBCUtil.close(rs, pstmt, conn);
			}
			
			return memberList; 
		}
	}
	

