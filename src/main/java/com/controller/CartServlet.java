package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DaoImp.CartDaoImp;
import com.pojo.Cart;
import com.pojo.Food;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      CartDaoImp cd=new CartDaoImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		if(action!=null && action.equals("delete")) {
			int cartId=Integer.parseInt(request.getParameter("cartId"));
			boolean b=cd.deleteCart(cartId);
			if(b) {
				response.sendRedirect("cart");
			}else {
				response.sendRedirect("Failed.jsp");
			}
		}
		else
		{
			String emailId=(String)session.getAttribute("uEmail");
			List<Cart>l=cd.showCart(emailId);
			if(l!=null && !(l.isEmpty())) {
			   session.setAttribute("clist", l);
			   response.sendRedirect("Cartlist.jsp");
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
		if(action!=null && action.equals("AddToCart")) {
			String name=request.getParameter("fname");
			String email=request.getParameter("email");
			int quan=Integer.parseInt(request.getParameter("quan"));
			int fid=Integer.parseInt(request.getParameter("fid"));
			float price=Float.parseFloat(request.getParameter("price"));
			float tprice=Float.parseFloat(request.getParameter("tprice"));
			boolean b=cd.addCart(new Cart(fid, quan, name, email, price, tprice));
			if(b) {
				response.sendRedirect("cart");
			}else {
				response.sendRedirect("Failed.jsp");
			}
			
		}
	}

}
