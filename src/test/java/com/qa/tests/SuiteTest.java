package com.qa.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)

@SuiteClasses( { TrainerControllerTests.class, PlanControllerTests.class, AccountControllerTests.class,  } )

public class SuiteTest {

}