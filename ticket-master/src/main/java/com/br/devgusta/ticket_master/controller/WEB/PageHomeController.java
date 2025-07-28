package com.br.devgusta.ticket_master.controller.WEB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageHomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "home";

    }
}