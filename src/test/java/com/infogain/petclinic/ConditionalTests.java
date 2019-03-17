package com.infogain.petclinic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTests {
	 @EnabledOnOs(OS.MAC)
	    @Test
	    void testMeOnMacOS() {
	    }

	    @EnabledOnOs(OS.WINDOWS)
	    @Test
	    void testMeOnWindows() {
	    }

	    @EnabledOnJre(JRE.JAVA_8)
	    @Test
	    void testMeOnJava8() {
	    }

	    @EnabledOnJre(JRE.JAVA_11)
	    @Test
	    void testMeOnJava11() {
	    }

	    @EnabledIfEnvironmentVariable(named = "usr", matches = "rudhra")
	    @Test
	    void testIfUserRudhra() {
	    }

	    @EnabledIfEnvironmentVariable(named = "usr", matches = "sandeep")
	    @Test
	    void testIfUserSandeep() {
	    }
}
