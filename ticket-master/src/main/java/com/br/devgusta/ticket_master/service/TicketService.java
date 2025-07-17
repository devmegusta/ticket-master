package com.br.devgusta.ticket_master.service;
import com.br.devgusta.ticket_master.DTO.TicketReponseDTO;
import com.br.devgusta.ticket_master.DTO.TicketRequestDTO;
import com.br.devgusta.ticket_master.model.Analyst;
import com.br.devgusta.ticket_master.model.Client;
import com.br.devgusta.ticket_master.model.Ticket;
import com.br.devgusta.ticket_master.repository.AnalystRepository;
import com.br.devgusta.ticket_master.repository.ClientRepository;
import com.br.devgusta.ticket_master.repository.TicketRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AnalystRepository analystRepository;

    public TicketReponseDTO createTicket(TicketRequestDTO dto){
        Ticket ticket = new Ticket();
        Client client = clientRepository.findById(dto.getClientId())
                        .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o id: "
                                + dto.getClientId()));

        Analyst analyst = analystRepository.findById(dto.getAnalystId())
                        .orElseThrow(() -> new RuntimeException("Analista não encontrado com o id: "
                                + dto.getAnalystId()));

        ticket.setTicketTitle(dto.getTicketTitle());
        ticket.setTicketBody(dto.getTicketBody());
        ticket.setLevel(dto.getLevel());
        ticket.setTicketStatus(dto.getTicketStatus());
        ticket.setLocalDateTime(dto.getLocalDateTime());
        ticket.setClient(client);
        ticket.setAnalyst(analyst);

        Ticket savedTicket = ticketRepository.save(ticket);
        return new TicketReponseDTO(savedTicket);
    }

    public TicketReponseDTO getTicketById(Long id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado pelo o id " + id +
                        " .Verifique o id fornecido e tente novamente!"));

        return new TicketReponseDTO(ticket);
    }

    public List<TicketReponseDTO> getAllTickets(){

        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(TicketReponseDTO::new)
                .collect(Collectors.toList());

    }

    public TicketReponseDTO updateTicket (Long id, TicketRequestDTO dto){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado pelo o id " + id +
                        " .Verifique o id fornecido e tente novamente!"));

        ticket.setTicketTitle(dto.getTicketTitle());
        ticket.setTicketBody(dto.getTicketBody());
        ticket.setTicketStatus(dto.getTicketStatus());

        Ticket updatedTicket = ticketRepository.save(ticket);
        return new TicketReponseDTO(updatedTicket);
    }

    public void deleteTicket(Long id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado pelo o id " + id +
                        " .Verifique o id fornecido e tente novamente!"));
        ticketRepository.delete(ticket);
    }

}
