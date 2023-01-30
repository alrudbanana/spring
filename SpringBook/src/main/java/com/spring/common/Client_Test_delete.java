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
		
		
		//DTO 객체를 생성 후에 Setter 주입으로 DTo각 필드의 값을 입력 
		BoardDTO boardDTO = new BoardDTO(); //Setter를 통해서 각각의 값을 넣어준다는 의미 
		
		//deleteBoard() 메소드 테스트 
		
		boardDTO.setSeq(2);
		
		boardService.deleteBoard(boardDTO);
		
		
	}

}
