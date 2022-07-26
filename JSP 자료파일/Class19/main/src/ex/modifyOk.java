package ex;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Servlet implementation class modifyOk
 */
public class modifyOk extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
	private Connection connection;
	private java.sql.Statement stmt;
	
	private String name,id,pw,phone1,phone2,phone3,gender;
	HttpSession httpSession;
	
    public modifyOk() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("EUC-KR");
		httpSession = request.getSession();
		
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		if(pwConfirm())
		{
			System.out.println("OK");
			
			String query = "update member set name =" + name + ", phone1 = "+ phone1 + ", phone2 = " + phone2 + ", phone3 = " + phone3 + "gender =" + gender + "";
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
				stmt = connection.createStatement();
				int i= stmt.executeUpdate(query);
				if(i==1)
				{
					System.out.println("update sucesss");
					httpSession.setAttribute("name",name);
					response.sendRedirect("modifyResult.jsp");
				}
				else
				{
					System.out.println("update fail");
					response.sendRedirect("modifyResult.jsp");
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
					if(stmt != null) stmt.close();
					if(connection != null) connection.close();
				}
				
				catch (Exception e) {};
			}
		}
		else
		{
			System.out.println("ng");
		}

	}

	private boolean pwConfirm()
	{
		boolean rs = false;
		String sessionPw = (String)httpSession.getAttribute("pw");;
		if(sessionPw.equals(pw))
		{
			rs=true;
		}
		else
		{
			rs =false;
		}
		return rs;
	}
	
}
