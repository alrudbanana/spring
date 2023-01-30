package com.spring.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("/DispatcherServelt")
public class DispatcherServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DispatcherServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

    //doGet���� �Ѿ���� ��û�� process() �޼ҵ忡�� ó�� �ϵ��� �ѱ� 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post������� �ѱ涧 �ѱ� ������ ���� ó�� 
		request.setCharacterEncoding("UTF-8");
		process(request,response);
		
		
	}
	
	//doGet, doPost �� ��� ��û�� ó���ϴ� �޼ҵ�
	private void process (HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		
		//URL : http://localhost:8080/boardweb/getBoardList.do
		//URI : boardweb/getBoardList.do
		
		//1. Ŭ���̾�Ʈ�� ��û path ������ �����Ѵ�. 
		String uri = request.getRequestURI(); 	//boardweb/getboardList.do
		System.out.println("URi :" + uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));	//getboardList.do
		
		//2. Ŭ���̾�Ʈ�� ��û ������ ���� �����ϰ� �б� ó���� 
		
		if(path.equals("/login.do")) {
			System.out.println("����� ���� ó��");
		}else if(path.equals("/getBoardList.do")){
			System.out.println("�Խ��� ���� ���");
		}else if(path.equals("/logout.do")){
			System.out.println("����� �α׾ƿ� ó��");
		}
		
		
	}
	
}
