package com.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.dao.SignupDAO;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
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
		String message = null;
		
		Customer cust = new Customer();
		cust.setAddress(request.getParameter("address"));
		cust.setDOB(request.getParameter("dob"));
//		System.out.println("signup dob = "+request.getParameter("dob"));
		cust.setEmail(request.getParameter("uname"));
		cust.setFname(request.getParameter("fname"));
		cust.setLname(request.getParameter("lname"));
		cust.setPhone(request.getParameter("phone"));
		cust.setPassportNO(request.getParameter("passport"));
		
		String page  = "signup.jsp";

		if(request.getParameter("pword").equals(request.getParameter("pword1")))
		{
			if(SignupDAO.insertCust(cust))
			{
				int user_id = cust.getUser_id();
				System.out.println(user_id);
				SignupDAO.insertLogin(cust.getEmail(), request.getParameter("pword"),user_id);
				message = "Congratulations!!!\r\n" + 
						"You have successfully signed up!\r\n" + 
						"Please Log in.";
				
				page = "welcome.jsp";
			}
		}
		else
		{
			message = "Passwords mismatch";
		}
		request.setAttribute("msg", message);
		System.out.println("signupServlet complete.");
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
