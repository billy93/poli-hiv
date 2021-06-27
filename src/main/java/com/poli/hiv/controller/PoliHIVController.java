package com.poli.hiv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoliHIVController {

    @GetMapping("/poli-hiv/form")
    public String index(Model model){
        return "poli-hiv/poli-hiv";
    }

    @GetMapping("/poli-hiv/list")
    public String list(Model model){
        return "poli-hiv/list";
    }

}
