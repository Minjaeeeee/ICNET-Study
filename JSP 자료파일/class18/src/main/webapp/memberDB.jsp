<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="java.sql.DriverManager" %> <!-- 임포트 선언을 해줄것! -->
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>    
    
	<%!
		Connection connection; //Connection 객체 선언
		Statement statement; //Statement 객체 선언
		ResultSet resultSet; //ResultSet 객체 선언
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "tiger";
		String query = "select*from member";
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
			Class.forName(driver); //oracle.jdbc.driver.OracleDriver
			connection = DriverManager.getConnection(url,uid,upw);
			statement = connection.createStatement(); //커넥션부터 Statement객체를 구한다.
			resultSet = statement.executeQuery(query); //질의응답을 실행
			
			while(resultSet.next())
			{
				String id = resultSet.getString("id"); //id를 불러옴
				String pw = resultSet.getString("pw"); //pw를 불러옴
				String name = resultSet.getString("name"); //name을 불러옴
				String phone = resultSet.getString("phone"); //phone을 불러온다
				
				/* 이쪽이 이제 출력문이다! */
				out.println("아이디: " + id + ", 비밀번호 : " + pw + ", 이름 : "+ name + ", 전화번호 : " + phone + "<br/>");
			}
	}
	
		catch(Exception e) { e.printStackTrace(); }//에러문 출력할 수 있도록 하는 것이다!
		finally
		{
			try
			{
				if(resultSet != null) resultSet.close(); //닫아버린다
				if(statement != null) statement.close(); //닫아버린다
				if(connection != null) connection.close(); //닫아버린다
			}
			catch(Exception e2){ e2.printStackTrace(); }
		}
	%>


</body>
</html>