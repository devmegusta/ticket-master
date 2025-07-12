package com.br.devgusta.ticket_master.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalystRequestDTO {
    private String analystName;
    private String email;
    private String specialty;

}
