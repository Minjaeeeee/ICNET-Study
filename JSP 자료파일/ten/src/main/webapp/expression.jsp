<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

	<%-- 선언문을 의미한다. --%>
	<%! 
		int i =10;
		String str = "ABCDE";
		
		public int sum(int a, int b)
		 {
			return a+b;
		 }
	%>
	
	
	<%-- 표현식을 의미한다! --%>   
	<%=  i %> <br/>  
	<%= str %> <br/>
	<%= sum(1,5) %>
</body>
</html>