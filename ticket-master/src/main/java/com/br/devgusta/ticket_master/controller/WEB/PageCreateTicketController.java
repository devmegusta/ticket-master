package com.br.devgusta.ticket_master.controller.WEB;
import com.br.devgusta.ticket_master.DTO.TicketRequestDTO;
import com.br.devgusta.ticket_master.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageCreateTicketController {

    @Autowired
    private TicketService ticketService;


    @GetMapping("/tickets/create")
    public String showCreateTicketForm(Model model) {
        return "create-ticket";
    }


    @PostMapping("/tickets/create")
    public String createTicket(@ModelAttribute TicketRequestDTO ticketDTO, Model model) {
        ticketService.createTicket(ticketDTO);
        model.addAttribute("message", "Chamado criado com sucesso! Fique atento(a) ao seu e-mail!");
        return "create-ticket-success";
    }
}
