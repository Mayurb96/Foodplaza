package com.pojo;

public class Order {
	private int orderId;
	private String emailId;
	private float totalprice;
	private String Odate;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String emailId, float totalprice, String odate) {
		super();
		this.emailId = emailId;
		this.totalprice = totalprice;
		Odate = odate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public String getOdate() {
		return Odate;
	}

	public void setOdate(String odate) {
		Odate = odate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", emailId=" + emailId + ", totalprice=" + totalprice + ", Odate=" + Odate
				+ "]";
	}
	
	

}
