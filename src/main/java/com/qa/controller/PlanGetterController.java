package com.qa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entities.Constants;
import com.qa.entities.TrainerPlan;
import com.qa.repository.PlanRepository;
@RestController
public class PlanGetterController {
	
	PlanRepository repo;
	
	public PlanGetterController(PlanRepository repo) {
		this.repo = repo;
	}
	
	@PostMapping(Constants.CREATE_PLAN)
	public String addNewUser(@RequestBody TrainerPlan plan) {
		repo.save(plan);
		return Constants.SAVED;
	}
	
	@GetMapping(Constants.GET_PLAN)
	public Optional<TrainerPlan> getPlan(@RequestBody Long planId){
		return repo.findById(planId);
	}
	@GetMapping(Constants.GET_ALL_PLANS)
	public List<TrainerPlan> getAllPlans(){
		return (List<TrainerPlan>) repo.findAll();
	}
	@PutMapping(Constants.UPDATE_PLAN)
	public String updatePlan(@RequestBody TrainerPlan plan) {
		repo.save(plan);
		return Constants.UPDATED;
	}
	@DeleteMapping(Constants.DELETE_PLAN)
	public String deletePlan(@RequestBody Long planId) {
		repo.deleteById(planId);
		return Constants.DELETED;		
	}
}
