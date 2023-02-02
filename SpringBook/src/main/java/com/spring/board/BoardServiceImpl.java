package com.spring.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

		@Autowired
		BoardDAO boardDAO;	//��ü�� �޼ҵ带 ����ϱ� ���ؼ� . Ŭ���� : ����  
		
	@Override
	public void insertBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(dto); //dto �� ���� Ŭ���̾�Ʈ�� ���� �޾Ƽ� setter�� 
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
