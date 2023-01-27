package com.spring.board;

import java.util.List;

public interface BoardService {

	void insertBoard(BoardDTO dto);

	void updateBoard(BoardDTO dto);

	//BOARD_DELETE = "delete board where seq=?"; <= seq�� ? <-�� ���Ҵ�
	void deleteBoard(BoardDTO dto);

	BoardDTO getBoard(BoardDTO dto);

	//3-4 �� �� ��ȸ ó�� �޼ҵ� : getBoardList(). ��� �÷��� ������ 
	//String BOARD_LIST = "select * from board order by seq";
	List<BoardDTO> getBoardList(BoardDTO dto);

}