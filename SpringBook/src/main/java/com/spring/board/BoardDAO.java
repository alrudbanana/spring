package com.spring.board;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.common.JDBCUtil;

@Repository("boardDAO") //Spring Framework ���� �ڵ����� ��ü�� �����Ǿ RAM �ε� 

public class BoardDAO implements BoardService {
	// DAO : Data Access Object 
	// DataBase �� CRUD �ϴ� ��ü : select, Insert, Update, Delete
	
	//1. JDBC ���� ������ ���� : connection, Statement/preparedStatement, ResultSet
	private Connection conn =  null; 
	private Statement stmt = null;
	private PreparedStatement pstmt = null; 
	private ResultSet rs = null; 
	
	//2. SQL ������ ��� ����� ��Ƽ� ó�� ���� ������ �Ҵ�. : ����� : ��ü �빮�ڷ� ���
	private final String BOARD_INSERT = 
			"insert into board(seq,title,writer,content)values(select nvl(max(seq),0)+1 from board,?,?,?)"; 
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq =? "; // DataBase�� ���̺����� 1���� ���ڵ常 ��� (�󼼺���)
	private final String BOARD_LIST = "select * from board order by seq"; //DataBase�� ���̺��� �������� ���ڵ带 List(ArrayList())
	
	//3.�޼ҵ� : insertBoard(), updateBoard, deleteBoard(), <--���� ���� ����. void 
		//getBoard(): BoardDTO�� ��Ƽ� ����, ������ ���ڵ尡 �Ѱ� 
		//getBoardList(): �Ѱ��� ���ڵ� DTO ��ü�� �־ ���� , ArrayList�� DTO��ü�� ��Ƽ� ���� 

	//3-1. �۵�� ó�� �޼ҵ�: insertBoard()
	//insert into board(seq,title,writer,content)values(select nvl(max(seq),0)+1 from board,?,?,?)"; <==? ? ?�� ���� �Ҵ� 
	
	@Override
	public void insertBoard(BoardDTO dto) {
		System.out.println("==> JDBC�� InsertBoard() ���ó�� - ���� ");
		//connection ��ü�� ����ؼ� preparedstatement ��ü Ȱ��ȭ
		
		try {
			// ������ �߻� �� ���α׷��� ������� �ʵ��� try-catch �� ��� 
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			
			//pstmt �� ? �� �������� �Ҵ�.
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			 
			pstmt.executeUpdate(); 	
			
			System.out.println("==> JDBC�� InsertBoard() ���ó�� - �Ϸ�");	//������ ������ �� ��±����� ��µɰ��� , �� ����̴��� Ȯ�α��� 
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("==> JDBC�� InsertBoard() ���ó�� - ����"); //������ ���� �� ��±���. ���� Ȯ�� (test����) 
			}finally {
			JDBCUtil.close(pstmt, conn);
		}
 	}
	
	//3-2. �ۼ��� ó�� �޼ҵ�: updateBoard()
	// BOARD_UPDATE = "update board set title=?, content=? where seq=?"; <==������ ?�� ���� �Ҵ� 
	
