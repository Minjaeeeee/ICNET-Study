<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1> include01.jsp 페이지입니다.</h1>
	
	<%-- 이 페이지에서 include02.jsp 페이지를 삽입시켜준다! --%>
	<jsp:include page="include02.jsp" flush="true" /> 
	
	<h1> 다시 include01.jsp 페이지 입니다.</h1>


</body>
</html>

