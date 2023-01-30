package com.spring.common;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDTO;
import com.spring.board.BoardService;

public class Client_Test_getBoard {
	
public static void main(String[] args) {
	AbstractApplicationContext factory = 
			new GenericXmlApplicationContext("applicationContext.xml");

	
	BoardService boardService = (BoardService) factory.getBean("boardService");
	
	
	//DTO ��ü�� ���� �Ŀ� Setter �������� DTo�� �ʵ��� ���� �Է� 
	BoardDTO boardDTO = new BoardDTO(); //Setter�� ���ؼ� ������ ���� �־��شٴ� �ǹ� 
	
	//�� �� ���� : 1���� ���ڵ常 ��� 
	boardDTO.setSeq(3);
	
	
	//getBoard(boardDTO) ==> �������� DTO �� �ھƿ� 
	BoardDTO dbDTO = boardService.getBoard(boardDTO);
	
	System.out.println(dbDTO);
	
}
}
