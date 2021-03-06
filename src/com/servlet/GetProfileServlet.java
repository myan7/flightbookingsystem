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
 * Servlet implementation class GetProfileServlet
 */
@WebServlet("/GetProfileServlet")
public class GetProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = ((Customer)session.getAttribute("cust")).getUser_id();
		
		Flight updflight = FlightDAO.getFlightByID(id);
		System.out.println(updflight != null);
		request.setAttribute("updflight", updflight);
//		System.out.println(flightList.size()==0);
		RequestDispatcher rd = request.getRequestDispatcher("updateflight2.jsp");
		rd.forward(request, response);
	}

}
