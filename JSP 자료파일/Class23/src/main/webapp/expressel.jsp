<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <!-- 값을 넣어줌 여기서! 그래서 출력하는 값을 구하는 거임! -->
<jsp:useBean id="member" class="com.javalec.ex.MemberInfo" scope="page"/>
<jsp:setProperty name="member" property="name" value="홍길동"/>
<jsp:setProperty name="member" property="id" value="abc"/>
<jsp:setProperty name="member" property="pw" value="123"/>


<!DOCTYPE html>
<html> 
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	이름: <jsp:getProperty name="member" property="name"/><br/>
	아이디: <jsp:getProperty property="id" name="member"/>
	비밀번호: <jsp:getProperty property="pw" name="member"/>
	
	<hr/>
	
	이름: ${member.name}<br/>
	아이디: ${member.id}<br/>
	비밀번호: ${member.pw}<br/>

</body>
</html>