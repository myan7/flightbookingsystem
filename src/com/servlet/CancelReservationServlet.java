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
import com.bean.Ticket;
import com.dao.CustomerDAO;
import com.dao.TicketDAO;

/**
 * Servlet implementation class CancelReservationServlet
 */
@WebServlet("/CancelReservationServlet")
public class CancelReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelReservationServlet() {
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
		Customer c = (Customer)session.getAttribute("cust");
		int fid = Integer.parseInt(request.getParameter("fid"));
		int tid = Integer.parseInt(request.getParameter("tid"));
		String message = null;
		if(TicketDAO.cancelTicket(tid, fid))
			message = "Congratulations! You've cancelled a ticket";
		request.setAttribute("msg", message);
		RequestDispatcher rd = request.getRequestDispatcher("ViewHistoryServlet");
		rd.forward(request, response);
	}

}
