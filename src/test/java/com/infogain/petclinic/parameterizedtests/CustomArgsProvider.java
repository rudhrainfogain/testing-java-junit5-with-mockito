package com.infogain.petclinic.parameterizedtests;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CustomArgsProvider implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
                Arguments.of("FL", 5, 1),
                Arguments.of("OH", 2, 8),
                Arguments.of("MI", 3, 5));
	}

}
