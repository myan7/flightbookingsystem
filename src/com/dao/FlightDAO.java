package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Flight;
import com.util.DBUtil;

public class FlightDAO {
	
	public static boolean addFlight(Flight flight)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
//			System.out.println(2);
//			System.out.println(FlightDAO.getTimeStamp(flight.getArrivalTime()));
			String query = "INSERT INTO flightInfo VALUES (FLIGHT_ID_SEQ.NEXTVAL, '"+flight.getFlightNO()+"', '"+flight.getSeatsNO()+"',TO_TIMESTAMP('"+flight.getDepartureTime()+"','YYYY-MM-DD HH24:Mi'),'"+flight.getDeparturePort()+"',TO_TIMESTAMP('"+flight.getArrivalTime()+"','YYYY-MM-DD HH24:Mi'),'"+flight.getArrivalPort()+"')";
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
//			System.out.println(query);
			rs = stmt.executeQuery(query);
//			System.out.println("insert into flightInfo table a new row");
			if(rs.next())
			{
//				System.out.println(5);
				return true;
			}
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return false;
	}
	
//	public static String getTimeStamp(String time)
//	{
//		StringBuilder sb = new StringBuilder(time);
//		sb.append(":00.00");
//		return sb.toString();
//	}
	
	
	public static ArrayList<Flight> getFlight()
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Flight> flightList = new ArrayList<>();
		try 
		{
//			System.out.println(2);
			String query = "select * from " + 
					"(select f.flight_id fid,f.flightNO,f.seatsno,f.departureTime, f.departurePort,a.city_name dcity,f.arrivaltime,f.ARRIVALPORT " + 
					"from flightInfo f, AIRPORTINFO a " + 
					"where f.departurePort = a.airport_code) " + 
					"natural join " + 
					"(select f.flight_id fid, a.city_name acity " + 
					"from flightinfo f, AIRPORTINFO a " + 
					"where f.ARRIVALPORT = a.airport_code) order by fid";
//			System.out.println(query);
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
//			System.out.println("find ID"+3);
			rs = stmt.executeQuery(query);
//			System.out.println("find ID"+4);
			while(rs.next())
			{
//				System.out.println(1);
				Flight flight = new Flight(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
//				System.out.println("Arrival time is "+ rs.getString(7));
//				System.out.println("departure time is "+ rs.getString(4));
				flightList.add(flight);
			}
		}			
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return flightList;
	}

	public static boolean delFlight(int id) {
		Connection con = null;
		Statement stmt = null;
//		ResultSet rs = null;
//		ArrayList<Flight> flightList = new ArrayList<>();
		try 
		{
			String query = "delete from flightInfo where flight_id = "+id;
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			stmt.executeQuery(query);
			return true;
		}			
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		
		return false;
	}
	
	public static ArrayList<Flight> searchFlight(String from, String to)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Flight> flightList = new ArrayList<>();
		try 
		{
//			System.out.println(2);
			String query = "select * from (select * from " + 
					"(select f.flight_id fid,f.flightNO,f.seatsno,f.departureTime, f.departurePort,a.city_name dcity,f.arrivaltime,f.ARRIVALPORT " + 
					"from flightInfo f, AIRPORTINFO a " + 
					"where f.departurePort = a.airport_code) " + 
					"natural join " + 
					"(select f.flight_id fid, a.city_name acity " + 
					"from flightinfo f, AIRPORTINFO a " + 
					"where f.ARRIVALPORT = a.airport_code)) "+
					"where dcity ='"+from+"' and acity ='"+to+"' order by fid";
			System.out.println(query);
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			System.out.println("2 param before query"+3);
			rs = stmt.executeQuery(query);
			System.out.println("2 param after query"+4);
			while(rs.next())
			{
				System.out.println("2 param while loop for result set"+1);
				Flight flight = new Flight(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				System.out.println(rs.getInt(1));
				flightList.add(flight);
			}
		}			
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return flightList;
	}
	
	
	// overload the method searchFlight with 3 arguments, 
