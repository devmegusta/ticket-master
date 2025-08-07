package com.br.devgusta.ticket_master.controller.WEB;

import com.br.devgusta.ticket_master.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageAnalystController {

    @Autowired
    TicketService ticketService;


    @GetMapping("/analyst/home")
    public String showAnalystPageForm(Model model){

        model.addAttribute("chamados", ticketService.getAllTickets());

        return "analyst-home";}
}
