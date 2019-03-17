package com.infogain.petclinic.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.infogain.petclinic.model.Owner;
import com.infogain.petclinic.services.springdatajpa.OwnerSDJpaService;

@Disabled(value = "Disabled until we learn Mocking")
class OwnerSDJpaServiceTest {

    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        service = new OwnerSDJpaService(null, null, null);

    }

    @Disabled
    @Test
    void findByLastName() {
        Owner foundOwner = service.findByLastName("Rudhra");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}