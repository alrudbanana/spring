package com.spring.board;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.common.JDBCUtil;

@Repository("boardDAO") //Spring Framework 에서 자동으로 객체가 생성되어서 RAM 로드 

public class BoardDAO {
	// DAO : Data Access Object 
	// DataBase 에 CRUD 하는 객체 : select, Insert, Update, Delete
	
	//1. JDBC 관련 변수를 선언 : connection, Statement/preparedStatement, ResultSet
	private Connection conn =  null; 
	private Statement stmt = null;
	private PreparedStatement pstmt = null; 
	private ResultSet rs = null; 
	
	//2. SQL 쿼리를 담는 상수에 담아서 처리 변수 생성후 할당. : 상수명 : 전체 대문자로 사용
	private final String BOARD_INSERT = 
			"insert into board(seq,title,writer,content)values ((select nvl(max(seq),0)+1 from board),?,?,?)"; 
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq =? "; // DataBase의 테이블에서 1개의 레코드만 출력 (상세보기)
	private final String BOARD_LIST = "select * from board order by seq"; //DataBase의 테이블의 여러개의 레코드를 List(ArrayList())
	
	//3.메소드 : insertBoard(), updateBoard, deleteBoard(), <--리턴 값이 없다. void 
		//getBoard(): BoardDTO에 담아서 전송, 가져온 레코드가 한개 
		//getBoardList(): 한개의 레코드 DTO 객체에 넣어서 전달 , ArrayList에 DTO객체를 담아서 리턴 

	//3-1. 글등록 처리 메소드: insertBoard()
	//insert into board(seq,title,writer,content)values(select nvl(max(seq),0)+1 from board,?,?,?)"; <==? ? ?에 값을 할당 
	

	public void insertBoard(BoardDTO dto) {
		System.out.println("==> JDBC로 InsertBoard() 기능처리 - 시작 ");
		//connection 객체를 사용해서 preparedstatement 객체 활성화
		
		try {
			// 오류가 발생 시 프로그램이 종료되지 않도록 try-catch 문 사용 
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			
			//pstmt 에 ? 에 변수값을 할당.
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			 
			pstmt.executeUpdate(); 	
			
			System.out.println("==> JDBC로 InsertBoard() 기능처리 - 완료");	//오류가 없으면 이 출력구문이 출력될것임 , 잘 연결됫는지 확인구문 
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("==> JDBC로 InsertBoard() 기능처리 - 실패"); //오류가 있을 시 출력구문. 실패 확인 (test문장) 
			}finally {
			JDBCUtil.close(pstmt, conn,rs);
		}
 	}
	
	//3-2. 글수정 처리 메소드: updateBoard()
	// BOARD_UPDATE = "update board set title=?, content=? where seq=?"; <==각각의 ?에 값을 할당 
	

	public void updateBoard(BoardDTO dto) {
		System.out.println("==> JDBC로 updateBoard() 기능처리 - 시작 ");
		
		try {
			//객체 생성 
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			
			//pstmt의 ?에 dto 에서 넘어오는 변수값 할당. 
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getSeq());
			
			pstmt.executeUpdate();
			
			System.out.println("==> JDBC로 updateBoard() 기능처리 - 완료");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("==> JDBC로 updateBoard() 기능처리 - 실패");
		}finally {
			JDBCUtil.close(pstmt,conn,rs);
			System.out.println("모든 객체가 잘 수정되었습니다. ");
			//pstmt 의 ? 에 dto 에 넘어오는 변수 값 할당.
		}
	}

	//3-3. 글 삭제 처리 메소드: deleteBoard
	
	//BOARD_DELETE = "delete board where seq=?"; <= seq의 ? <-에 값할당

	public void deleteBoard(BoardDTO dto) {
		System.out.println("==> JDBC로 deleteBoard() 기능처리 - 시작 ");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, dto.getSeq()); //메모리에 있는 seq칼럼 가져와서 수정 
			
			pstmt.executeUpdate();
			System.out.println("==> JDBC로 deleteBoard() 기능처리 - 완료");
		}catch(Exception e) {
			System.out.println("==> JDBC로 deleteBoard() 기능처리 - 실패");
		}finally {
			JDBCUtil.close(pstmt,conn,rs);
			System.out.println("모든 객체가 잘 삭제 되었습니다. ");
			
		}
		
	}
	
	
	
	//3-4 글 조회 처리 메소드 : getBoard(): 레코드 1개를 DB에서 select 해서 DTO 객체에 담아서 리턴 
	//private final String BOARD_GET = "select * from board where seq =? ";
	

	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("==> JDBC로 getBoard() 기능처리 - 시작 ");
		
		//리턴으로 돌려줄 변수 선언 : try 블락 밖에서 선언 
		BoardDTO board = new BoardDTO(); //select 해오는값
		try {
			//객체 생성 : connection, preparedStatement 
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, dto.getSeq());
			
			//DB를 select한 결과를 rs객체에 저장  
			rs = pstmt.executeQuery();
			
			//rs에 담긴 값을 DTo(board)에저장해서 리턴으로 돌려줌 
			if(rs.next()) { //==> 의 의미: rs의 값이 존재한다면, rs의 값을 DTO에 담아서 리턴 
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}else {
				System.out.println("레코드의 결과가 없습니다. ");
			}
			System.out.println("==> JDBC로 getBoard() 기능처리 - 완료");
		}catch(Exception e){
			System.out.println("==> JDBC로 getBoard() 기능처리 - 실패");
		}finally {
			JDBCUtil.close(pstmt,conn,rs);
		}
		return board;
	}
	
	//3-4 글 상세 조회 처리 메소드 : getBoardList(). 모든 컬럼을 가져옴 
	//String BOARD_LIST = "select * from board order by seq";

		public List<BoardDTO> getBoardList(BoardDTO dto) {
			System.out.println("==> JDBC로 getBoardList() 기능처리 - 시작 ");
			
			//리턴 돌려줄 변수 선언 :List <== 인터페이스 , 
				//ArrayList, Vector, LinkedList <== List 인터페이스를 구현한 클래스 
				//ArrayList: 싱글 쓰레드 환경. 
				//Vector: 멀티 쓰레드 환경
				//LinkedList : 자주 수정, 삭제 시 성능이 빠름  
			
			 List<BoardDTO> boardList = new ArrayList<BoardDTO>();
			 BoardDTO board = null;
			 
			try {
				conn = JDBCUtil.getConnection();
				pstmt = conn.prepareStatement(BOARD_LIST);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					do {
					//rs에서 가져온 1개의 레코드를 board (DTO)	
						board.setSeq(rs.getInt("SEQ"));
						board.setTitle(rs.getString("TITLE"));
						board.setWriter(rs.getString("WRITER"));
						board.setContent(rs.getString("CONTENT"));
						board.setRegdate(rs.getDate("REGDATE"));
						board.setCnt(rs.getInt("CNT"));
						
						//bordList: ArrayList에 add() 메소드를 사용해서 board(DTO)를 저장 
						boardList.add(board);
						
					}while(rs.next());
					
				}else {
					System.out.println("테이블에 레코드가 비어있습니다. ");
				}
				System.out.println("==> JDBC로 getBoardList() 기능처리 - 완료");	
				}catch(Exception e){
					System.out.println("==> JDBC로 getBoardList() 기능처리 - 실패");
				}finally {
					
				}
			return boardList;
			
		}
		
	
	
}
