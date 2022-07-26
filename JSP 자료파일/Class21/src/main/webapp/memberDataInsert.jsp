<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%!
    	Connection connection;
    	PreparedStatement preparedStatement;
    	ResultSet resultSet;
    	
    	String driver = "oracle.jdbc.driver.OracleDriver";
    	String url = "jdbc:oracle:thin:@localhost:1521:xe";
    	String uid = "scott";
    	String upw = "tiger";
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

	<%
	try
	{
		Class.forName(driver);
		connection = DriverManager.getConnection(url,uid,upw);
		int n;
		String query = "Insert into MEMBERFORPRE (id,pw,name,phone) values (?,?,?,?)"; //간단하게 넣어보자! 앞에서 했던거보면 너무 복잡함!
		preparedStatement = connection.prepareStatement(query);
		
		//preparedStatement는 Statement 객체의 난잡한 코드를 개선한 업데이트된 객체이다!
		preparedStatement.setString(1,"abc");
		preparedStatement.setString(2,"123");
		preparedStatement.setString(3,"홍길동");
		preparedStatement.setString(4,"010-1234-5678");
		n = preparedStatement.executeUpdate();
		
		preparedStatement.setString(1,"def");
		preparedStatement.setString(2,"456");
		preparedStatement.setString(3,"홍길자");
		preparedStatement.setString(4,"010-9012-3456");
		n = preparedStatement.executeUpdate();
		
		
		preparedStatement.setString(1,"ghi");
		preparedStatement.setString(2,"789");
		preparedStatement.setString(3,"홍길순");
		preparedStatement.setString(4,"010-7890-1234");
		n = preparedStatement.executeUpdate();
		
		
		preparedStatement.setString(1,"AAA");
		preparedStatement.setString(2,"111");
		preparedStatement.setString(3,"홍길범");
		preparedStatement.setString(4,"010-5555-5555");
		n = preparedStatement.executeUpdate();
		
		if(n==1){
			out.println("insert success");
		}
		else
		{
			out.println("insert fail");
		}
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
		}
		catch(Exception e){};
	}
	
	%>

</body>
</html>