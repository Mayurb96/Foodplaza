package com.Dao;

import java.util.List;

import com.pojo.Food;


public interface FoodDao {
  
	boolean addFood(Food f);
	boolean updateFoodById(Food f);
	boolean deleteFoodById(int foodId);
	List<Food>getAllFood();
	Food searchFoodById(int foodId);
}
