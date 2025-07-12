package com.br.devgusta.ticket_master.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "analysts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Analyst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analyst_id")
    private Long id;

    @Column(name = "analyst_name")
    private String analystName;

    @Column(name = "analyst_email")
    private String email;

    private String specialty;

    @OneToMany(mappedBy = "analyst", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();



}
