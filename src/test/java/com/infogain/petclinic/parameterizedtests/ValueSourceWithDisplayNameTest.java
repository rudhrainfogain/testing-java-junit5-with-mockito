package com.infogain.petclinic.parameterizedtests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValueSourceWithDisplayNameTest {
    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Great", "Rudhra", "Koul"})
    void testValueSource(String val) {
        System.out.println(val);
    }
	 
}
