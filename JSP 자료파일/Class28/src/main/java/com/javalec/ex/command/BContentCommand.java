package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dto.BDto;

public class BContentCommand implements BCommand 
{
	//인터페이스를 상속받으므로 오버라이드 진행!
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		// TODO Auto-generated method stub

		String bId = request.getParameter("bId"); //id값을 가져온다
		BDao dao = new BDao(); //dao를 하나 새롭게 생성
		BDto dto = dao.contentView(bId); //id에 대한 dto를 생성한다.
		
		request.setAttribute("content_view", dto);	
	}

}
