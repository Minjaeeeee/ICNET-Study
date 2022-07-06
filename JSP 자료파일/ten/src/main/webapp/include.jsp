<%@ page import="java.util.Arrays"%>  <%-- Arrays함수를 사용하기 위한 import 함수 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>
	<%-- 선언문 --%>
	<%
		int[] iArr = {10,20,30};
		out.println(Arrays.toString(iArr)); //주석 안에 있는 내용 출력
	%> 
	
	<h1> include.jsp 페이지 입니다.</h1><br/>
	<%@ include file="include01.jsp" %>    <%-- 페이지 삽입 (약간 html에서 frame이랑 같은 느낌이라고 생각하는게 나을 듯! --%>
	<h1> 다시 include.jsp 페이지 입니다.</h1>

</body>
</html>