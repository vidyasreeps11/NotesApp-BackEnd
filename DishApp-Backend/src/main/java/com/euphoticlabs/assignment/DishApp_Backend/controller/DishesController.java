package com.euphoticlabs.assignment.DishApp_Backend.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.euphoticlabs.assignment.DishApp_Backend.model.Dish;
import com.euphoticlabs.assignment.DishApp_Backend.service.DishesService;

@CrossOrigin
@RestController
@RequestMapping("/dishes")
public class DishesController {
	
	@Autowired
	private DishesService dishesService;
	
	@PostMapping("/add")
	public String add(@RequestBody Dish dish) {
		
		dishesService.saveDish(dish);
		return "New Dish is Added";
		
	}
	
	@GetMapping("/getAll")
	public List<Dish> getAll(){
		return dishesService.getAllDishes();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dish> getById(@PathVariable Integer id)
	{
		try {
			
			Dish dish=dishesService.getDishById(id);
			return new ResponseEntity<Dish>(dish,HttpStatus.OK);
			
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			
			return new ResponseEntity<Dish>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Dish> update(@RequestBody Dish dish,@PathVariable Integer id){
		
		try {
			
			//Dish updatedDish=dishesService.getDishById(id);
			dishesService.updateDish(dish,id);
			return new ResponseEntity<Dish>(HttpStatus.OK);
			
		}catch(NoSuchElementException e)
		{
			return new ResponseEntity<Dish>(HttpStatus.NOT_FOUND);
		}
	}
}
