package com.ineo.learn.springframework.udemypetclinic.controllers;

import com.ineo.learn.springframework.udemypetclinic.modelPOJO.Owner;
import com.ineo.learn.springframework.udemypetclinic.repositories.OwnerRepository;
import com.ineo.learn.springframework.udemypetclinic.services.OwnerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;
    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerService ownerService, OwnerRepository ownerRepository) {
        this.ownerService = ownerService;
        this.ownerRepository = ownerRepository;
    }

    @RequestMapping({"find/deprecated", "/find/deprecated", "/find/deprecated/index", "/find/deprecated/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/find/index";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView modelAndView = new ModelAndView("/owners/ownerDetails");
        modelAndView.addObject(this.ownerService.findById(ownerId));
        return modelAndView;
    }

    // Nombre de método no descriptivo, copiado desde el repo original de spring.
    // Se usa para añadir seguridad a los formularios, quitando el control de enlazar los IDs.
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/find")
    public String processFindFormQueryStyle(@RequestParam(defaultValue = "1") int page, Owner owner, BindingResult result,
                                  Model model) {

        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        String lastName = owner.getLastName();

        Page<Owner> ownersResults = findPaginatedForOwnersLastName(page, lastName);


        if (lastName.equals("")) {
            return "owners/findOwners";
        }

        if (ownersResults.getContent().isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }
        else if (ownersResults.getTotalElements() == 1) {
            // 1 owner found
            owner = ownersResults.iterator().next();
            return "redirect:/owners/" + owner.getId();
        }
        else {
            // multiple owners found
            lastName = owner.getLastName();
            return addPaginationModel(page, model, lastName, ownersResults);
        }
    }

    private Page<Owner> findPaginatedForOwnersLastName(int page, String lastname) {

        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return ownerRepository.findByLastNameQuery(lastname, pageable);

    }

    private String addPaginationModel(int page, Model model, String lastName, Page<Owner> paginated) {
        model.addAttribute("listOwners", paginated);
        List<Owner> listOwners = paginated.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", paginated.getTotalPages());
        model.addAttribute("totalItems", paginated.getTotalElements());
        model.addAttribute("listOwners", listOwners);
        return "owners/ownersList";
    }

    @GetMapping("/find/using/jpa")
    public String processFindFormJPAStyle(@RequestParam(defaultValue = "1") int page, Owner owner, BindingResult result,
                                            Model model) {

        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> ownersResults = ownerService.findAllByLastName(owner.getLastName());

        if (ownersResults.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (ownersResults.size() == 1) {
            owner = ownersResults.iterator().next();
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("listOwners", ownersResults);
            return "owners/ownersList";
        }


    }



}
