package com.br.devgusta.ticket_master.service;
import com.br.devgusta.ticket_master.DTO.AnalystRequestDTO;
import com.br.devgusta.ticket_master.DTO.AnalystResponseDTO;
import com.br.devgusta.ticket_master.model.Analyst;
import com.br.devgusta.ticket_master.repository.AnalystRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnalystService {

    @Autowired
    AnalystRepository analystRepository;

    public AnalystResponseDTO createAnalyst(AnalystRequestDTO dto){

        Analyst analyst = new Analyst();
        analyst.setAnalystName(dto.getAnalystName());
        analyst.setEmail(dto.getEmail());
        analyst.setSpecialty(dto.getSpecialty());

        Analyst savedAnalyst = analystRepository.save(analyst);

        return new AnalystResponseDTO(savedAnalyst);
    }


    public AnalystResponseDTO getAnalystById(Long id){
        Analyst analyst = analystRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o analista com o id " + id +
                        " .Verifique o id fornecido e tente novamente!"));
        return new AnalystResponseDTO(analyst);
    }

    public List<AnalystResponseDTO> getAllAnalysts(){
        List<Analyst> analysts = analystRepository.findAll();
        return analysts.stream()
                .map(AnalystResponseDTO::new)
                .collect(Collectors.toList());

    }

    public AnalystResponseDTO uptadeAnalyst(Long id, AnalystRequestDTO dto){
        Analyst analyst = analystRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o analista com o id " + id +
                        " .Verifique o id fornecido e tente novamente!"));
        analyst.setAnalystName(dto.getAnalystName());
        analyst.setEmail(dto.getEmail());
        analyst.setSpecialty(dto.getSpecialty());

        Analyst  updatedAnalyst = analystRepository.save(analyst);
        return new AnalystResponseDTO(updatedAnalyst);

    }

    public void deleteAnalyst(Long id){
        Analyst analyst = analystRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o analista com o id " + id +
                        " .Verifique o id fornecido e tente novamente!"));
        analystRepository.delete(analyst);
    }
}