//	find all the flights that are after the specific departing date.
	public static ArrayList<Flight> searchFlight(String from, String to, String on)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Flight> flightList = new ArrayList<>();
		try 
		{
//			System.out.println(2);
			String query = "select * from (select * from " + 
					"(select f.flight_id fid,f.flightNO,f.seatsno,f.departureTime, f.departurePort,a.city_name dcity,f.arrivaltime,f.ARRIVALPORT " + 
					"from flightInfo f, AIRPORTINFO a " + 
					"where f.departurePort = a.airport_code) " + 
					"natural join " + 
					"(select f.flight_id fid, a.city_name acity " + 
					"from flightinfo f, AIRPORTINFO a " + 
					"where f.ARRIVALPORT = a.airport_code)) "+                      //TO_TIMESTAMP('"+flight.getDepartureTime()+"','YYYY-MM-DD HH24:Mi')
					"where dcity ='"+from+"' and acity ='"+to+"'and departureTime >= TO_TIMESTAMP('"+on+"','YYYY-MM-DD HH24:Mi') order by departureTime asc";
			System.out.println(query);
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			System.out.println("3 param before query"+3);
			rs = stmt.executeQuery(query);
			System.out.println("3 param after query"+4);
			while(rs.next())
			{
				System.out.println("3 param while loop for result set"+1);
				Flight flight = new Flight(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				System.out.println(rs.getInt(1));
				flightList.add(flight);
			}
		}			
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return flightList;
	}
	
	public static Flight getFlightByID(int id)
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
//		ArrayList<Flight> flightList = new ArrayList<>();
		Flight flight = null;
		try 
		{
			System.out.println(2);
			String query = "select * from " + 
					"(select f.flight_id fid,f.flightNO,f.seatsno,f.departureTime, f.departurePort,a.city_name dcity,f.arrivaltime,f.ARRIVALPORT " + 
					"from flightInfo f, AIRPORTINFO a " + 
					"where f.departurePort = a.airport_code) " + 
					"natural join " + 
					"(select f.flight_id fid, a.city_name acity " + 
					"from flightinfo f, AIRPORTINFO a " + 
					"where f.ARRIVALPORT = a.airport_code) where fid = "+id+" order by fid";
//			System.out.println(query);
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
//			System.out.println("find ID"+3);
			rs = stmt.executeQuery(query);
//			System.out.println("find ID"+4);
			while(rs.next())
			{
//				System.out.println(1);
				flight = new Flight(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
//				System.out.println("ArrivalTime should be"+rs.getString(7));
//				System.out.println("departure should be"+rs.getString(4));
			}
		}			
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return flight;
	}
	
	
	public static boolean updateFlight(int id, int seatsNO,String departureCity,String departurePort,String departureTime,String arrivalCity,String arrivalPort,String arrivalTime) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
//			System.out.println(2);
			String query = "update flightinfo set seatsNo= '"+seatsNO+"', departurePort='"+departurePort+"', departureTime= TO_TIMESTAMP('"+departureTime+"','YYYY-MM-DD HH24:MI:SS.FF') ,arrivalPort='"+arrivalPort+"', arrivalTime= TO_TIMESTAMP('"+arrivalTime+"','YYYY-MM-DD HH24:MI:SS.FF') where flight_id = '"+id+"'";

			System.out.println(query);
//			System.out.println(java.util.TimeZone.getDefault());
			con = DBUtil.getMeConnectionObj();
			stmt = con.createStatement();
			System.out.println("con create statement"+3);
			rs = stmt.executeQuery(query);
			System.out.println("Query executed"+4);
			return true;
		}			
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean purchase(Flight flight)
	{
		synchronized (new Object())
		{
			int tNO = flight.getSeatsNO();
			if(flight.getSeatsNO()<=0)
				return false;
			else
			{
				flight.setSeatsNO(tNO-1);
				return true;
			}
		}
		
			
		
	}
}
