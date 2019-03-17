package com.infogain.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.infogain.petclinic.model.Speciality;
import com.infogain.petclinic.repositories.SpecialtyRepository;
import com.infogain.petclinic.services.springdatajpa.SpecialitySDJpaService;

/**
 * 
 * @author Rudhra Koul Example to inject dependent objects into the class under
 *         test using mockito
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness=Strictness.STRICT_STUBS)
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
		// Given-none

		// When

		/*
		 * DeleteById() uses an object of SpecialtyRepository which was autowired into
		 * the class .For testing purposes we are making it to use the mocked version of
		 * SpecialtyRepository
		 */
		service.deleteById(1l);
		service.deleteById(1l);

		// Then

		/*
		 * Verify that specialtyRepository was called 2 times for the method
		 * deleteById() with parameter of 1l
		 */
		then(specialtyRepository).should(times(2)).deleteById(1l);
	}

	@Test
	void deleteByIdAtLeast() {
		// Given-none

		// When

		service.deleteById(1l);
		service.deleteById(1l);

		// Then

		/*
		 * Verify that specialtyRepository was called at least 1 times for the method
		 * deleteById() with parameter of 1l
		 */
		then(specialtyRepository).should(timeout(100).atLeastOnce()).deleteById(1l);
	}

	@Test
	void deleteByIdAtMost() {
		// Given-none

		// When

		service.deleteById(1l);
		service.deleteById(1l);

		// Then

		/*
		 * Verify that specialtyRepository was called at most 5 times for the method
		 * deleteById() with parameter of 1l
		 */
		then(specialtyRepository).should(atMost(5)).deleteById(1l);
	}

	@Test
	void deleteByIdNever() {
		// Given-none

		// When

		service.deleteById(1l);
		service.deleteById(1l);

		// Then

		/*
		 * Verify that specialtyRepository was called at least 1 times for the method
		 * deleteById() with parameter of 1l
		 */
		then(specialtyRepository).should(timeout(100).atLeastOnce()).deleteById(1l);
		/*
		 * Verify that specialtyRepository was never called for the method deleteById()
		 * with parameter of 5l
		 */
		then(specialtyRepository).should(never()).deleteById(5l);
	}

	@Test
	void testDelete() {
		// Given

		/*
		 * The instance that we are going to use as a parameter for our mock
		 */
		Speciality speciality = new Speciality();

		// When

		/*
		 * Delete() uses an object of SpecialtyRepository which was autowired into the
		 * class .For testing purposes we are making it to use the mocked version of
		 * SpecialtyRepository
		 */
		service.delete(speciality);

		// Then

		/*
		 * Verify that specialtyRepository was called 1 times for the method delete()
		 * with any parameter of type Speciality
		 */
		then(specialtyRepository).should(timeout(100)).delete(any(Speciality.class));
	}

	@Test
	void findByIdTest() {
		// Given
		Speciality speciality = new Speciality();
		given(specialtyRepository.findById(1L)).willReturn(Optional.of(speciality));

		// When
		Speciality foundSpecialty = service.findById(1L);

		// Then
		assertThat(foundSpecialty).isNotNull();
		then(specialtyRepository).should().findById(anyLong());
		then(specialtyRepository).should(timeout(100).times(1)).findById(anyLong());
		then(specialtyRepository).shouldHaveNoMoreInteractions();
	}

	/**
	 * Throwing exceptions with mockito without BDD
	 */
	@Test
	void testDoThrow() {
		doThrow(new RuntimeException("boom")).when(specialtyRepository).delete(any());

		assertThrows(RuntimeException.class, () -> specialtyRepository.delete(new Speciality()));

		verify(specialtyRepository).delete(any());
	}

	/**
	 * Throwing exceptions with mockito BDD Style
	 */
	@Test
	void testFindByIDThrows() {
		given(specialtyRepository.findById(1L)).willThrow(new RuntimeException("boom"));

		assertThrows(RuntimeException.class, () -> service.findById(1L));

		then(specialtyRepository).should().findById(1L);
	}

	/**
	 * Throwing exceptions with mockito for a method with void return type
	 */
	@Test
	void testDeleteBDD() {
		willThrow(new RuntimeException("boom")).given(specialtyRepository).delete(any());

		assertThrows(RuntimeException.class, () -> specialtyRepository.delete(new Speciality()));

		then(specialtyRepository).should().delete(any());
	}

	@Test
	void testSaveLambda() {
		// given
		final String MATCH_ME = "MATCH_ME";
		Speciality speciality = new Speciality();
		speciality.setDescription(MATCH_ME);

		Speciality savedSpecialty = new Speciality();
		savedSpecialty.setId(1L);

		// need mock to only return on match MATCH_ME string
		given(specialtyRepository.save(argThat(argument -> argument.getDescription().equals(MATCH_ME))))
				.willReturn(savedSpecialty);

		// when
		Speciality returnedSpecialty = service.save(speciality);

		// then
		assertThat(returnedSpecialty.getId()).isEqualTo(1L);
	}

	@Test
	@MockitoSettings(strictness=Strictness.LENIENT)
	void testSaveLambdaNoMatch() {
		// given
		final String MATCH_ME = "MATCH_ME";
		Speciality speciality = new Speciality();
		speciality.setDescription("Not a match");

		Speciality savedSpecialty = new Speciality();
		savedSpecialty.setId(1L);

		// need mock to only return on match MATCH_ME string
		given(specialtyRepository.save(argThat(argument -> argument.getDescription().equals(MATCH_ME))))
				.willReturn(savedSpecialty);

		// when
		Speciality returnedSpecialty = service.save(speciality);

		// then
		assertNull(returnedSpecialty);
	}
}
