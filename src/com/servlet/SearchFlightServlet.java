package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Customer;
import com.bean.Flight;
import com.dao.FlightDAO;

/**
 * Servlet implementation class SearchFlightServlet
 */
@WebServlet("/SearchFlightServlet")
public class SearchFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String from = request.getParameter("from").toUpperCase();
		String to = request.getParameter("to").toUpperCase();
		String on = request.getParameter("on");
		System.out.println("on = "+ on);
		ArrayList<Flight> flightList = null;
		
		if(on.equals(""))
		{
			flightList = FlightDAO.searchFlight(from, to);
		}else
		{
			flightList = FlightDAO.searchFlight(from, to, on);
		}
	
		session.setAttribute("flightList", flightList);
//		System.out.println(flightList.size()==0);
//		System.out.println(((Customer)(session.getAttribute("cust"))).getFname());
		RequestDispatcher rd = request.getRequestDispatcher("searchflight.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
