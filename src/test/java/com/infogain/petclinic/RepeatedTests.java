package com.infogain.petclinic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTests {
	 @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
	    @DisplayName("My Repeated Test")
	    void myRepeatedTest() {
	        //todo - impl
	    }
	 
	 @RepeatedTest(10)
	    @DisplayName("My Repeated Testa")
	    void myRepeatedTesta() {
	        //todo - impl
	    }
}
