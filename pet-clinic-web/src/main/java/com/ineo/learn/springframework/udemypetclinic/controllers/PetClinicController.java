package com.ineo.learn.springframework.udemypetclinic.controllers;

import com.ineo.learn.springframework.udemypetclinic.services.map.OwnerServiceMap;
import com.ineo.learn.springframework.udemypetclinic.services.map.PetServiceMap;
import com.ineo.learn.springframework.udemypetclinic.services.map.VetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetClinicController {
    private OwnerServiceMap ownerServiceMap;
    private PetServiceMap petServiceMap;
    private VetServiceMap vetServiceMap;

    @RequestMapping({"/", "", "index", "index.html", ".html"})
    private String index() {
        return "index";
    }
}
