<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

	<%--�����ϰ��� �ٷ� sub.jsp�� �Ѱܹ����⶧�� Url�� �ٲ��� �ʴ� ���� Ư¡�̴�. --%>
	<%-- �ؿ� main.jsp ������ ����Ʈ�� ���� ��� ����ϰ� �ٷ� �Ѱܹ����� �Ⱥ��� ���� --%>
	<h1>main.jsp �������Դϴ�.</h1> 
	
	<%-- sub.jsp�� �Ѱܹ�����! --%>
	<jsp:forward page="sub.jsp" /> 
	
</body>
</html>