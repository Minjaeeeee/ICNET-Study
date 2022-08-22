<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- 태그라이버리 사용한다고 밑에 코드를 명시해준다! -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>   
<head>
<meta charset="EUC-KR">   
<title>Insert title here</title>
</head>
      
<body> 
   
 
 	<c:set var="vatName" value="varValue"/> 
 	vatName : <c:out value= "${vatName}"/>
 	<br/>
 	<c:remove var="vatName"/>
 	vatName : <c:out value="${vatName}"/>   
 	<h3/>
 	
 	<hr/>
 	
 	<c:catch var="error">
 	<%=2/0 %>
 	</c:catch>
 	<br/>
 	<c:out value="${error}"/>
 	
 	<hr/>
 	
 	<c:if test="${1+2==3}"> 
 	 1 + 2 = 3
 	</c:if>
 	
 	<c:if test="${1+2!=3}">
 	 1 + 2 != 3
 	</c:if>
 
 	<hr/>
 	
 	<c:forEach var="fEach" begin="0" end="30" step="3">
 	${fEach}
 	</c:forEach>
 
</body>
</html>