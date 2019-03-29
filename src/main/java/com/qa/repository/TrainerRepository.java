package com.qa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qa.entities.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long> {

}
