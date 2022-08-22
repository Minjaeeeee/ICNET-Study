package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dto.BDto;

public class BContentCommand implements BCommand 
{
	//�������̽��� ��ӹ����Ƿ� �������̵� ����!
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		// TODO Auto-generated method stub

		String bId = request.getParameter("bId"); //id���� �����´�
		BDao dao = new BDao(); //dao�� �ϳ� ���Ӱ� ����
		BDto dto = dao.contentView(bId); //id�� ���� dto�� �����Ѵ�.
		
		request.setAttribute("content_view", dto);	
	}

}
