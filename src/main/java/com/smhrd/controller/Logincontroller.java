package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MavenMember;
import com.smhrd.model.MavenMemberDAO;

/**
 * Servlet implementation class Logincontroller
 */
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		MavenMember member = new MavenMember(id, pw);
		
		MavenMemberDAO dao = new MavenMemberDAO();
		
		MavenMember mem = dao.login(member);
		
		
		// 성공 일떼 객체반환
		// 실패 일때 객체 없음
		
		
		if(mem != null)
		{
			System.out.println("성공");
			HttpSession session = request.getSession();
			session.setAttribute("member", mem);
			response.sendRedirect("index.jsp");
		}
		else
		{
			System.out.println("실패");
			response.sendRedirect("login.jsp");
		}
	}

}
