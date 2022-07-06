package eight;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class initParam
 */

@WebServlet(urlPatterns= {"/InitP"}, initParams= {@WebInitParam(name="id",value="aaaaa"), @WebInitParam(name="pw",value="12345")}) //�������Ͽ� ���� ����ϱ� 
public class initParam extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public initParam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		String id = getInitParameter("id"); //�Ķ���� ���� �ҷ��´�!
//		String pw = getInitParameter("pw"); //�Ķ���� ���� �ҷ��´�!
//		System.out.println("id =" + id); //��� �ݼ�â�� ��µ� ����!
//		System.out.println("pw =" + pw); //��� �ܼ�â�� ��µ� ����!
		
		String id = getServletContext().getInitParameter("id");
		String pw = getServletContext().getInitParameter("pw");
		
	}
	//ServletConfig�� ���� ������ �ʿ�x ������ ServletConfig �������̽��� ���ʸ������� �����ϰ� �ְ� �װ��� HttpServlet�� ��ӹް� �ֱ⶧���� ���� ������ �ʿ䰡 ����.

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
