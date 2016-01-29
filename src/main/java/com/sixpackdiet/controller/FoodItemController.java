package com.sixpackdiet.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sixpackdiet.bean.FoodItem;
import com.sixpackdiet.bean.MeasurementUnit;
import com.sixpackdiet.service.FoodItemService;

@Controller
public class FoodItemController {
	
	@Autowired
	FoodItemService foodItemService;
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	    //The date format to parse or output your dates
	    SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
	    //Sun Nov 22 12:01:19 CST 2015
	    //Create a new CustomDateEditor
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    //Register it as custom editor for the Date type
	    binder.registerCustomEditor(Date.class, "submitDate", editor);
	}
	
	@RequestMapping(value="/createFood")
	public ModelAndView displayHome(@ModelAttribute("foodItemForm") FoodItem foodItem) {
		
		List<String> measurements = new ArrayList<String>();
		for(MeasurementUnit measurementUnit : MeasurementUnit.values()) {
			measurements.add(measurementUnit.name());
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("measurementList", measurements);
		modelAndView.setViewName("createFoodItem");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/showFoodCalories")
	public ModelAndView showCaloriesConsumedPage(@ModelAttribute("foodItemForm") FoodItem foodItem) {
		
		List<FoodItem> foodItems = foodItemService.findAll();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("foodItems", foodItems);
		modelAndView.setViewName("calorieCountForFoodItems");
		return modelAndView;
	}
	
	@RequestMapping(value="/submitFoodItem", method=RequestMethod.POST )
	public ModelAndView submitFoodItem(@ModelAttribute("foodItemForm") FoodItem foodItem) {
		System.out.println(foodItem.getName());
		foodItemService.saveFoodItem(foodItem);
		ModelAndView model = new ModelAndView("showAllFoodItems");
		model.addObject("message1", "Food item saved successfully");
		
		List<FoodItem> foodItems = foodItemService.findAll();
		model.addObject("foodItems",foodItems);
		return model;
	}
	
	@RequestMapping(value="/foodItems/{foodItemId}", method=RequestMethod.GET )
	public ModelAndView getFoodItems(@PathVariable int foodItemId) {
		
		FoodItem foodItem = foodItemService.findFoodItemForId(foodItemId);
		System.out.println(foodItem.getName());
		String message = "Here are the details of the selected foodItem  : "+foodItem.getName();
		ModelAndView model = new ModelAndView("showFood");
		model.addObject("message1", message);
		model.addObject("foodItemForm", foodItem);
		return model;
	}
	
	@RequestMapping(value="/foodItems/{foodItemId}", method=RequestMethod.POST )
	public ModelAndView deleteFoodItem(@PathVariable int foodItemId) {
		
		FoodItem foodItem = foodItemService.findFoodItemForId(foodItemId);
		System.out.println(foodItem.getName());
		String message = "Deleted the Food Item  : "+foodItem.getName();
		foodItemService.deleteFoodItem(foodItem);

		List<FoodItem> foodItems = foodItemService.findAll();
		ModelAndView model = new ModelAndView("showAllFoodItems");
		model.addObject("foodItems",foodItems);
		model.addObject("message1", message);
		return model;	
	}
		
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
		String message = "WELCOME To MVC !!";
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
}