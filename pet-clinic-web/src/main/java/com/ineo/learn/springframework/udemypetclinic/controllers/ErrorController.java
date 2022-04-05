package com.ineo.learn.springframework.udemypetclinic.controllers;

import com.ineo.learn.springframework.udemypetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping({"/oups", "/oups.html"})
    public String showError(Model model) {

        return "errors/genericError";
    }
}
