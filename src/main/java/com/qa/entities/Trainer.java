package com.qa.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Trainer {

	@Id
	private Long id;
	
	private String name;
	
	@OneToMany
	@JoinColumn(name = "trainerId", nullable = false, insertable = false, updatable = false)
	private List<Plan> plans;
	
	public Trainer() {
		
	}

	public Trainer(Long id, String name) {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
}
