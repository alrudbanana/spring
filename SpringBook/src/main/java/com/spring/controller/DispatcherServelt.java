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

    //doGet으로 넘어오는 요청을 process() 메소드에서 처리 하도록 넘김 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post방식으로 넘길때 한글 깨어짐 방지 처리 
		request.setCharacterEncoding("UTF-8");
		process(request,response);
		
		
	}
	
	//doGet, doPost 의 모든 요청을 처리하는 메소드
	private void process (HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		
		//URL : http://localhost:8080/boardweb/getBoardList.do
		//URI : boardweb/getBoardList.do
		
		//1. 클라이언트의 요청 path 정보를 추출한다. 
		String uri = request.getRequestURI(); 	//boardweb/getboardList.do
		System.out.println("URi :" + uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));	//getboardList.do
		
		//2. 클라이언트의 요청 정보에 따라 적절하게 분기 처리함 
		
		if(path.equals("/login.do")) {
			System.out.println("사용자 정보 처리");
		}else if(path.equals("/getBoardList.do")){
			System.out.println("게시판 정보 출력");
		}else if(path.equals("/logout.do")){
			System.out.println("사용자 로그아웃 처리");
		}
		
		
	}
	
}
