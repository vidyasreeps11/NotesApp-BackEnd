package com.euphoticlabs.assignment.DishApp_Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.euphoticlabs.assignment.DishApp_Backend.model.Dish;
import com.euphoticlabs.assignment.DishApp_Backend.repository.DishesRepository;

@Service
public class DishesServiceImpl implements DishesService{
	
	@Autowired
	private DishesRepository dishesRepository;

	@Override
	public Dish saveDish(Dish dish) {
		// TODO Auto-generated method stub
		return dishesRepository.save(dish);
	}

	@Override
	public List<Dish> getAllDishes() {
		// TODO Auto-generated method stub
		return dishesRepository.findAll();
	}

	@Override
	public Dish getDishById(Integer id) {
		// TODO Auto-generated method stub
		return dishesRepository.findById(id).get();
	}

	@Override
	public void deleteDishById(Integer id) {
		// TODO Auto-generated method stub
		
		dishesRepository.deleteById(id);
		
	}

	@Override
	public Dish updateDish(Dish updatedDish,Integer id) {
		// TODO Auto-generated method stub
		
		Dish dish=dishesRepository.findById(id).get();
		
		dish.setDishName(updatedDish.getDishName());
		dish.setImageUrl(updatedDish.getImageUrl());
		dish.setPublished(updatedDish.isPublished());
		
		return dishesRepository.save(dish);
	}
	

}
