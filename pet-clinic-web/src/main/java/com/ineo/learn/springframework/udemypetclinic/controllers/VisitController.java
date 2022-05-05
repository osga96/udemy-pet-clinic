package com.ineo.learn.springframework.udemypetclinic.controllers;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Owner;
import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Pet;
import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Visit;
import com.ineo.learn.springframework.udemypetclinic.repositories.OwnerRepository;
import com.ineo.learn.springframework.udemypetclinic.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class VisitController {
    private final OwnerRepository owners;
    private final PetService petService;

    public VisitController(OwnerRepository owners, PetService petService) {
        this.owners = owners;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * Called before each and every @RequestMapping annotated method. 2 goals: - Make sure
     * we always have fresh data - Since we do not use the session scope, make sure that
     * Pet object always has an id (Even though id is not part of the form fields)
     * @param petId
     * @return Pet
     */
    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("ownerId") Long ownerId, @PathVariable("petId") Long petId,
                                  Map<String, Object> model) {
        Owner owner = null;
        if (this.owners.findById(ownerId).isPresent()) {
            owner = this.owners.findById(ownerId).get();
        }
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        model.put("owner", owner);
        Visit visit = new Visit();
        pet.addVisit(visit);
        visit.setPet(pet);
        return visit;
    }

    // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
    @GetMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") int petId, Map<String, Object> model) {
        return "pets/createOrUpdateVisitForm";
    }

    // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called

    // IMPORTANT: BindingResult permite poder usar #dates y #temporals
    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@ModelAttribute Owner owner, @PathVariable Long petId, @Valid Visit visit,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        }
        else {
            owner.addVisit(petId, visit);
            this.owners.save(owner);
            return "redirect:/owners/{ownerId}";
        }
    }
}
