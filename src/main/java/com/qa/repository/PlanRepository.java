package com.qa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qa.entities.TrainerPlan;

@Repository
public interface PlanRepository extends CrudRepository<TrainerPlan, Long>{

//	Plan findPlan(Long trainerId, Long planId);

}
