<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

	<%-- ������ ����! --%>
	<%!
		String id,pw;
	%>
	
	
	<%--  �������� ���� ����! --%>
	<%
		id = request.getParameter("id"); //forward.jsp���������� �Է��� param ���� �ҷ��´�. (��û)
		pw = request.getParameter("pw"); //forward.jsp ���������� �Է��� param ���� �ҷ��´� (��û)
	%>


	<%-- ��¹��Դϴ� --%>
	<h1> forward_param.jsp �Դϴ�.</h1>
	���̵� : <%= id %><br/>
	��й�ȣ : <%= pw %> <br/>
	<br/>
	
</body>
</html>