package com.br.devgusta.ticket_master.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PageCreateTicketController {
    @GetMapping("/tickets/create")
    public String showCreateTicketForm(Model model) {

        return "create-ticket";
    }
}

