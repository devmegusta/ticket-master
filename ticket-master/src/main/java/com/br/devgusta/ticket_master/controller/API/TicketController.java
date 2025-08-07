package com.br.devgusta.ticket_master.controller.API;
import com.br.devgusta.ticket_master.DTO.TicketReponseDTO;
import com.br.devgusta.ticket_master.DTO.TicketRequestDTO;

import com.br.devgusta.ticket_master.repository.ClientRepository;
import com.br.devgusta.ticket_master.service.notification.EmailService;
import com.br.devgusta.ticket_master.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket-master/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping
    @GetMapping("/tickets/create")
    public ResponseEntity<TicketReponseDTO> createTicket(@ModelAttribute TicketRequestDTO ticketDTO){
        TicketReponseDTO createdTicket = ticketService.createTicket(ticketDTO);

        return ResponseEntity.ok(createdTicket);

    }

    @GetMapping("/analyst/home")
    public String getAllTickets(Model model){
        List<TicketReponseDTO> tickets = ticketService.getAllTickets();
        model.addAttribute("chamados", tickets);
        return "analyst-home";

    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketReponseDTO> getTicketById(@PathVariable Long id){
        TicketReponseDTO ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketReponseDTO> updateTicket(@PathVariable Long id, @RequestBody TicketRequestDTO ticketDTO){
        TicketReponseDTO updatedTicket = ticketService.updateTicket(id, ticketDTO);
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
