package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MavenMember;
import com.smhrd.model.MavenMemberDAO;

/**
 * Servlet implementation class JoinControler
 */
public class JoinControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		
		// 1. DB생성 (MAVENMEMBER - ID, PW, NICKNAME)
		// 2. MyBatis (파라미터를 하나로 묶어서 넘겨줘야함) -> VO
		// 3. VO 클래스 설계 => DB TABLE을 형태와 맞춰줘야함
		// (테이블 이름-> 클래스 이름, 컬럼의 이름, 타입 -> 필드)
		// 
		
		MavenMember member = new MavenMember(id,pw,nickname);
		MavenMemberDAO dao = new MavenMemberDAO();
		int res = dao.join(member);
		if(res>0)
		{
			// 성공
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("join.jsp");
		}
	}
	

}
