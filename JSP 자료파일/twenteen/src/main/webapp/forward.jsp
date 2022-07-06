<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>


 <%-- 희한한게 주석을 넣으면 오류가 뜨는데 이유를 모르겠다! --%>
<body>

	<jsp:forward page="forward_param.jsp">
		<jsp:param name="id" value="Kimminjae" /> 
		<jsp:param name="pw" value="0000000" />
	</jsp:forward>

</body>
</html>