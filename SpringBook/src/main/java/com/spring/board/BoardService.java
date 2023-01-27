package com.spring.board;

import java.util.List;

public interface BoardService {

	void insertBoard(BoardDTO dto);

	void updateBoard(BoardDTO dto);

	//BOARD_DELETE = "delete board where seq=?"; <= seq의 ? <-에 값할당
	void deleteBoard(BoardDTO dto);

	BoardDTO getBoard(BoardDTO dto);

	//3-4 글 상세 조회 처리 메소드 : getBoardList(). 모든 컬럼을 가져옴 
	//String BOARD_LIST = "select * from board order by seq";
	List<BoardDTO> getBoardList(BoardDTO dto);

}