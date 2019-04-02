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
import com.qa.entities.Trainer;
import com.qa.repository.TrainerRepository;
@RestController
public class TrainerGetterController {
	
	TrainerRepository repo;
	
	public TrainerGetterController(TrainerRepository repo) {
		this.repo = repo;
	}
	
	@PostMapping(Constants.CREATE_TRAINER)
	public Long addNewTrainer(@RequestBody Trainer trainer) {
		return repo.save(trainer).getId();
	}
	
	@GetMapping(Constants.GET_TRAINER)
	public Optional<Trainer> getTrainer(@RequestBody Long trainerId){
		return repo.findById(trainerId);
	}
	@GetMapping(Constants.GET_ALL_TRAINERS)
	public List<Trainer> getAllTrainers(){
		return (List<Trainer>) repo.findAll();
	}
	@PutMapping(Constants.UPDATE_TRAINER)
	public String updateTrainer(@RequestBody Trainer trainer) {
		repo.save(trainer);
		return Constants.UPDATED;
	}
	@DeleteMapping(Constants.DELETE_TRAINER)
	public String deleteTrainer(@RequestBody Long trainerId) {
		repo.deleteById(trainerId);
		return Constants.DELETED;		
	}
}
