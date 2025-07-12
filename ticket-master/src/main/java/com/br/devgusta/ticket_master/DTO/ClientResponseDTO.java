package com.br.devgusta.ticket_master.DTO;
import com.br.devgusta.ticket_master.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String department;

    public ClientResponseDTO(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.department = client.getDepartment();
    }

}
