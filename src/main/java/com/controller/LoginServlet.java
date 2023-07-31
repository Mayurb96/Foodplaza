package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DaoImp.AdminDaoImp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDaoImp ad=new AdminDaoImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		 String action=request.getParameter("action");
		 String type=request.getParameter("type");
		 String email=request.getParameter("email");
		 String pass=request.getParameter("pass");
		 
		 if(action!=null && action.equals("Login")) {
			 
			 if(type.equals("admin")) {
				 boolean b=ad.adminLogin(email, pass);
				 if(b) {
					 session.setAttribute("aEmail",email);
					 response.sendRedirect("index.jsp");
				 }else {
					 response.sendRedirect("Failed.jsp");
				 }
			 }
			 
			 if(type.equals("user")) {
				 boolean b=ad.userLogin(email, pass);
				 if(b) {
					 session.setAttribute("uEmail",email);
					 response.sendRedirect("index.jsp");
				 }else {
					 response.sendRedirect("Failed.jsp");
				 }
			 }
		 }
		 if(action!=null && action.equals("Changepass"))
		 {
			 String npass=request.getParameter("cpass");
			 
			 if(type.equals("admin")) {
				 boolean b=ad.adminChangePassword(email, npass);
				 if(b) {
					 response.sendRedirect("Success.jsp");
				 }else {
					 response.sendRedirect("Failed.jsp");
				 }
			 }
			 
			 if(type.equals("user")) {
				  boolean b=ad.userChangePassword(email, npass);
				 if(b) {
					 response.sendRedirect("Success.jsp");
				 }else {
					 response.sendRedirect("Failed.jsp");
				 }
			 }
		 }
	}

}
