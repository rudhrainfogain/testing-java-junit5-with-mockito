package com.infogain.petclinic;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AnnotationMocksTest {
	/*
	 * Creating a simple mock with annotations
	 */
	@Mock
	Map<String, Object> mapMock;

	/**
	 * @author Rudhra Koul This method initializes all the mock objects in this test
	 *         class
	 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testMock() {
		/*
		 * Doesnt actually add anything to any map
		 */
		mapMock.put("name", "rudhra");
		/*
		 * returns null as we havent provided any implementation details for the get
		 * method
		 */
		System.out.println(mapMock.get("name"));
		/*
		 * Returns zero as it is default value for primitive type int
		 */
		System.out.println(mapMock.size());
	}
}