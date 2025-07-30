package com.example.RestApi.RestAPIDemo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.example.RestApi.RestAPIDemo.Entity.Tasks;
import com.example.RestApi.RestAPIDemo.Repository.TaskRepository;

@Service
public class taskServices {
	
	@Autowired
	TaskRepository repo;

	public void addTask(Tasks task) {
		// TODO Auto-generated method stub
		repo.save(task);
		
	}

	public List<Tasks> getAllTasks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	

	public Optional<Tasks> getTaskById(int tId) {
		// TODO Auto-generated method stub
		return repo.findById(tId);
	}

	public void updateTask(Tasks task) {
		// TODO Auto-generated method stub
		
		 repo.save(task);
		
	}

	public void deleteTaskById(int tId) {
		// TODO Auto-generated method stub
		
		repo.deleteById(tId);
		
	}
	
	

}
