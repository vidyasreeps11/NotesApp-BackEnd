package com.example.RestApi.RestAPIDemo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApi.RestAPIDemo.Entity.Tasks;
import com.example.RestApi.RestAPIDemo.Services.taskServices;

@RestController
public class TaskController {
	
	@Autowired
	taskServices service;


	@PostMapping("/tasks")
	public void addTask(@RequestBody Tasks task)
	{
		service.addTask(task);
	}
	
	
	@GetMapping("tasks/alltasks")
	public List<Tasks> getAllTasks()
	{
		return service.getAllTasks();
	}
	
	@GetMapping("tasks/{tId}")
	public Optional<Tasks> getTaskById(@PathVariable int tId)
	{
		return service.getTaskById(tId);
	}
	
	@PutMapping("/tasks")
	public void updateTask(@RequestBody Tasks task)
	{
		service.updateTask(task);
	}
	
	@DeleteMapping("/tasks/{tId}")
	public void deleteTaskById(@PathVariable int tId)
	{
		service.deleteTaskById(tId);
	}
}
