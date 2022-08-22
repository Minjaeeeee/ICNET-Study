package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.dto.BDto;

public class BDao 
{
	DataSource dataSource; //전역함수로 사용된다
	
	public BDao() //생성자 
	{
		try 
		{
			Context context = new InitialContext();
			Context envCtx = (Context) context.lookup("java:comp/env");
			dataSource = (DataSource)envCtx.lookup("jdbc/Oracle11g"); //데이터소스를 받아옴!
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void write(String bName, String bTitle, String bContent) 
	{
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try 
		{
			connection = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			int rn = preparedStatement.executeUpdate();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		finally 
		{
			try 
			{
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		
	}
	
	
	
	//실제로 가장 중요한 부분
	public ArrayList<BDto> list() 
	{
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null; //데이터베이스 접근을 위한 connection 객체
		PreparedStatement preparedStatement = null; //쿼리문을 실행하기 위한 객체
		ResultSet resultSet = null; //데이터를 가져오니까 (결과값) 필요하다
		
		try 
		{
			/* 여기서 오류가 발생하는 것 같은데 미치겄다. */
			connection = dataSource.getConnection(); 
			
			//쿼리문 실행
			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc"; 
			preparedStatement = connection.prepareStatement(query); //매개변수로 넣어줌
			resultSet = preparedStatement.executeQuery(); //실제로 db에 질의 응답을 진행함,그러면 값들이 막 튀어나오는데 그것들을 resultset에 저장
			
			while (resultSet.next()) //dto 객체를 만드는 과정을 거친다.
			{
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				//각각 가져온 값들을 DTO에 저장하고 추가하는 작업을 진행한다.
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent); 
				dtos.add(dto); //arraylist dto에 하나하나씩 추가한다.
			}
			
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace(); //에러문 출력한다.
		} 
		
		finally 
		{
			try //자원을 헤제시키는 역할을 한다.
			{
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return dtos; //dtos를 반환해준다.
	}
	
	
	
	public BDto contentView(String strID) 
	{
		upHit(strID);
		
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select * from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strID));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
		}
		
		
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally 
		{	
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (Exception e2)
			{
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	
	public void modify(String bId, String bName, String bTitle, String bContent) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bId));
			int rn = preparedStatement.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally 
		{
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	
	public void delete(String bId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			connection = dataSource.getConnection();
			String query = "delete from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId));
			int rn = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	
	public BDto reply_view(String str) 
	{
		// TODO Auto-generated method stub
		BDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try 
		{
			
			connection = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(str));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (Exception e2) 
			{
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) 
	{
		// TODO Auto-generated method stub
		
		replyShape(bGroup, bStep);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try 
		{
			connection = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bGroup));
			preparedStatement.setInt(5, Integer.parseInt(bStep) + 1);
			preparedStatement.setInt(6, Integer.parseInt(bIndent) + 1);
			
			int rn = preparedStatement.executeUpdate();
		} 
		
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		
		finally 
		{
			try 
			{
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (Exception e2) 
			{
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	
	private void replyShape( String strGroup, String strStep) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strGroup));
			preparedStatement.setInt(2, Integer.parseInt(strStep));
			
			int rn = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	private void upHit( String bId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bId);
			
			int rn = preparedStatement.executeUpdate();
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
