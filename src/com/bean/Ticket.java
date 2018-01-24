package com.bean;

public class Ticket {
	private int ticket_id;
	private int flight_id;
	private String ticket_class;
	private String pfname;
	private String plname;
	private String ppassno;
	private int booking_id;
	private String ticket_status;
	private Flight flight;
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public String getTicket_class() {
		return ticket_class;
	}
	public void setTicket_class(String ticket_class) {
		this.ticket_class = ticket_class;
	}
	public String getPfname() {
		return pfname;
	}
	public void setPfname(String pfname) {
		this.pfname = pfname;
	}
	public String getPlname() {
		return plname;
	}
	public void setPlname(String plname) {
		this.plname = plname;
	}
	public String getPpassno() {
		return ppassno;
	}
	public void setPpassno(String ppassno) {
		this.ppassno = ppassno;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getTicket_status() {
		return ticket_status;
	}
	public void setTicket_status(String ticket_status) {
		this.ticket_status = ticket_status;
	}
	public Ticket() {
		
	}
	public Ticket(int ticket_id, int flight_id, String ticket_class, String pfname, String plname, String ppassno,
			int booking_id, String ticket_status, Flight flight) {
		super();
		this.ticket_id = ticket_id;
		this.flight_id = flight_id;
		this.ticket_class = ticket_class;
		this.pfname = pfname;
		this.plname = plname;
		this.ppassno = ppassno;
		this.booking_id = booking_id;
		this.ticket_status = ticket_status;
		this.flight = flight;
	}
	
	
	
}
