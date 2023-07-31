package com.Dao;

import java.util.List;

import com.pojo.Order;

public interface OrderDao {
	
	public Order placeOrder(String emailId);
	List<Order>showOrder();

}
