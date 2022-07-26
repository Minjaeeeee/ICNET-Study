package ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginOk
 */
@WebServlet("/JoinOk")

public class loginOk extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection connection;
	private java.sql.Statement stmt;
	private ResultSet resultSet;
	
	private String name,id,pw,phone1,phone2,phone3, gender;
	
	public loginOk() 
	{
        super();
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		String query = "select * from member where id = '" + id + "'and pw = '" + pw + "'";
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(query);
			
			while(resultSet.next())
			{
				name = resultSet.getString("name");
				id = resultSet.getString("id");
				pw = resultSet.getString("pw");
				phone1 = resultSet.getString("phone1");
				phone2 = resultSet.getString("phone2");
				phone3 = resultSet.getString("phone3");
				gender = resultSet.getString("gender");
			}
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("name",name);
			httpSession.setAttribute("id",id);
			httpSession.setAttribute("pw",pw);
			
			response.sendRedirect("loginResult.jsp");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally //자원해제 하는 용도
		{
			try
			{
				if(resultSet != null) resultSet.close();
				if(stmt != null) stmt.close();
				if(connection != null) connection.close();
			}
			catch(Exception e2) {e2.printStackTrace();};
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
