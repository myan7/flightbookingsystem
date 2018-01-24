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

/**
 * Servlet implementation class UpdateFlightServlet3
 */
@WebServlet("/UpdateFlightServlet3")
public class UpdateFlightServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFlightServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("updId"));
		String msg = null;
		int seatsNO = Integer.parseInt(request.getParameter("seatsNO"));
		String departureCity = (String)request.getParameter("dcity").toUpperCase();
		String departurePort = (String)request.getParameter("dport").toUpperCase();
		String departureTime = (String)request.getParameter("dtime").replace('T', ' ');
		System.out.println(1 + " "+ departureTime);
		String arrivalCity = (String)request.getParameter("acity").toUpperCase();
		String arrivalPort = (String)request.getParameter("aport").toUpperCase();
		String arrivalTime = (String)request.getParameter("atime").replace('T', ' '); // want to insert data into db, repalce the t with space
		System.out.println(2+" "+ arrivalTime);
		
		if(FlightDAO.updateFlight(id,seatsNO,departureCity,departurePort,departureTime,arrivalCity,arrivalPort, arrivalTime))
		{
			msg="You've updated Flight: "+ request.getParameter("updNO").toUpperCase();
		}
		else
		{
			msg="Something went wrong, You wanted to update Flight: "+ request.getParameter("updNO")+"but failed.";
		}
		System.out.println(session.getAttribute("flightList")!=null);
		System.out.println(msg);
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("UpdateFlightServlet");
		rd.forward(request, response);
	}

}
