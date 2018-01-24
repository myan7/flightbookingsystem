package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Flight;
import com.dao.FlightDAO;


@WebServlet("/AddFlightServlet")
public class AddFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String flightNO = request.getParameter("FlightNO").toUpperCase();
		int seatsNO = Integer.parseInt(request.getParameter("SeatsNO"));  
		String departureTime = request.getParameter("DepartureTime");
		System.out.println("departureTime ="+departureTime);
		String departurePort  = request.getParameter("DeparturePort").toUpperCase();
		String arrivalTime = request.getParameter("ArrivalTime");
		System.out.println("arrivaleTime ="+ arrivalTime);
		String arrivalPort = request.getParameter("ArrivalPort").toUpperCase();
		
		String page = "addflight.jsp";
		String msg = null;
		Flight flight = new Flight();
		flight.setFlightNO(flightNO);
		flight.setSeatsNO(seatsNO);
		flight.setDepartureTime(departureTime);
		flight.setDeparturePort(departurePort);
		flight.setArrivalTime(arrivalTime);
		flight.setArrivalPort(arrivalPort);
		
		if(FlightDAO.addFlight(flight))
		{
			System.out.println(1212);
			msg = "Congratulations! You've added a flight!";
		}else
		{
			msg = "Something wrong, please check your input.";
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher(page);
//		System.out.println(page);
//		System.out.println("rd"+rd.toString());
//		System.out.println("req"+request.toString());
//		System.out.println("res"+response.toString());
		rd.forward(request, response);
	}

}
