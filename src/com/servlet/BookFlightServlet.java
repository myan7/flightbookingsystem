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
import com.dao.FlightDAO;

/**
 * Servlet implementation class BookFlightServlet
 */
@WebServlet("/BookFlightServlet")
public class BookFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookFlightServlet() {
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
		String id = request.getParameter("id");
		System.out.println("chosen flight id is " + id);
		Flight flight = FlightDAO.getFlightByID(Integer.parseInt(id));
		System.out.println(((Customer)session.getAttribute("cust")).getUser_id());
//		System.out.println(flightList.size()==0);
		session.setAttribute("bookedflight", flight);
		RequestDispatcher rd = request.getRequestDispatcher("passengerinfo.jsp");
		rd.forward(request, response);
	}
}
