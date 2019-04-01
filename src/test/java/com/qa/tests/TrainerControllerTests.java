package com.qa.tests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.controller.TrainerGetterController;
import com.qa.entities.Trainer;
import com.qa.repository.TrainerRepository;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
@SpringBootTest
public class TrainerControllerTests {

	@Mock
	private TrainerRepository trainerRepo;
	
	@InjectMocks
	private TrainerGetterController tgc;
	
	private Trainer trainer;
	private Trainer trainer2;
	
	private Optional<Trainer> op = Optional.empty();
	private List<Trainer> trainerList;
	
	@Before
	public void setup() {
	trainer = new Trainer();
	trainer2 = new Trainer();
	
	trainer.setId(1L);
	trainer2.setId(2L);
	trainerList = new ArrayList<Trainer>();
	
	trainerList.add(trainer);
	trainerList.add(trainer2);
	}
	
//	@Test
//	public void testCreate() {
//		Mockito.when(trainerRepo.save(trainer)).thenReturn(trainer);
//		assertEquals(tgc.addNewUser(trainer),"Saved");
//	}	
	
	@Test
	public void testGetTrainer() {
		Mockito.when(trainerRepo.findById(1L)).thenReturn(op);
		assertEquals(tgc.getTrainer(1L),op);
	}
	
	@Test
	public void testGetAllTrainers() {
		Mockito.when(trainerRepo.findAll()).thenReturn(trainerList);
		assertEquals(tgc.getAllTrainers(), trainerList);
	}
	
	@Test
	public void testUpdateTrainers() {
		Mockito.when(trainerRepo.save(trainer)).thenReturn(trainer);
		assertEquals(tgc.updateTrainer(trainer),"Updated");
	}
	
	@Test
	public void testDeleteTrainers() {
		assertEquals(tgc.deleteTrainer(1L),"deleted");
	}
}
