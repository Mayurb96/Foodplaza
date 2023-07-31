package com.pojo;

public class Food {
	
	private int foodId;
	private String fName;
	private String fType;
	private int fQuantity;
	private float price;
	
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(String fName, String fType, int fQuantity, float price) {
		super();
		this.fName = fName;
		this.fType = fType;
		this.fQuantity = fQuantity;
		this.price = price;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfType() {
		return fType;
	}

	public void setfType(String fType) {
		this.fType = fType;
	}

	public int getfQuantity() {
		return fQuantity;
	}

	public void setfQuantity(int fQuantity) {
		this.fQuantity = fQuantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", fName=" + fName + ", fType=" + fType + ", fQuantity=" + fQuantity
				+ ", price=" + price + "]";
	}
	
	
	
	

}
