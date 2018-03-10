package com.startrac.stspringdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.startrac.stspringdata.services.HipsterService;

@Controller
public class HipsterController {
    
    private final HipsterService hipsterService;

    public HipsterController(HipsterService hipsterService) {
        this.hipsterService = hipsterService;
    }
    
    @GetMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("hipsters", hipsterService.listAllHipsters());
        return "index";
    }

}
