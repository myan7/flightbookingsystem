/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.Customer;
import com.util.DBUtil;

/**
 * @author: Administrator
 * @date: Jan 4, 2018
 */
public class SignupDAO {
	public static boolean insertCust(Customer cust)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
//			System.out.println(2);
			String query = "insert into customer values(user_id_seq.nextval,'"+cust.getFname()+"','"+cust.getLname()+"','"+cust.getEmail()+"','"+cust.getPhone()+"',TO_DATE('"+cust.getDOB()+"', 'YYYY-MM-DD'),'"+cust.getAddress()+"','"+cust.getPassportNO()+"')";
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
//			System.out.println(3);
			rs = stmt.executeQuery(query);
//			System.out.println(4);
			if(rs.next())
			{
//				System.out.println(5);
				cust.setUser_id(SignupDAO.findID(cust));
//				System.out.println(" new id is " +SignupDAO.findID(cust));
				return true;
			}
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return false;
	}
	
	public static int findID(Customer cust)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int id = -1;
		try 
		{
//			System.out.println("find ID"+2);
			String query = "select * from customer where EMAIL = '"+ cust.getEmail()+"'";
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
//			System.out.println("find ID"+3);
			rs = stmt.executeQuery(query);
//			System.out.println("find ID"+4);
			if(rs.next())
			{
				id = rs.getInt(1);
			}
		}			
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return id;
	}
	
	
	public static boolean insertLogin(String uname, String pword,int user_id)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			System.out.println("insertlogin"+2);
			String query = "insert into login values('"+uname+"','"+pword+"','"+user_id+"')";
			
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			System.out.println("insertlogin"+3);
			rs = stmt.executeQuery(query);
			System.out.println("insertlogin"+4);
			if(rs.next())
			{
				System.out.println("true");
				return true;
			}
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return false;
	}
}
