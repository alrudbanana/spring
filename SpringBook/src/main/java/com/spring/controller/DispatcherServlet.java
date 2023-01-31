package com.spring.controller;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.users.UserDAO;
import com.spring.users.UserDTO;
import com.spring.users.UserService;
import com.spring.users.UserServiceImpl;

/**
 * Servlet implementation class DispatcherServlet
 */

//@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DispatcherServlet() {
        super();
     
    }

    //doGet으로 넘어오는 요청을 process () 메소드에서 처리 하도록 넘김
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		process(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Post 방식으로 변수의 값을 넘길때 한글 깨어짐 방지 처리 
		request.setCharacterEncoding("UTF-8");
		process(request, response); 

	}
	
	// doGet, doPost 의 모든 요청을 처리 하는 메소드 
	private void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// URL : http://localhost:8080/boardweb/getBoardList.do <-요청에 대한 정보
		// URI : /boardweb/getBoardList.do <-url의 서버포트 다음으로 오는 정보
		
		
		//1. 클라이언트의 요청 path 정보를 추출 한다. 
		String uri = request.getRequestURI(); 		///boardweb/getBoardList.do
			System.out.println("uri : " + uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));  //getBoardList.do
			System.out.println("path : "+ path);
		
		
		//2. 클라이언트의 요청 정보에 따라서 적절하게 분기 처리함. 
		
		if (path.equals("/login.do")) {
			
			// 클라이언트 요청에 대해서 : /loin.do 요청
			//2-1. Model : Service(비즈니스 로직을 처리), (DTO, DAO)
			//2-2. View 페이지로 전달 : *.jsp 파일
			
			System.out.println("사용자 정보 처리");
			System.out.println("/login.do 요청을 보냈습니다. ");
			
		//3. 클라이언트에서 보내는 변수값을 받아서 변수에 저장
			String id = request.getParameter("id"); 
			String password = request.getParameter("password"); 
			
			System.out.println("폼에서 넘긴 변수 id 값 출력 : " + id);
			System.out.println("폼에서 넘긴 변수 id 값 출력 : " + password);
			
			//3-1. 클라이언트에서 넘긴 변수값을 받아서 저장된 변수를 DTO에 setter 주입
			UserDTO dto = new UserDTO();
			dto.setId(id);
			dto.setPassword(password);
			
		//4. 비즈니스 로직을 처리하는 인터페이스에 dto를 주입해서 비즈니스 로직을 처리
			/*
			@Autowired 서블릿이라서 어노테이션이 안먹힘 -> 객체화 해야함
			UserService user;
			*/
			//UserService user = new UserServiceImpl(); <- 오류발생
			
			UserDAO user = new UserDAO();
			
			UserDTO userD =  user.getUser(dto);//dto를 주입
			
			//4-1. DB의 클라이언트에서 넘긴 ID와 PASSWORD를 select해서 그 값을 DTO에 담아서 리턴
			System.out.println(userD);
			
			
			
			//4. 백앤드의 로직을 모두 처리 후 View페이지로 이동 
			if(userD.getId() != null) {	//null값이 아닐때. // 클라이언트에게 전송한 ID와 pass가 DB의 값과 일치
				response.sendRedirect("getBoardList.jsp"); //로그인 성공 
				System.out.println("아이디와 패스워드 일치");
			}else {	//Client 에게 전송한 ID와 Pass 중 일치하지 않을때. 
				response.sendRedirect("login.jsp");
				System.out.println("아이디와 패스워드 불일치");
			}

			
		}else if (path.equals("/getBoardList.do")) {
			
			System.out.println("게시판 정보 출력 ");
			
		}else if (path.equals("/logout.do")) {
			
			System.out.println("사용자 로그 아웃 처리");
		}
		
		
	}
	
	

}
