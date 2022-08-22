package com.javalec.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dto.BDto;

public class BListCommand implements BCommand {

	//인터페이스 활용하기위해 오버라이드 진행
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BDao dao = new BDao(); //dao객체를 생성 (이로인해 알 수 있는점 데이터베이스에 접근해서 어떤 일을 하겠구나!)
		ArrayList<BDto> dtos = dao.list();
		request.setAttribute("list", dtos); //속성을 지정하는 역할을 한다.
		
	}
}