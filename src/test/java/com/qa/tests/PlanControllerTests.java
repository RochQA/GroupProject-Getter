package com.qa.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.controller.PlanGetterController;
import com.qa.entities.Plan;
import com.qa.repository.PlanRepository;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
@SpringBootTest
public class PlanControllerTests {
	
	@Mock
	private PlanRepository planRepo;
	
	@InjectMocks
	private PlanGetterController pgc;
	
	private Plan plan;
	private Plan plan2;
	private Optional<Plan> op = Optional.empty();
	private List<Plan> planList;
	
	@Before
	public void setup() {
		this.plan = new Plan();
		this.plan2 = new Plan();
//		plan.setPlanId(1L);
//		plan2.setPlanId(2L);
		planList = new ArrayList<Plan>();
		planList.add(plan);
		planList.add(plan2);
	}
			
	@Test
	public void testCreate() {
		Mockito.when(planRepo.save(plan)).thenReturn(plan);
		assertEquals(pgc.addNewUser(plan),"Saved");
	}	
	
	@Test
	public void testGetPlan() {
		Mockito.when(planRepo.findById(1L)).thenReturn(op);
		assertEquals(pgc.getPlan(1L),op);
	}
	
	@Test
	public void testGetAllPlans() {
		Mockito.when(planRepo.findAll()).thenReturn(planList);
		assertEquals(pgc.getAllPlans(), planList);
	}
	
	@Test
	public void testUpdatePlans() {
		Mockito.when(planRepo.save(plan)).thenReturn(plan);
		assertEquals(pgc.updatePlan(plan),"Updated");
	}
	
	@Test
	public void testDeletePlans() {
		assertEquals(pgc.deletePlan(1L),"deleted");
	}
}
