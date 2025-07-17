package com.br.devgusta.ticket_master.controller;

import com.br.devgusta.ticket_master.DTO.AnalystRequestDTO;
import com.br.devgusta.ticket_master.DTO.AnalystResponseDTO;
import com.br.devgusta.ticket_master.DTO.ClientResponseDTO;
import com.br.devgusta.ticket_master.service.AnalystService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket-master/analysts")
public class AnalystController {

    @Autowired
    AnalystService analystService;

    @PostMapping
    public ResponseEntity<AnalystResponseDTO> createAnalyst(@RequestBody AnalystRequestDTO analystDTO){
        AnalystResponseDTO createdAnalyst = analystService.createAnalyst(analystDTO);
        return ResponseEntity.ok(createdAnalyst);

    }
    @GetMapping
    public ResponseEntity<List<AnalystResponseDTO>> getAllAnalysts(){
        List<AnalystResponseDTO> analysts = analystService.getAllAnalysts();
        return ResponseEntity.ok(analysts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalystResponseDTO> getAnalystById(@PathVariable Long id){
        AnalystResponseDTO analyst = analystService.getAnalystById(id);
        return ResponseEntity.ok(analyst);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnalystResponseDTO> updateAnalyst(@PathVariable Long id,
                                                            @RequestBody AnalystRequestDTO analystDTO){
        AnalystResponseDTO updatedAnalyst = analystService.uptadeAnalyst(id, analystDTO);
        return ResponseEntity.ok(updatedAnalyst);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalyst(@PathVariable Long id){
        analystService.deleteAnalyst(id);
        return ResponseEntity.noContent().build();
    }

}
