package com.smhrd.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */

// 모든 요청을 받아줄 컨트롤러( *.do)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// 들어올 수 있는 요청에 관련된 리스트 작성, 사용할 컨트롤러도 생성
		new HashMap<>();
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestUri = request.getRequestURI();
		System.out.println(requestUri);
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		
		requestUri.substring(contextPath.length());
	}

}
