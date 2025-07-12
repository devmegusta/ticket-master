package com.br.devgusta.ticket_master.DTO;

import com.br.devgusta.ticket_master.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketReponseDTO{

    private Long id;
    private String ticketTitle;
    private String ticketBody;
    private String level;
    private String ticketStatus;
    private LocalDateTime localDateTime;
    private String clientName;
    private String analystName;

    public TicketReponseDTO(Ticket ticket){
        this.id = ticket.getId();
        this.ticketTitle = ticket.getTicketTitle();
        this.ticketBody = ticket.getTicketBody();
        this.level = ticket.getLevel();
        this.ticketStatus = ticket.getTicketStatus();
        this.localDateTime = ticket.getLocalDateTime();
        this.clientName = ticket.getClient().getName();
        this.analystName = ticket.getAnalyst().getAnalystName();

    }

}
