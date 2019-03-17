package com.infogain.petclinic.service;

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
	}

	@Test
	void testDelete() {
		/*
		 * Delete() uses an object of SpecialtyRepository which was autowired into the
		 * class .For testing purposes we are making it to use the mocked version of
		 * SpecialtyRepository
		 */
		service.delete(new Speciality());
	}
}
