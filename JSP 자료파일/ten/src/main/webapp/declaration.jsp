<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%! //선언문!
		int i =10;
		String str = "ABCDE";
	%>
	
	<%!  //선언문!
		public int sum(int a, int b)
		{
			return a+b;
		}
	%>
	
	<% //스크립트립
		out.println("i = "+ i + "<br/>");
		out.println("str = "+ str + "<br/>");
		out.println("sum = "+ sum(1,5) + "<br/>");
	%>




</body>
</html>