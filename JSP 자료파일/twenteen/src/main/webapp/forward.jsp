<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>


 <%-- �����Ѱ� �ּ��� ������ ������ �ߴµ� ������ �𸣰ڴ�! --%>
<body>

	<jsp:forward page="forward_param.jsp">
		<jsp:param name="id" value="Kimminjae" /> 
		<jsp:param name="pw" value="0000000" />
	</jsp:forward>

</body>
</html>