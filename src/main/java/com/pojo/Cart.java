package com.pojo;

public class Cart {
 
	private int cartId;
	private int foodId;
	private int fquantity;
	private String fName;
	private String emailId;
	private float price;
	private float totalprice;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int foodId, int fquantity, String fName, String emailId, float price, float totalprice) {
		super();
		this.foodId = foodId;
		this.fquantity = fquantity;
		this.fName = fName;
		this.emailId = emailId;
		this.price = price;
		this.totalprice = totalprice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getFquantity() {
		return fquantity;
	}

	public void setFquantity(int fquantity) {
		this.fquantity = fquantity;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", fquantity=" + fquantity + ", fName=" + fName
				+ ", emailId=" + emailId + ", price=" + price + ", totalprice=" + totalprice + "]";
	}
	
	
	
	
}
