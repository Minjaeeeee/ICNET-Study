<%@ page import="java.util.Arrays"%>  <%-- Arrays�Լ��� ����ϱ� ���� import �Լ� --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>
	<%-- ���� --%>
	<%
		int[] iArr = {10,20,30};
		out.println(Arrays.toString(iArr)); //�ּ� �ȿ� �ִ� ���� ���
	%> 
	
	<h1> include.jsp ������ �Դϴ�.</h1><br/>
	<%@ include file="include01.jsp" %>    <%-- ������ ���� (�ణ html���� frame�̶� ���� �����̶�� �����ϴ°� ���� ��! --%>
	<h1> �ٽ� include.jsp ������ �Դϴ�.</h1>

</body>
</html>