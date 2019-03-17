package com.infogain.petclinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Rudhra Koul
 *
 */
public class InlineMockTest {

	@Test
	void testInlineMock() {
		/**
		 * Here we are creating a refrence variable of Map interface and asking mockito
		 * to create a mock implementation for the same. Such an implementation returns
		 * null for reference types and default values for primitive types for all the
		 * method calls on the mock object
		 */
		Map mapMock = mock(Map.class);
		/**
		 * Map.size() returns an int so mocked object returns zero as the default value
		 * for primitive int
		 */
		assertEquals(mapMock.size(), 0);
	}
}