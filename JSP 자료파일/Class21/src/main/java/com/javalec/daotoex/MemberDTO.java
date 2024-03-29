package com.javalec.daotoex;

/* 여기서 getter setter사용해서 진행한다. */

public class MemberDTO 
{
	private String name;
	private String id;
	private String pw;
	private String phone1;
	private String phone2;
	private String phone3;
	private String gender;

	
	/* 생성자 안에다가 인자들을 받고 그 데이터를 전부 받아버린다. */
	public MemberDTO(String name , String id, String pw, String phone1, String phone2, String phone3, String gender)
	{
		this.name=name;
		this.id=id;
		this.pw = pw;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.gender = gender;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getPw()
	{
		return pw;
	}
	
	public void setPw(String pw)
	{
		this.pw = pw;
	}
	
	public String getPhone1()
	{
		return phone1;
	}
	
	public void setPhone1(String phone1)
	{
		this.phone1 = phone1;
	}
	
	public String getPhone2()
	{
		return phone2;
	}
	
	public void setPhone2(String phone2)
	{
		this.phone2 = phone2;
	}
	
	public String getPhone3()
	{
		return phone3;
	}
	
	public void setPhone3(String phone3)
	{
		this.phone3 = phone3;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
}
