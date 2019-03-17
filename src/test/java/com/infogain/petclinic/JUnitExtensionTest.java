package com.infogain.petclinic;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * 
 * @author Rudhra Koul The initialization of the mocks in this class will be
 *         handled by junit as we are extending the functionality of junit with
 *         Mockito extension
 *
 */
@ExtendWith(MockitoExtension.class)
public class JUnitExtensionTest {
	/*
	 * Creating a simple mock with annotations
	 */
	@Mock
	Map<String, Object> mapMock;

	@Test
	void testMock() {
		/*
		 * Doesn't actually add anything to any map
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
