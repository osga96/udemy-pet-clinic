package com.ineo.learn.springframework.udemypetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String listVets(Model model) {

        model.addAttribute("vets", new String[]{"test", "test", "test", "test"});

        return "vets/index";
    }
}
