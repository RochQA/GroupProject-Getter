package com.qa.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qa.entities.Trainer;
import com.qa.repository.TrainerRepository;
@Controller
@RequestMapping
public class TrainerGetterController {
	
	TrainerRepository repo;
	
	public TrainerGetterController(TrainerRepository repo) {
		this.repo = repo;
	}
	
	@PostMapping("/createTrainer")
	public String addNewUser(@RequestBody Trainer trainer) {
		repo.save(trainer);
		return "Saved";
	}
	
	@GetMapping("/getTrainer")
	public Optional<Trainer> getTrainer(@RequestBody Long trainerId){
		return repo.findById(trainerId);
	}
	@GetMapping("/getAllTrainers")
	public Iterable<Trainer> getAllTrainers(){
		return repo.findAll();
	}
	@PutMapping("/updateTrainer")
	public String updateTrainer(@RequestBody Trainer trainer) {
		repo.save(trainer);
		return "Updated";
	}
	@DeleteMapping("/deleteTrainer")
	public String deleteTrainer(@RequestBody Long trainerId) {
		repo.deleteById(trainerId);
		return "deleted";		
	}
}
