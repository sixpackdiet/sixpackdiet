package com.sixpackdiet.service;

import java.util.List;

import com.sixpackdiet.bean.FoodItem;

public interface FoodItemService {
	public void saveFoodItem(FoodItem foodItem);

	public FoodItem findFoodItemForId(int foodItemId);

	public void deleteFoodItem(FoodItem foodItem);

	public List<FoodItem> findAll();
}
