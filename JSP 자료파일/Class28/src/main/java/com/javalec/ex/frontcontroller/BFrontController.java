package com.javalec.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.command.BCommand;
import com.javalec.ex.command.BContentCommand;
import com.javalec.ex.command.BDeleteCommand;
import com.javalec.ex.command.BListCommand;
import com.javalec.ex.command.BModifyCommand;
import com.javalec.ex.command.BReplyCommand;
import com.javalec.ex.command.BReplyViewCommand;
import com.javalec.ex.command.BWriteCommand;


@WebServlet("*.do") //url패턴이 확장자가 do인 것은 다 나에게로 오라!
public class BFrontController extends HttpServlet  
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	//실제 작업이 일어나는 곳!
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("actionDo");
		
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		BCommand command = null; //DAO에게 적합한 작업을 시키기 위해 선언.
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length()); //URI는 Context+ 경로 근데 앞에있는 부분을 잘라냄!
		
		if(com.equals("/write_view.do")) //잘라낸 uri 경로가 write_view.do라면 write_view.jsp로 이동하라!
		{
			viewPage = "write_view.jsp";
		} 
		
		else if(com.equals("/write.do")) //게시글을 작성하는 확장자는
		{
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} 
		
		else if(com.equals("/list.do")) 
		{
			command = new BListCommand(); //리스트커맨드 생성
			command.execute(request, response); //수행하는 추상메소드
			viewPage = "list.jsp"; //여기로 이동해라!
		} 
		
		else if(com.equals("/content_view.do"))
		{
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} 
		
		else if(com.equals("/modify.do")) 
		{
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} 
		
		else if(com.equals("/delete.do")) 
		{
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} 
		
		else if(com.equals("/reply_view.do")) 
		{
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		} 
		
		else if(com.equals("/reply.do")) 
		{
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //포워딩하는 클래스! viewpage로 페이지를 포워딩한다.
		dispatcher.forward(request, response);
		
	}

}

