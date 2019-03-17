package com.infogain.petclinic.controllers;

import javax.validation.Valid;

import com.infogain.petclinic.fauxspring.BindingResult;
import com.infogain.petclinic.fauxspring.WebDataBinder;
import com.infogain.petclinic.model.Pet;
import com.infogain.petclinic.model.Visit;
import com.infogain.petclinic.services.PetService;
import com.infogain.petclinic.services.VisitService;

import java.util.Map;


public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public Visit loadPetWithVisit(Long petId, Map<String, Object> model) {
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    public String initNewVisitForm(Long petId, Map<String, Object> model) {
        return "pets/createOrUpdateVisitForm";
    }

    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);

            return "redirect:/owners/{ownerId}";
        }
    }
}
