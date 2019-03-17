package com.infogain.petclinic.service;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.infogain.petclinic.model.Speciality;
import com.infogain.petclinic.repositories.SpecialtyRepository;
import com.infogain.petclinic.services.springdatajpa.SpecialitySDJpaService;

/**
 * 
 * @author Rudhra Koul Example to inject dependent objects into the class under
 *         test using mockito
 */
@ExtendWith(MockitoExtension.class)
public class SpecialitySDJpaServiceTest {
	/*
	 * Mocking the dependent SpecialtyRepository which is used in the class we are
	 * testing ie SpecialitySDJpaService
	 */
	@Mock
	SpecialtyRepository specialtyRepository;

	/*
	 * Injecting all the dependencies into the Class under test
	 */
	@InjectMocks
	SpecialitySDJpaService service;

	@Test
	void deleteById() {
		/*
		 * DeleteById() uses an object of SpecialtyRepository which was autowired into
		 * the class .For testing purposes we are making it to use the mocked version of
		 * SpecialtyRepository
		 */
		service.deleteById(1l);
		service.deleteById(1l);

		/*
		 * Verify that specialtyRepository was called 2 times for the method
		 * deleteById() with parameter of 1l
		 */
		verify(specialtyRepository, times(2)).deleteById(1l);
	}

	@Test
	void deleteByIdAtLeast() {
		service.deleteById(1l);
		service.deleteById(1l);
		/*
		 * Verify that specialtyRepository was called at least 1 times for the method
		 * deleteById() with parameter of 1l
		 */
		verify(specialtyRepository, atLeastOnce()).deleteById(1l);
	}

	@Test
	void deleteByIdAtMost() {
		service.deleteById(1l);
		service.deleteById(1l);
		/*
		 * Verify that specialtyRepository was called at most 5 times for the method
		 * deleteById() with parameter of 1l
		 */
		verify(specialtyRepository, atMost(5)).deleteById(1l);
	}

	@Test
	void deleteByIdNever() {
		service.deleteById(1l);
		service.deleteById(1l);
		/*
		 * Verify that specialtyRepository was called at least 1 times for the method
		 * deleteById() with parameter of 1l
		 */
		verify(specialtyRepository, atLeastOnce()).deleteById(1l);
		/*
		 * Verify that specialtyRepository was never called for the method deleteById()
		 * with parameter of 5l
		 */
		verify(specialtyRepository, never()).deleteById(5L);
	}

	@Test
	void testDelete() {
		Speciality speciality = new Speciality();
		/*
		 * Delete() uses an object of SpecialtyRepository which was autowired into the
		 * class .For testing purposes we are making it to use the mocked version of
		 * SpecialtyRepository
		 */

		service.delete(speciality);

		/*
		 * Verify that specialtyRepository was called 2 times for the method
		 * deleteById() with parameter speciality
		 */
		verify(specialtyRepository, times(1)).delete(speciality);
	}
}
