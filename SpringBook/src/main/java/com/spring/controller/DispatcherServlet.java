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

    //doGet���� �Ѿ���� ��û�� process () �޼ҵ忡�� ó�� �ϵ��� �ѱ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		process(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Post ������� ������ ���� �ѱ涧 �ѱ� ������ ���� ó�� 
		request.setCharacterEncoding("UTF-8");
		process(request, response); 

	}
	
	// doGet, doPost �� ��� ��û�� ó�� �ϴ� �޼ҵ� 
	private void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// URL : http://localhost:8080/boardweb/getBoardList.do <-��û�� ���� ����
		// URI : /boardweb/getBoardList.do <-url�� ������Ʈ �������� ���� ����
		
		
		//1. Ŭ���̾�Ʈ�� ��û path ������ ���� �Ѵ�. 
		String uri = request.getRequestURI(); 		///boardweb/getBoardList.do
			System.out.println("uri : " + uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));  //getBoardList.do
			System.out.println("path : "+ path);
		
		
		//2. Ŭ���̾�Ʈ�� ��û ������ ���� �����ϰ� �б� ó����. 
		
		if (path.equals("/login.do")) {
			
			// Ŭ���̾�Ʈ ��û�� ���ؼ� : /loin.do ��û
			//2-1. Model : Service(����Ͻ� ������ ó��), (DTO, DAO)
			//2-2. View �������� ���� : *.jsp ����
			
			System.out.println("����� ���� ó��");
			System.out.println("/login.do ��û�� ���½��ϴ�. ");
			
		//3. Ŭ���̾�Ʈ���� ������ �������� �޾Ƽ� ������ ����
			String id = request.getParameter("id"); 
			String password = request.getParameter("password"); 
			
			System.out.println("������ �ѱ� ���� id �� ��� : " + id);
			System.out.println("������ �ѱ� ���� id �� ��� : " + password);
			
			//3-1. Ŭ���̾�Ʈ���� �ѱ� �������� �޾Ƽ� ����� ������ DTO�� setter ����
			UserDTO dto = new UserDTO();
			dto.setId(id);
			dto.setPassword(password);
			
		//4. ����Ͻ� ������ ó���ϴ� �������̽��� dto�� �����ؼ� ����Ͻ� ������ ó��
			/*
			@Autowired �����̶� ������̼��� �ȸ��� -> ��üȭ �ؾ���
			UserService user;
			*/
			//UserService user = new UserServiceImpl(); <- �����߻�
			
			UserDAO user = new UserDAO();
			
			UserDTO userD =  user.getUser(dto);//dto�� ����
			
			//4-1. DB�� Ŭ���̾�Ʈ���� �ѱ� ID�� PASSWORD�� select�ؼ� �� ���� DTO�� ��Ƽ� ����
			System.out.println(userD);
			
			
			
			//4. ��ص��� ������ ��� ó�� �� View�������� �̵� 
			if(userD.getId() != null) {	//null���� �ƴҶ�. // Ŭ���̾�Ʈ���� ������ ID�� pass�� DB�� ���� ��ġ
				response.sendRedirect("getBoardList.jsp"); //�α��� ���� 
				System.out.println("���̵�� �н����� ��ġ");
			}else {	//Client ���� ������ ID�� Pass �� ��ġ���� ������. 
				response.sendRedirect("login.jsp");
				System.out.println("���̵�� �н����� ����ġ");
			}

			
		}else if (path.equals("/getBoardList.do")) {
			
			System.out.println("�Խ��� ���� ��� ");
			
		}else if (path.equals("/logout.do")) {
			
			System.out.println("����� �α� �ƿ� ó��");
		}
		
		
	}
	
	

}
