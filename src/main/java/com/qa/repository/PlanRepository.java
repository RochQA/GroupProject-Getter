package com.qa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qa.entities.Plan;

@Repository
public interface PlanRepository extends CrudRepository<Plan, Long>{

//	Plan findPlan(Long trainerId, Long planId);

}
