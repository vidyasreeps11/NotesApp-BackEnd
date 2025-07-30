package com.example.RestApi.RestAPIDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RestApi.RestAPIDemo.Entity.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer> {

}
