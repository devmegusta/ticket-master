package com.br.devgusta.ticket_master.repository;

import com.br.devgusta.ticket_master.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
}
