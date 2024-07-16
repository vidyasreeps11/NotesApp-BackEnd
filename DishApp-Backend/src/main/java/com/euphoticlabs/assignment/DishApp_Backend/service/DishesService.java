package com.euphoticlabs.assignment.DishApp_Backend.service;

import java.util.List;

import com.euphoticlabs.assignment.DishApp_Backend.model.Dish;

public interface DishesService {

	public Dish saveDish(Dish dish);
	public List<Dish> getAllDishes();
	public Dish getDishById(Integer id);
	public void deleteDishById(Integer id);
	public Dish updateDish(Dish dish,Integer id);
	
		
		
	
}
