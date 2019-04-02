package com.qa.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class TrainerPlan {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy ="native")
	private Long Id;
	
	private String topic;
	
	private String trainerName; 
	
	private String traineeGroup;
	
	private Date startDate;
	
	private Date endDate;
	
	private String room;

	public Date getEndDate() {
		return endDate;
	}

	public Long getId() {
		return Id;
	}

	public String getRoomNumber() {
		return room;
	}

	public void setRoomNumber(String room) {
		this.room = room;
	}

	public Date getStartDate() {
		return startDate;
	}

	public String getTopic() {
		return topic;
	}

	public String getTraineeGroup() {
		return traineeGroup;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setId(Long id) {
		Id = id;
	}

	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setTraineeGroup(String traineeGroup) {
		this.traineeGroup = traineeGroup;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	
	
	
	

}
