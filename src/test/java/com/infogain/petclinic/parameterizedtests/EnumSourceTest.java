package com.infogain.petclinic.parameterizedtests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import com.infogain.petclinic.model.OwnerType;

public class EnumSourceTest {
	@DisplayName("Enum Source Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@EnumSource(OwnerType.class)
	void enumTest(OwnerType ownerType) {
		System.out.println(ownerType);
	}

}
