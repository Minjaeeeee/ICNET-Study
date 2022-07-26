package com.javalec.daotoex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO 
{
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott"; //계정 아이디
	private String upw = "tiger"; //계정 비밀번호
	
//	private DataSource dataSource;
	
	public MemberDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
//		try {
//			Context context = new InitialContext();
//			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	
	
	public ArrayList<MemberDTO> memberSelect()
	{
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try
			{
				con = DriverManager.getConnection(url,uid,upw);
				stmt = con.createStatement();
				rs = stmt.executeQuery("select * from member"); //멤버 테이블을 불러온다.(검색기능이라고 생각하자)
				
				while (rs.next())
				{
					String name = rs.getString("name");
					String id = rs.getString("id");
					String pw = rs.getString("pw");
					String phone1 = rs.getString("phone1");
					String phone2 = rs.getString("phone2");
					String phone3 = rs.getString("phone3");
					String gender = rs.getString("gender");
					
					MemberDTO dto = new MemberDTO(name,id,pw,phone1,phone2,phone3,gender);
					dtos.add(dto);
				}
				
			}
			catch(Exception e) {e.printStackTrace();}
			
			finally
			{
				try
				{
					if(rs!= null) rs.close();
					if(stmt !=null) stmt.close();
					if(con!=null) con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			return dtos;
			
	}
	
	
}
