<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

	<%-- 변수들 선언! --%>
	<%!
		String id,pw;
	%>
	
	
	<%--  변수들의 값을 지정! --%>
	<%
		id = request.getParameter("id"); //forward.jsp페이지에서 입력한 param 값을 불러온다. (요청)
		pw = request.getParameter("pw"); //forward.jsp 페이지에서 입력한 param 값을 불러온다 (요청)
	%>


	<%-- 출력문입니다 --%>
	<h1> forward_param.jsp 입니다.</h1>
	아이디 : <%= id %><br/>
	비밀번호 : <%= pw %> <br/>
	<br/>
	
</body>
</html>