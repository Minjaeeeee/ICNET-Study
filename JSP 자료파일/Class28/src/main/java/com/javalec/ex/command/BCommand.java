package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand 
{
	//�����϶�� �߻�޼ҵ��̴�.
	void execute(HttpServletRequest request, HttpServletResponse response); 
	//��û�� ������ ����
	
}