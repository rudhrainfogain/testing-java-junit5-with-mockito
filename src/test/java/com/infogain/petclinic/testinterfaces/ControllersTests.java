package com.infogain.petclinic.testinterfaces;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@Tag("Controller")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ControllersTests {
	 @BeforeAll
	    default void beforeAll(){
	        System.out.println("Lets do something here");
	    }
}
