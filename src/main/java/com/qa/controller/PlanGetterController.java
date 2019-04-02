package com.qa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entities.TrainerPlan;
import com.qa.repository.PlanRepository;
@RestController
public class PlanGetterController {
	
	PlanRepository repo;
	
	public PlanGetterController(PlanRepository repo) {
		this.repo = repo;
	}
	
	@PostMapping("/createPlan")
	public String addNewUser(@RequestBody TrainerPlan plan) {
		repo.save(plan);
		return "Saved";
	}
	
	@GetMapping("/getPlan")
	public Optional<TrainerPlan> getPlan(@RequestBody Long planId){
		return repo.findById(planId);
	}
	@GetMapping("/getAllPlans")
	public List<TrainerPlan> getAllPlans(){
		return (List<TrainerPlan>) repo.findAll();
	}
	@PutMapping("/updatePlan")
	public String updatePlan(@RequestBody TrainerPlan plan) {
		repo.save(plan);
		return "Updated";
	}
	@DeleteMapping("/deletePlan")
	public String deletePlan(@RequestBody Long planId) {
		repo.deleteById(planId);
		return "deleted";		
	}
}
