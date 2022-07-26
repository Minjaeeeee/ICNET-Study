<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="java.sql.DriverManager" %> <!-- ����Ʈ ������ ���ٰ�! -->
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>    
    
	<%!
		Connection connection; //Connection ��ü ����
		Statement statement; //Statement ��ü ����
		ResultSet resultSet; //ResultSet ��ü ����
		
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
			statement = connection.createStatement(); //Ŀ�ؼǺ��� Statement��ü�� ���Ѵ�.
			resultSet = statement.executeQuery(query); //���������� ����
			
			while(resultSet.next())
			{
				String id = resultSet.getString("id"); //id�� �ҷ���
				String pw = resultSet.getString("pw"); //pw�� �ҷ���
				String name = resultSet.getString("name"); //name�� �ҷ���
				String phone = resultSet.getString("phone"); //phone�� �ҷ��´�
				
				/* ������ ���� ��¹��̴�! */
				out.println("���̵�: " + id + ", ��й�ȣ : " + pw + ", �̸� : "+ name + ", ��ȭ��ȣ : " + phone + "<br/>");
			}
	}
	
		catch(Exception e) { e.printStackTrace(); }//������ ����� �� �ֵ��� �ϴ� ���̴�!
		finally
		{
			try
			{
				if(resultSet != null) resultSet.close(); //�ݾƹ�����
				if(statement != null) statement.close(); //�ݾƹ�����
				if(connection != null) connection.close(); //�ݾƹ�����
			}
			catch(Exception e2){ e2.printStackTrace(); }
		}
	%>


</body>
</html>