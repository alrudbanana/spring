package com.spring.common;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDTO;
import com.spring.board.BoardService;

public class Client_test1 {
	
	
public static void main(String[] args) {
	AbstractApplicationContext factory = 
			new GenericXmlApplicationContext("applicationContext.xml");

	Connection conn = null; 
	
	JDBCUtil db= new JDBCUtil();
	conn = db.getConnection();
	
	//객체 생성 없이 클래스 이름으로 출력
	conn = JDBCUtil.getConnection();
	
	
	System.out.println("======================");
	
	//스프링 컨테이너로 부터 Bean 을 호출 : BoardService: 인터페이스 
	BoardService boardService = (BoardService) factory.getBean("boardService");
	
	//DTO 객체를 생성 후에 Setter 주입으로 DTo각 필드의 값을 입력 
	BoardDTO boardDTO = new BoardDTO(); //Setter를 통해서 각각의 값을 넣어준다는 의미 
	
	//DTO에 Setter 를 사용해서 각 필드의 값을 할당. : title, write, content 필드 
	boardDTO.setTitle("임시제목1");
	boardDTO.setWriter("홍길동");
	boardDTO.setContent("임시내용입니다..");
	
	//1.인서트 기능 테스트 완료 
	boardService.insertBoard(boardDTO);
	
	
	//2. Update 기능 테스트 
	boardDTO.setTitle("수정된제목");
	boardDTO.setContent("수정된 내용");
	boardDTO.setSeq(3);
	
	///3. updateBoard 테스트 
	boardService.updateBoard(boardDTO);
	
	//3.
}
}
