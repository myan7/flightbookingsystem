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
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
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
		String uname = request.getParameter("uname");
		String fname = request.getParameter("fname");
//		System.out.println(un);
		String lname = request.getParameter("lname");
//		System.out.println(pw);
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		System.out.println(dob);
		String pword = request.getParameter("pword");
		String pword1 = request.getParameter("pword1");
		String page  = null;
		Customer cust = (Customer)session.getAttribute("cust");
		
		
		if(!(pword1.equals(pword)))
		{
			message = "new passwords mismatch.";
		}
		else if(CustomerDAO.updateProfile(uname, fname, lname,address,phone,dob) && CustomerDAO.updatePassword(pword,uname))
		{
				cust.setAddress(address);
				cust.setDOB(dob);
				cust.setFname(fname);
				cust.setLname(lname);
				cust.setPhone(phone);
				cust.setPassword(pword);
				session.setAttribute("cust", cust);
				message = "Congratulations "+ cust.getFname()+" "+cust.getLname()+", you've updated your profile!";
		}
		else
		{
				message = "something not right, do you know english?";
		}
		page  = "profile.jsp";
		request.setAttribute("msg", message);
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
