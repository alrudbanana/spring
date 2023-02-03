package com.springlab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springlab.member.memberDAO;
import com.springlab.member.memberDTO;



/**
 * Servlet implementation class DispatcherServlet
 */
//@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response); //클라이언트에서 넘어오는 값 : request, 서버 -> 클라이언트에 넘겨주는 값: request
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); //request값 인코딩해줘야함  
		process(request, response); //클라이언트에서 넘어오는 값 : request, 서버 -> 클라이언트에 넘겨주는 값: request
	}
	
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGET, doPOST 메소드에서 받는 내용을 처리 메소드 
		String uri = request.getRequestURI(); 		///boardweb/getBoardList.do
		System.out.println("uri : " + uri);
	
		String path = uri.substring(uri.lastIndexOf("/"));  //getBoardList.do
		System.out.println("path : "+ path);
		
	//1. 로그인 login.do
	if (path.equals("/login.do")) {
				
				// 클라이언트 요청에 대해서 : /loin.do 요청 
				//1. Model : Service (비즈니스 로직을 처리)  , (DTO, DAO) 
				//2. View 페이지로 전달 : *.jsp 파일
							
				System.out.println("사용자 정보 처리");
				System.out.println("/login.do 요청을 보냈습니다. ");
				
				// 1. 클라이언트에서 보내는 변수 값을 받아서 변수에 저장 
				String id = request.getParameter("id"); 
				String password = request.getParameter("pass"); 
				
				
				System.out.println("폼에서 넘긴 변수 id 값 출력 : " + id);
				System.out.println("폼에서 넘긴 변수 pass 값 출력 : " + password);
				
				
				//2. 클라이언트에서 넘긴 변수값을 받아서 저장된 변수를 DTO에 Setter 주입 
				memberDTO dto = new memberDTO();
				memberDAO dao = new memberDAO();
				
				dto.setId(id); 
				dto.setPass(password);
				
				boolean result = dao.login(dto); 
				
				//4. 로직을 모두 처리후 View 페이지로 이동 
				if (result == true) {  //클라이언트에게 전송한 ID 와 Pass가 DB의 값과 일치 할때
					response.sendRedirect("getMemberList.do"); 
					System.out.println("아이디와 패스워드 일치");
				}else {  //Client에게 전송한 ID와 Pass중 일치하지 않을 때  
					response.sendRedirect("login.jsp"); 
					System.out.println("아이디와 패스워드 불일치 ");
				}

	}
	
	//2. insert.do
		else if (path.equals("/insert.do")) {
			
			System.out.println("회원 정보를 저장");
			
			//1. 클라이언트에서 넘어오는 변수 값을 받아서 새로운 변수에 저장 
			String id = request.getParameter("id"); 
			String pass = request.getParameter("pass"); 
			String email = request.getParameter("email"); 
			String name = request.getParameter("name"); 
			String age = request.getParameter("age");
			String weight = request.getParameter("weight");
			
			
			memberDTO dto = new memberDTO();
			memberDAO dao = new memberDAO(); 
			
			//2.dto 의 setter 메소드 호출시 클라이언트에게 넘어노는 변수를 할당.
			dto.setId(id);
			dto.setPass(pass);
			dto.setEmail(email);
			dto.setName(name);
			dto.setAge(Integer.parseInt(age));
			dto.setWeight(Double.parseDouble(weight));
			
			dao.insertmember(dto);
			
			response.sendRedirect("getMemberList.do");
	
		}
	
	//3. getmemberList
		else if(path.equals("/getMemberList.do")) {
			System.out.println("회원 정보 LIST 출력");
			
			memberDTO dto = new memberDTO(); 
			memberDAO dao = new memberDAO(); 
			
			//memberList에 DB에서 쿼리한 값을 가져와 넣어준다. . 
			List<memberDTO> memberList = dao.getmemberList(dto);
			
			HttpSession session = request.getSession(); 
			//세션에 멤버 리스트 저장하기 
			
			session.setAttribute("memberList", memberList);
			
			//4.뷰페이지 
			response.sendRedirect("getmemberList.jsp"); 
			
		}
	
	//4. getMemeber() ; 상세보기 
		else if(path.equals("/getMember.do")){
			System.out.println("회원 상세 정보 출력");
			
		String idx = request.getParameter("idx");
		System.out.println("idx : " + idx );
		
		memberDTO dto = new memberDTO(); 
		memberDAO dao = new memberDAO(); 
		
		dto.setIdx(Integer.parseInt(idx));
		
		memberDTO member = dao.getmember(dto);
		
		HttpSession session = request.getSession(); 
		
		session.setAttribute("member", member); 
		
		//3. 뷰 페이지로 전달 
		response.sendRedirect("getMember.jsp"); 
		
			
			
		}
	
	//5. 글삭제 
		else if (path.equals("/deleteMember.do")) {
			System.out.println("회원 삭제 처리 ");
			
			String idx = request.getParameter("idx");
			
			
			memberDTO dto = new memberDTO(); 
			memberDAO dao = new memberDAO(); 
			
			dto.setIdx(Integer.parseInt(idx));
			
			dao.deletemember(dto);
			
			//뷰페이지 이동
			response.sendRedirect("getMemberList.do");
		}
	
	//6.글수정 updateMember.do
		else if (path.equals("/updateMember.do")) {
		
		System.out.println("정보 수정 처리 ");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		Double weight = Double.parseDouble(request.getParameter("weight"));
		String idx = request.getParameter("idx");
		
		System.out.println(idx);
		System.out.println(id);
		System.out.println(name);
		
		
		
		memberDTO dto = new memberDTO();
		memberDAO dao = new memberDAO();
		
		
		dto.setId(id);
		dto.setPass(pass);
		dto.setName(name);
		dto.setEmail(email);
		dto.setAge(age);
		dto.setWeight(weight);
		dto.setIdx(Integer.parseInt(idx));
	
		dao.updatemember(dto);
		
		response.sendRedirect("getMemberList.do");
		
		}
	
		else if (path.equals("/logout.do")) {
		
		System.out.println("사용자 로그 아웃 처리");
	}
	
	
	
}
	
}
