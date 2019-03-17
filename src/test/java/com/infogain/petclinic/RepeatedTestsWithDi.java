package com.infogain.petclinic;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
public class RepeatedTestsWithDi {
	@RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());

    }
	
	@RepeatedTest(5)
    void myRepeatedTestWithDI2(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ":- " + repetitionInfo.getCurrentRepetition());

    }
}
