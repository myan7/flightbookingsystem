/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.bean.Customer;
import com.bean.Ticket;
import com.util.DBUtil;

/**
 * @author: Administrator
 * @date: Jan 4, 2018
 */
public class CustomerDAO {

	public static Customer isValidUser(String uname, String pword)
	{
		Customer cust = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
//			System.out.println(2);
			String query = "select * from customer c "
					+ "where c.user_id = (select l.user_id from login l where username = '"+uname+"' and password ='"+pword+"')";
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
//			System.out.println(3);
//			System.out.println(query);
			rs = stmt.executeQuery(query);
//			System.out.println(4);
			if(rs.next())
			{
//				System.out.println(5);
				cust = new Customer();
				cust.setUser_id(rs.getInt(1));
				cust.setFname(rs.getString(2));
				cust.setLname(rs.getString(3));
				cust.setEmail(rs.getString(4));
				cust.setPhone(rs.getString(5));
				cust.setDOB(rs.getString(6).substring(0,10));
//				System.out.println("date is "+ rs.getString(6));
				cust.setAddress(rs.getString(7));
				cust.setPassportNO(rs.getString(8));
			}
			con.close();
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
//		System.out.println(6);
		return cust;
		
		
	}
	
	public static String getPassword(String uname)
	{
		Customer cust = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
//			System.out.println(2);
			String query = "select password from login "
					+ "where username = '" + uname+"'";
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
//			System.out.println(3);
//			System.out.println(query);
			rs = stmt.executeQuery(query);
//			System.out.println(4);
			while(rs.next())
			{
//				System.out.println(rs.getString(1));
				return rs.getString(1);
			}
			con.close();
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
//		System.out.println(6);
		return "not found";
	}
	
	public static boolean updateProfile(String uname, String fname, String lname, String address, String phone, String dob )
	{
		Customer cust = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			System.out.println(2);						
			String query = "update customer set fname = '"+fname+"',lname = '"+lname+"',address = '"+address+"',phone = '"+phone+"',dob = to_date('"+dob+"','YYYY-MM-DD')  where email = '"+uname+"'";
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			System.out.println(3);
			System.out.println(query);
			stmt.executeUpdate(query);
			System.out.println(4);
			con.close();
			return true;
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		System.out.println(6);
		return false;
		
	}
	
	public static boolean updatePassword(String pword, String uname)
	{
		Customer cust = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
//			System.out.println(12);
			String query = "update login set password = '"+pword+"' where username = '"+ uname+"'";
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
//			System.out.println(13);
//			System.out.println(query);
			rs = stmt.executeQuery(query);
//			System.out.println(14);
			con.close();
			return true;
			
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return false;
	}
	
	
	public static ArrayList<Ticket> getHistory(Customer c)
	{
		ArrayList<Ticket> history = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			int cid = c.getUser_id();
			// get bookings from this customer;
			String query = "select * " + 
					"from ticketinfo t, bookinginfo b " + 
					"where t.booking_id = b.BOOKING_ID and b.USER_ID ='"+cid+"'" + 
					"order by b.T_DATE desc";
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Ticket t = new Ticket();
				t.setTicket_id(rs.getInt(1)); //tid
				t.setFlight_id(rs.getInt(2)); //fid
				t.setTicket_class(rs.getString(3)); //tclass
				t.setPfname(rs.getString(4)); //pfname
				t.setPlname(rs.getString(5)); //plname 
//				System.out.println("Passenger last name is "+ rs.getString(5));
				t.setPpassno(rs.getString(6));//ppassno
				t.setBooking_id(rs.getInt(7)); //bookingid 
				
				t.setTicket_status(rs.getString(8)); //tstatus
				t.setFlight(FlightDAO.getFlightByID(rs.getInt(2))); //flight
//				System.out.println("flight no is "+t.getFlight().getFlightNO());
				history.add(t);
			}
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return history;
	}
}
