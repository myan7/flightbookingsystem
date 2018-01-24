package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Flight;
import com.dao.FlightDAO;

/**
 * Servlet implementation class DeleteFlightServlet
 */
@WebServlet("/DeleteFlightServlet")
public class DeleteFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFlightServlet() {
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
//		System.out.println("delete");
//		System.out.println(request.getParameter("delId"));
		int id = Integer.parseInt(request.getParameter("delId"));
		String message = null;
		boolean result = FlightDAO.delFlight(id); 
		String flightno = request.getParameter("delNO");
		 if(result)
		 {
			 message = "Congratulations, you've deleted flight: "+ flightno;
		 }
		 System.out.println(message);
		 ArrayList<Flight> flightList = FlightDAO.getFlight();
		 
		if(session.getAttribute("flightList")!=null)
			session.removeAttribute("flightList");
		session.setAttribute("flightList", flightList);
		
		request.setAttribute("msg", message);
		request.getRequestDispatcher("delflight.jsp").forward(request, response);
	}
}
