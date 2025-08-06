package com.br.devgusta.ticket_master.controller.WEB;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageAnalystController {
    @GetMapping("/analyst/home")
    public String showAnalystPageForm(Model model){return "analyst-home";}
}
