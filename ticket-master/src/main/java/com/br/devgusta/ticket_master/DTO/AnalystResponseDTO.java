package com.br.devgusta.ticket_master.DTO;

import com.br.devgusta.ticket_master.model.Analyst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalystResponseDTO {

    private Long id;
    private String analystName;
    private String email;
    private String specialty;

    public AnalystResponseDTO(Analyst analyst){
        this.id = analyst.getId();
        this.analystName = analyst.getAnalystName();
        this.email  = analyst.getEmail();
        this.specialty = analyst.getSpecialty();
    }

}
