package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DaoImp.CartDaoImp;
import com.DaoImp.OrderDaoImp;
import com.pojo.Order;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/placeorder")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     OrderDaoImp od=new OrderDaoImp(); 
     CartDaoImp cd=new CartDaoImp();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 String email=(String)session.getAttribute("uEmail");
		 Order o=od.placeOrder(email);
		 if(o!=null) {
			 boolean b=cd.clearCart(email);
			 if(b) {
				 request.setAttribute("order", o);
				 request.getRequestDispatcher("Bill.jsp").forward(request, response);
				 
			 }
		 }
		 else {
			 response.sendRedirect("Failed.jsp");
		 }
	}

}
