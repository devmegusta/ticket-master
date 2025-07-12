package com.br.devgusta.ticket_master.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequestDTO {

    private String ticketTitle;

    private String ticketBody;

    private String level;

    private String ticketStatus;

    private LocalDateTime localDateTime;

    private Long clientId;

    private Long analystId;


}
