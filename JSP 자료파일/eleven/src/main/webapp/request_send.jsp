<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

<%-- 변수를 선언한다. --%>
<%!
	int age;
%>

<%-- 실제 구동할 코드들을 기입 --%>

<%
	String str = request.getParameter("age"); //html문서에서 값이 넘어옴! 반환형은 무조건 String
	age = Integer.parseInt(str); //int 정수로 변환한다.!
	
	if(age >=20) 
	{
		response.sendRedirect("pass.jsp?age= " + age);
	}
	
	else
	{
		response.sendRedirect("ng.jsp?age = " + age);
	}
%>



<%-- 결과값 출력한다. --%>
<%= age %>


</body>
</html>