	@Override
	public void updateBoard(BoardDTO dto) {
		System.out.println("==> JDBC�� InsertBoard() ���ó�� - ���� ");
		
		try {
			//��ü ���� 
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			
			//pstmt�� ?�� dto ���� �Ѿ���� ������ �Ҵ�. 
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getSeq());
			
			pstmt.executeUpdate();
			
			System.out.println("==> JDBC�� InsertBoard() ���ó�� - �Ϸ�");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("==> JDBC�� InsertBoard() ���ó�� - ����");
		}finally {
			JDBCUtil.close(pstmt,conn);
			
			//pstmt �� ? �� dto �� �Ѿ���� ���� �� �Ҵ�.
		}
	}

	//3-3. �� ���� ó�� �޼ҵ�: deleteBoard
	
	//BOARD_DELETE = "delete board where seq=?"; <= seq�� ? <-�� ���Ҵ�
	@Override
	public void deleteBoard(BoardDTO dto) {
		System.out.println("==> JDBC�� InsertBoard() ���ó�� - ���� ");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, dto.getSeq()); //�޸𸮿� �ִ� seqĮ�� �����ͼ� ���� 
			
			pstmt.executeUpdate();
			System.out.println("==> JDBC�� InsertBoard() ���ó�� - �Ϸ�");
		}catch(Exception e) {
			System.out.println("==> JDBC�� InsertBoard() ���ó�� - ����");
		}finally {
			JDBCUtil.close(pstmt,conn);
			
		}
		
	}
	
	
	
	//3-4 �� ��ȸ ó�� �޼ҵ� : getBoard(): ���ڵ� 1���� DB���� select �ؼ� DTO ��ü�� ��Ƽ� ���� 
	//private final String BOARD_GET = "select * from board where seq =? ";
	
	@Override
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("==> JDBC�� InsertBoard() ���ó�� - ���� ");
		
		//�������� ������ ���� ���� : try ���� �ۿ��� ���� 
		BoardDTO board = null; //select �ؿ��°�
		try {
			//��ü ���� : connection, preparedStatement 
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, dto.getSeq());
			
			//DB�� select�� ����� rs��ü�� ����  
			rs = pstmt.executeQuery();
			
			//rs�� ��� ���� DTo(board)�������ؼ� �������� ������ 
			if(rs.next()) { //==> �� �ǹ�: rs�� ���� �����Ѵٸ�, rs�� ���� DTO�� ��Ƽ� ���� 
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}else {
				System.out.println("���ڵ��� ����� �����ϴ�. ");
			}
			System.out.println("==> JDBC�� InsertBoard() ���ó�� - �Ϸ�");
		}catch(Exception e){
			System.out.println("==> JDBC�� InsertBoard() ���ó�� - ����");
		}finally {
			JDBCUtil.close(pstmt,conn);
		}
		return board;
	}
	
	//3-4 �� �� ��ȸ ó�� �޼ҵ� : getBoardList(). ��� �÷��� ������ 
	//String BOARD_LIST = "select * from board order by seq";
		@Override
		public List<BoardDTO> getBoardList(BoardDTO dto) {
			System.out.println("==> JDBC�� InsertBoard() ���ó�� - ���� ");
			
			//���� ������ ���� ���� :List <== �������̽� , 
				//ArrayList, Vector, LinkedList <== List �������̽��� ������ Ŭ���� 
				//ArrayList: �̱� ������ ȯ��. 
				//Vector: ��Ƽ ������ ȯ��
				//LinkedList : ���� ����, ���� �� ������ ����  
			
			 List<BoardDTO> boardList = new ArrayList<BoardDTO>();
			 BoardDTO board = null;
			 
			try {
				conn = JDBCUtil.getConnection();
				pstmt = conn.prepareStatement(BOARD_LIST);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					do {
					//rs���� ������ 1���� ���ڵ带 board (DTO)	
						board.setSeq(rs.getInt("SEQ"));
						board.setTitle(rs.getString("TITLE"));
						board.setWriter(rs.getString("WRITER"));
						board.setContent(rs.getString("CONTENT"));
						board.setRegdate(rs.getDate("REGDATE"));
						board.setCnt(rs.getInt("CNT"));
						
						//bordList: ArrayList�� add() �޼ҵ带 ����ؼ� board(DTO)�� ���� 
						boardList.add(board);
						
					}while(rs.next());
					
				}else {
					System.out.println("���̺��� ���ڵ尡 ����ֽ��ϴ�. ");
				}
				System.out.println("==> JDBC�� InsertBoard() ���ó�� - �Ϸ�");	
				}catch(Exception e){
					System.out.println("==> JDBC�� InsertBoard() ���ó�� - ����");
				}finally {
					
				}
			return boardList;
			
		}
		
	
	
}