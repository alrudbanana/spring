package com.spring.common;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDTO;
import com.spring.board.BoardService;

public class Client_Test_delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");

		
		BoardService boardService = (BoardService) factory.getBean("boardService");
		
		
		//DTO ��ü�� ���� �Ŀ� Setter �������� DTo�� �ʵ��� ���� �Է� 
		BoardDTO boardDTO = new BoardDTO(); //Setter�� ���ؼ� ������ ���� �־��شٴ� �ǹ� 
		
		//deleteBoard() �޼ҵ� �׽�Ʈ 
		
		boardDTO.setSeq(2);
		
		boardService.deleteBoard(boardDTO);
		
		
	}

}
