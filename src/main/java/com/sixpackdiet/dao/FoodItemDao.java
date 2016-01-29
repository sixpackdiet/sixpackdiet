package com.sixpackdiet.dao;

import java.util.List;

import com.sixpackdiet.bean.FoodItem;

public interface FoodItemDao {
	public void save(FoodItem foodItem);

	public FoodItem findFoodItemForId(int foodItemId);

	public void deleteFoodItem(FoodItem foodItem);

	public List<FoodItem> findAll();
	
//	public List<Idea> findAll();
//	
//	public Idea findTopicForId(int id);
//
//	public void deleteIdea(Idea idea);
}
