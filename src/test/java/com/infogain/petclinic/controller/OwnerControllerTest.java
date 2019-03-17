package com.infogain.petclinic.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.infogain.petclinic.controllers.OwnerController;
import com.infogain.petclinic.fauxspring.BindingResult;
import com.infogain.petclinic.fauxspring.Model;
import com.infogain.petclinic.model.Owner;
import com.infogain.petclinic.services.OwnerService;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	private static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
	private static final String REDIRECT_OWNERS_5 = "redirect:/owners/5";

	@Mock
	OwnerService ownerService;

	@InjectMocks
	OwnerController controller;

	@Mock
	BindingResult bindingResult;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	@Mock
    Model model;
	@BeforeEach
	void setUp() {
		given(ownerService.findAllByLastNameLike(stringArgumentCaptor.capture())).willAnswer(invocation -> {
			List<Owner> owners = new ArrayList<>();

			String name = invocation.getArgument(0);

			if (name.equals("%Koul%")) {
				owners.add(new Owner(1l, "Rudhra", "Koul"));
				return owners;
			} else if (name.equals("%DontFindMe%")) {
				return owners;
			} else if (name.equals("%FindMe%")) {
				owners.add(new Owner(1l, "Rudhra", "Koul"));
				owners.add(new Owner(2l, "Rudhra2", "Koul2"));
				return owners;
			}

			throw new RuntimeException("Invalid Argument");
		});
	}

	@MockitoSettings(strictness = Strictness.LENIENT)
	@Test
	void processCreationFormHasErrors() {
		// given
		Owner owner = new Owner(1l, "Rudhra", "Koul");
		given(bindingResult.hasErrors()).willReturn(true);

		// when
		String viewName = controller.processCreationForm(owner, bindingResult);

		// then
		assertThat(viewName).isEqualToIgnoringCase(OWNERS_CREATE_OR_UPDATE_OWNER_FORM);
	}

	@MockitoSettings(strictness = Strictness.LENIENT)
	@Test
	void processCreationFormNoErrors() {
		// given
		Owner owner = new Owner(5l, "Rudhra", "Koul");
		given(bindingResult.hasErrors()).willReturn(false);
		given(ownerService.save(any())).willReturn(owner);

		// when
		String viewName = controller.processCreationForm(owner, bindingResult);

		// then
		assertThat(viewName).isEqualToIgnoringCase(REDIRECT_OWNERS_5);
	}

	@Test
	void processFindFormWildcardFound() {
		// given
		Owner owner = new Owner(1l, "Rudhra", "FindMe");
		InOrder inOrder = inOrder(ownerService, model);
		// when
		String viewName = controller.processFindForm(owner, bindingResult, model);

		// then
		assertThat("%FindMe%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
		assertThat("owners/ownersList").isEqualToIgnoringCase(viewName);
		
		// inorder asserts
        inOrder.verify(ownerService).findAllByLastNameLike(anyString());
        inOrder.verify(model).addAttribute(anyString(), anyList());
        verifyNoMoreInteractions(model);
	}

	@Test
	void processFindFormWildcardStringAnnotation() {
		// given
		Owner owner = new Owner(1l, "Rudhra", "Koul");

		// when
		String viewName = controller.processFindForm(owner, bindingResult, null);

		// then
		assertThat("%Koul%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
		 verifyZeroInteractions(model);
	}

	@Test
	void processFindFormWildcardNotFound() {
		// given
		Owner owner = new Owner(1l, "Rudhra", "DontFindMe");

		// when
		String viewName = controller.processFindForm(owner, bindingResult, null);

		  verifyNoMoreInteractions(ownerService);
		// then
		assertThat("%DontFindMe%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
		assertThat("owners/findOwners").isEqualToIgnoringCase(viewName);
		 verifyZeroInteractions(model);
	}

}