package com.br.devgusta.ticket_master.service;
import com.br.devgusta.ticket_master.DTO.ClientRequestDTO;
import com.br.devgusta.ticket_master.DTO.ClientResponseDTO;
import com.br.devgusta.ticket_master.model.Client;
import com.br.devgusta.ticket_master.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientResponseDTO createClient(ClientRequestDTO dto){

        Client client = new Client();
        client.setName(dto.getName());
        client.setClientAd(dto.getClientAd());
        client.setEmail(dto.getEmail());
        client.setDepartment(dto.getDepartment());

        Client savedClient = clientRepository.save(client);
        return new ClientResponseDTO(savedClient);


    }

    public ClientResponseDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id +
                        " .Verifique o id fornecido e tente novamente!"));

        return new ClientResponseDTO(client);
    }

    public List<ClientResponseDTO> getAllClients(){
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientResponseDTO::new)
                .collect(Collectors.toList());

    }

    public ClientResponseDTO updateClient(Long id, ClientRequestDTO dto){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id +
                        " .Verifique o id fornecido e tente novamente!"));
        client.setName(dto.getName());
        client.setClientAd(dto.getClientAd());
        client.setEmail(dto.getEmail());
        client.setDepartment(dto.getDepartment());

        Client updatedClient = clientRepository.save(client);
        return new ClientResponseDTO(updatedClient);
    }

    public void deleteClient(Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id +
                        " .Verifique o id fornecido e tente novamente!"));
        
        clientRepository.delete(client);
    }


}
