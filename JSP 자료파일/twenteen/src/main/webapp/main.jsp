<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

	<%--실행하고나서 바로 sub.jsp로 넘겨버리기때문 Url은 바뀌지 않는 것이 특징이다. --%>
	<%-- 밑에 main.jsp 페이지 프린트는 아주 잠깐 출력하고 바로 넘겨버려서 안보일 것임 --%>
	<h1>main.jsp 페이지입니다.</h1> 
	
	<%-- sub.jsp로 넘겨버린다! --%>
	<jsp:forward page="sub.jsp" /> 
	
</body>
</html>