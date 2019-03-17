package com.infogain.petclinic.parameterizedtests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValueSourceTest {
	 @ParameterizedTest
	    @ValueSource(strings = {"Great", "Rudhra", "Koul"})
	    void testValueSource(String val) {
	        System.out.println(val);
	    }
	 
	 
}
