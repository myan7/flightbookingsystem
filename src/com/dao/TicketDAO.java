package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Customer;
import com.bean.Flight;
import com.bean.Ticket;
import com.util.DBUtil;

public class TicketDAO {
	
	public static boolean addBooking(Customer cust)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			String query = "insert into bookinginfo values(booking_id_seq.nextval,"+cust.getUser_id()+",SYSTIMESTAMP)";
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			return true;
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean addTicket(Ticket t)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			//find out the latest booking id so that it can be inserted into ticketinfo table
			String query = "select max(booking_id) from bookinginfo";
			rs=stmt.executeQuery(query);
			if(rs.next())
				t.setBooking_id(rs.getInt(1));
			System.out.println("booking id is "+t.getBooking_id());
			query = "insert into ticketinfo values(ticket_id_seq.nextval, '"+t.getFlight_id()+"', '"+t.getTicket_class()+"', '"+t.getPfname()+"','"+t.getPlname()+"', '"+t.getPpassno()+"','"+t.getBooking_id()+"','"+t.getTicket_status()+"')";
			rs = stmt.executeQuery(query);
			
			// give the ticket object its ticket id.
			query = "select max(ticket_id) from ticketinfo";
			rs=stmt.executeQuery(query);
				if(rs.next())
					t.setTicket_id(rs.getInt(1));
			System.out.println("ticketi id is "+t.getTicket_id());
			
			//after confirm a ticket, you must update the corresponding flight seatsNO
			query = "update flightinfo set seatsno = seatsno-1 where flight_id = '"+t.getFlight_id() +"'";
			stmt.executeQuery(query);
				return true;
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return false;
	}
	
	public static Ticket getTicketById(int ticketid)
	{
		Ticket t = null;
		Flight f = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			//first get the flight related to the ticket.
			String query = "select * from flightinfo\n" + 
					"where flight_id in( select flight_id\n" + 
					"from ticketinfo\n" + 
					"where ticket_id = '"+ticketid+"')";
					
			rs=stmt.executeQuery(query);
			System.out.println("Get flight query"+ query);
			if(rs.next())
				f = new Flight(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));			
		
			query = "select * from ticketinfo where ticket_id = '"+ticketid+"'";
			rs=stmt.executeQuery(query);
			System.out.println("get ticket info query "+ query);
			if(rs.next())
			{
				t= new Ticket(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),f);
			}
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return t;
	}
	
	public static boolean cancelTicket(int tid, int fid)
	{
		Flight f = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean inticket = false;
		boolean inflight = false;
		try
		{
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			//update ticketinfo table ticket_status to cancelled
			String query ="update ticketinfo set ticket_status = 'cancelled' where ticket_id='"+tid+"'";
			stmt.executeQuery(query);
			inticket = true;
			// update the seatsno in flightinfo to +1
			query = "update flightinfo set seatsno = seatsno+1 where flight_id = '"+fid +"'";
			stmt.executeQuery(query);
			inflight = true;
			
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return (inticket && inflight);
	}
	
	
	public static Flight getFlightInfo(int tid)
	{
		Flight flight = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			String query = "select * from(\n" + 
					"select * from \n" + 
					"(select f.flight_id fid,f.flightNO,f.seatsno,f.departureTime, f.departurePort,a.city_name dcity,f.arrivaltime,f.ARRIVALPORT from flightInfo f, AIRPORTINFO a \n" + 
					"where f.departurePort = a.airport_code) \n" + 
					"natural join \n" + 
					"(select f.flight_id fid, a.city_name acity from flightinfo f, AIRPORTINFO a \n" + 
					"where f.ARRIVALPORT = a.airport_code) )\n" + 
					"where fid = (select flight_id from ticketinfo where ticket_id = '"+tid+"')";
					
			rs=stmt.executeQuery(query);
			if(rs.next())
				flight = new Flight(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));			
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return flight;
	}
	
	public static ArrayList<Ticket> getAllTicket()
	{
		ArrayList<Ticket> tList = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			String query = "select * " + 
					"from ticketinfo t, bookinginfo b " + 
					"where t.booking_id = b.BOOKING_ID " + 
					"and ticket_status ='booked' order by b.T_DATE desc";
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
				tList.add(t);
			}
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return tList;
	}
	
}
