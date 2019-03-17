package com.infogain.petclinic.parameterizedtests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CSVSourceTest {
	@DisplayName("CSV Input Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@CsvSource({ "FL, 1, 1", "OH, 2, 2", "MI, 3, 1" })
	void csvInputTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}

}
