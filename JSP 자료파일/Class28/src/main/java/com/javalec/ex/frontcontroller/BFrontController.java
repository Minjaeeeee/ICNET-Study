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


@WebServlet("*.do") //url������ Ȯ���ڰ� do�� ���� �� �����Է� ����!
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
	
	//���� �۾��� �Ͼ�� ��!
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("actionDo");
		
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		BCommand command = null; //DAO���� ������ �۾��� ��Ű�� ���� ����.
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length()); //URI�� Context+ ��� �ٵ� �տ��ִ� �κ��� �߶�!
		
		if(com.equals("/write_view.do")) //�߶� uri ��ΰ� write_view.do��� write_view.jsp�� �̵��϶�!
		{
			viewPage = "write_view.jsp";
		} 
		
		else if(com.equals("/write.do")) //�Խñ��� �ۼ��ϴ� Ȯ���ڴ�
		{
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} 
		
		else if(com.equals("/list.do")) 
		{
			command = new BListCommand(); //����ƮĿ�ǵ� ����
			command.execute(request, response); //�����ϴ� �߻�޼ҵ�
			viewPage = "list.jsp"; //����� �̵��ض�!
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //�������ϴ� Ŭ����! viewpage�� �������� �������Ѵ�.
		dispatcher.forward(request, response);
		
	}

}

