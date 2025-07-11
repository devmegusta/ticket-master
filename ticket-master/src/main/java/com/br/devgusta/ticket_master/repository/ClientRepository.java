package com.br.devgusta.ticket_master.repository;

import com.br.devgusta.ticket_master.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
}
