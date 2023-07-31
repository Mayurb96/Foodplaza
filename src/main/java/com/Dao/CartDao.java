package com.Dao;

import java.util.List;

import com.pojo.Cart;

public interface CartDao {
	
	boolean addCart(Cart c);
	List<Cart>showCart(String EmailId);
	boolean deleteCart(int cartId);
	boolean clearCart(String EmailId);

}
