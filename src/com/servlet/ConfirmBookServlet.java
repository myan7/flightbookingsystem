package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Customer;
import com.bean.Flight;
import com.bean.Ticket;
import com.dao.FlightDAO;
import com.dao.TicketDAO;

/**
 * Servlet implementation class ConfirmBookServlet
 */
			  
@WebServlet("/ConfirmBookServlet")
public class ConfirmBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Flight flight = (Flight)session.getAttribute("bookedflight");
		String fname = request.getParameter("pfname");
		String lname = request.getParameter("plname");
		String passportNO = request.getParameter("ppassno");
		String ticketclass = request.getParameter("tclass");
		Customer cust = (Customer)session.getAttribute("cust");
		TicketDAO.addBooking(cust);
		Ticket t = new Ticket();
		t.setFlight_id(flight.getFlight_id());
		t.setTicket_class(ticketclass);
		t.setPfname(fname);
		t.setPlname(lname);
		t.setPpassno(passportNO);
		t.setTicket_status("booked");
		String message = null;
		if(TicketDAO.addTicket(t))
		{
			message = "Congratulatioins, "+cust.getFname()+" "+cust.getLname()+" has booked a "+ticketclass +" ticket of Flight "+flight.getFlightNO()+ " for "+ fname+" "+lname +
			"\n Ticket info is "+ "flight no: "+flight.getFlightNO()+" from: " + flight.getDepartureCity()+" to: "+flight.getArrivalCity()+" departure on "+flight.getDepartureTime();	
		}
		
		request.setAttribute("msg", message);
		System.out.println("Congratulatioins, "+cust.getFname()+" "+cust.getLname()+" has booked a "+ticketclass +" ticket of Flight "+flight.getFlightNO()+ " for "+ fname+" "+lname+"\n"+"Ticket info is "+ "flight no: "+flight.getFlightNO()+" from: " + flight.getDepartureCity()+" to: "+flight.getArrivalCity()+" departure on "+flight.getDepartureTime());
		System.out.println("Person who made this booking is " + cust.getUser_id() + " "+ cust.getFname()+ " "+cust.getLname());
		
		
		RequestDispatcher rd = request.getRequestDispatcher("userhome.jsp");
		rd.forward(request, response);
	}

}
