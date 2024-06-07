<%@page import="com.smhrd.model.MavenMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%MavenMember member = (MavenMember)session.getAttribute("member"); %>

   <%if(member==null){ %>
      <!-- 로그인 전 -->   
      <a href="join.jsp"><button>회원가입</button></a>
      <a href="login.jsp"><button>로그인</button></a>
   <%}else{ %>
      <!-- 로그인 후 -->
      <%=member.getMNickName()%> <a href="LogoutController.do"><button>로그아웃</button></a>
   <%} %>
   
   
   <br>
   
   <!-- JSTL 을 사용한 IF문 -->
   
   <c:choose>
      <c:when test="${empty member}">
         <a href="join.jsp"><button>회원가입</button></a>
         <a href="login.jsp"><button>로그인</button></a>
      </c:when>
      <c:otherwise>
         ${member.nickname } <a href="LogoutController.do"><button>로그아웃</button></a>
      </c:otherwise>
   </c:choose>
   
   
</body>
</html>