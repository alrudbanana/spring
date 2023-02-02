package com.spring.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

		@Autowired
		BoardDAO boardDAO;	//객체의 메소드를 사용하기 위해서 . 클래스 : 변수  
		
	@Override
	public void insertBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(dto); //dto 의 값을 클라이언트로 부터 받아서 setter로 
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(dto);
	}

	@Override
	public void deleteBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(dto);
	}

	@Override
	public BoardDTO getBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return boardDAO.getBoard(dto);
	}

	@Override
	public List<BoardDTO> getBoardList(BoardDTO dto) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList(dto);
	}

}
