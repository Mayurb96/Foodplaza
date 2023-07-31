package com.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DaoImp.CustomerDaoImp;
import com.pojo.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustomerDaoImp cd=new CustomerDaoImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		if(action!=null && action.equals("delete")) {
			String emailId=request.getParameter("emailId");
			boolean b=cd.deleteCustomerById(emailId);
			if(b) {
				response.sendRedirect("customer");
			}else {
				response.sendRedirect("Failed.jsp");
			}
		}
		else
		{
			List<Customer>l=cd.getAllCustomer();
			if(l!=null && !(l.isEmpty())) {
			   session.setAttribute("cslist", l);
			   response.sendRedirect("Customerlist.jsp");
			}else {
				response.sendRedirect("Failed.jsp");
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String name=request.getParameter("cname");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String adr=request.getParameter("adr");
		String con=request.getParameter("cNo");
		if(action!=null && action.equals("AddCustomer")) {
			boolean b=cd.addCustomer(new Customer(name, email, pass, adr, con));
			if(b) {
				response.sendRedirect("Success.jsp");
			}else {
				response.sendRedirect("Failed.jsp");
			}
		}
		if(action!=null && action.equals("UpdateCustomer")) {
			boolean b=cd.updateCustomerById(new Customer(name, email, pass, adr, con));
			if(b) {
				response.sendRedirect("Success.jsp");
			}else {
				response.sendRedirect("Failed.jsp");
			}
		}
	}

}
