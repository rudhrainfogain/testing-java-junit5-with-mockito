package com.infogain.petclinic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.infogain.petclinic.controllers.IndexController;
import com.infogain.petclinic.exceptions.ValueNotFoundException;
import com.infogain.petclinic.testinterfaces.ControllersTests;
class IndexControllerTest implements ControllersTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");

        assertEquals("index", controller.index(), () -> "Another Expensive Message " +
                "Make me only if you have to");
    }

    @Test
    @DisplayName("Test exception")
    void oopsHandler() {
    	 assertThrows(ValueNotFoundException.class, () -> {
             controller.oopsHandler();
         });
    }
}