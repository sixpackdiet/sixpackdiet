package com.sixpackdiet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixpackdiet.bean.FoodItem;
import com.sixpackdiet.dao.FoodItemDao;
import com.sixpackdiet.service.FoodItemService;

@Service
public class FoodItemServiceImpl implements FoodItemService {
	
	@Autowired
	private FoodItemDao foodItemDao;
	
	public void saveFoodItem(FoodItem foodItem) {
		foodItemDao.save(foodItem);
	}

	@Override
	public FoodItem findFoodItemForId(int foodItemId) {
		return foodItemDao.findFoodItemForId(foodItemId);
	}

	@Override
	public void deleteFoodItem(FoodItem foodItem) {
		// TODO Auto-generated method stub
		foodItemDao.deleteFoodItem(foodItem);
	}

	@Override
	public List<FoodItem> findAll() {
		// TODO Auto-generated method stub
		return foodItemDao.findAll();
	}
}