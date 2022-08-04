<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
    String path = request.getRealPath("fileFolder"); // 실제로 저장되는 폴더
  
    int size = 1024 * 1024 * 10; //10M
    String file = "";
    String oriFile = ""; 
    
    try
    { 
        // 파일 업로드를 수행하는 MultipartRequest 객체 생성
        MultipartRequest multi = new MultipartRequest(request, path, size, "EUC-KR", new DefaultFileRenamePolicy());
        // MultipartRequest(request객체=request, 업로드된 파일이 저장될 경로로 저장 폴더=path, 
        //        업로드할 파일의 최대 크기로, 인코딩타입을 지정="EUC-KR", )
        Enumeration files = multi.getFileNames(); // 폼의 요소들 중 <input type="file">로 된 파라미터들을 받아서 Enumeration 타입의 객체를 리턴한다
        String str = (String)files.nextElement(); // 하나를 String으로 변환해서 저장
        
        // 사용자가 업로드한 파일명을 리턴한다. 서버상에 업로드된 파일명이 리턴된다.
        file = multi.getFilesystemName(str);
        // 사용자가 업로드한 파일의 원래 파일명을 리턴한다. 파일명이 중복될 경우 이름이 변경되므로 변경되기 전의 원래 파일명이 리턴된다. 
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
