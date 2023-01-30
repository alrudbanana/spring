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
	
	//��ü ���� ���� Ŭ���� �̸����� ���
	conn = JDBCUtil.getConnection();
	
	
	System.out.println("======================");
	
	//������ �����̳ʷ� ���� Bean �� ȣ�� : BoardService: �������̽� 
	BoardService boardService = (BoardService) factory.getBean("boardService");
	
	//DTO ��ü�� ���� �Ŀ� Setter �������� DTo�� �ʵ��� ���� �Է� 
	BoardDTO boardDTO = new BoardDTO(); //Setter�� ���ؼ� ������ ���� �־��شٴ� �ǹ� 
	
	//DTO�� Setter �� ����ؼ� �� �ʵ��� ���� �Ҵ�. : title, write, content �ʵ� 
	boardDTO.setTitle("�ӽ�����1");
	boardDTO.setWriter("ȫ�浿");
	boardDTO.setContent("�ӽó����Դϴ�..");
	
	//1.�μ�Ʈ ��� �׽�Ʈ �Ϸ� 
	boardService.insertBoard(boardDTO);
	
	
	//2. Update ��� �׽�Ʈ 
	boardDTO.setTitle("����������");
	boardDTO.setContent("������ ����");
	boardDTO.setSeq(3);
	
	///3. updateBoard �׽�Ʈ 
	boardService.updateBoard(boardDTO);
	
	//3.
}
}
