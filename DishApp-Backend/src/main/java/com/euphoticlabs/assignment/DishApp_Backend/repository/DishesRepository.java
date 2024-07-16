package com.euphoticlabs.assignment.DishApp_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.euphoticlabs.assignment.DishApp_Backend.model.Dish;

@Repository
public interface DishesRepository extends JpaRepository<Dish, Integer>{

}
