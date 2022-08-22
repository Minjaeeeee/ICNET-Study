package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand 
{
	//실행하라는 추상메소드이다.
	void execute(HttpServletRequest request, HttpServletResponse response); 
	//요청과 응답을 받음
	
}