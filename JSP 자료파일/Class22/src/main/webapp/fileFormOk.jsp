<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
    String path = request.getRealPath("fileFolder"); // ������ ����Ǵ� ����
  
    int size = 1024 * 1024 * 10; //10M
    String file = "";
    String oriFile = ""; 
    
    try
    { 
        // ���� ���ε带 �����ϴ� MultipartRequest ��ü ����
        MultipartRequest multi = new MultipartRequest(request, path, size, "EUC-KR", new DefaultFileRenamePolicy());
        // MultipartRequest(request��ü=request, ���ε�� ������ ����� ��η� ���� ����=path, 
        //        ���ε��� ������ �ִ� ũ���, ���ڵ�Ÿ���� ����="EUC-KR", )
        Enumeration files = multi.getFileNames(); // ���� ��ҵ� �� <input type="file">�� �� �Ķ���͵��� �޾Ƽ� Enumeration Ÿ���� ��ü�� �����Ѵ�
        String str = (String)files.nextElement(); // �ϳ��� String���� ��ȯ�ؼ� ����
        
        // ����ڰ� ���ε��� ���ϸ��� �����Ѵ�. ������ ���ε�� ���ϸ��� ���ϵȴ�.
        file = multi.getFilesystemName(str);
        // ����ڰ� ���ε��� ������ ���� ���ϸ��� �����Ѵ�. ���ϸ��� �ߺ��� ��� �̸��� ����ǹǷ� ����Ǳ� ���� ���� ���ϸ��� ���ϵȴ�. 
        oriFile = multi.getOriginalFileName(str);
        
    } 
    	catch (Exception e) 
    	{
        	e.printStackTrace();
    	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
     file upload success!
</body>
</html>
