package com.infogain.petclinic.model;
import org.junit.jupiter.api.Test;

import com.infogain.petclinic.testinterfaces.ModelsTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
class OwnerTest implements ModelsTests{

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Rudhra", "Koul");
        owner.setCity("Greater Noida");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Rudhra", owner.getFirstName(), "First Name Did not Match"),
                        () -> assertEquals("Koul", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Greater Noida", owner.getCity(), "City Did Not Match"),
                        () -> assertEquals("1231231234", owner.getTelephone())
                ));
    }
}