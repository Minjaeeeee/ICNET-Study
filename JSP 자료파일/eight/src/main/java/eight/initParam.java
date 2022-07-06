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

@WebServlet(urlPatterns= {"/InitP"}, initParams= {@WebInitParam(name="id",value="aaaaa"), @WebInitParam(name="pw",value="12345")}) //서블릿파일에 직접 명시하기 
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
//		String id = getInitParameter("id"); //파라미터 값을 불러온다!
//		String pw = getInitParameter("pw"); //파라미터 값을 불러온다!
//		System.out.println("id =" + id); //출력 콜솔창에 출력될 거임!
//		System.out.println("pw =" + pw); //출력 콘솔창에 출력될 거임!
		
		String id = getServletContext().getInitParameter("id");
		String pw = getServletContext().getInitParameter("pw");
		
	}
	//ServletConfig를 직접 생성할 필요x 구조가 ServletConfig 인터페이스를 제너릭서블릿이 구현하고 있고 그것을 HttpServlet이 상속받고 있기때문에 직접 생성할 필요가 없다.

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
