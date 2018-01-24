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
import com.dao.CustomerDAO;


/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String message = null;
		String un = request.getParameter("uname");
//		System.out.println(un);
		String pw = request.getParameter("pword");
//		System.out.println(pw);
		String page  = "index.jsp";
		Customer c = CustomerDAO.isValidUser(un, pw);
		
		if(c != null)
		{
			session.setAttribute("cust", c);
			int user_id = c.getUser_id() ;
			if(user_id <10)
			{
				message = "Welcome back, admin: "+ c.getFname()+" "+c.getLname()+" !";
				page = "adminhome.jsp";
			}
			else
			{
				message = "Welcome back, "+ c.getFname()+" "+c.getLname()+" !";
				page = "userhome.jsp";
			}
		}
		else
		{
			message = "Invalid username or password";
		}
		request.setAttribute("msg", message);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
