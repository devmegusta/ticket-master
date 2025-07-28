package com.br.devgusta.ticket_master.controller.API;
import com.br.devgusta.ticket_master.DTO.ClientRequestDTO;
import com.br.devgusta.ticket_master.DTO.ClientResponseDTO;
import com.br.devgusta.ticket_master.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ticket-master/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientRequestDTO clientDTO) {
        ClientResponseDTO createdClient = clientService.createClient(clientDTO);
        return ResponseEntity.ok(createdClient);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
        List<ClientResponseDTO> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id) {
        ClientResponseDTO client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id,
                                                          @RequestBody ClientRequestDTO clientDTO) {
        ClientResponseDTO updatedClient = clientService.updateClient(id, clientDTO);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}

