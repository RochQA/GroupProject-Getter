package com.qa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy ="native")
	private Long id;

	private String email;
	
	private String password;
	
	private Long trainerId;
	
	private enum accountType{
		ADMIN,
		TRAINER
	};
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}


	
	
	
}
