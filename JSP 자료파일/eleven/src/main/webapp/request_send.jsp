<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

<%-- ������ �����Ѵ�. --%>
<%!
	int age;
%>

<%-- ���� ������ �ڵ���� ���� --%>

<%
	String str = request.getParameter("age"); //html�������� ���� �Ѿ��! ��ȯ���� ������ String
	age = Integer.parseInt(str); //int ������ ��ȯ�Ѵ�.!
	
	if(age >=20) 
	{
		response.sendRedirect("pass.jsp?age= " + age);
	}
	
	else
	{
		response.sendRedirect("ng.jsp?age = " + age);
	}
%>



<%-- ����� ����Ѵ�. --%>
<%= age %>


</body>
</html>