package com.backend.ejemplo_api_rest.service;

import com.backend.ejemplo_api_rest.domain.Sense;
import com.backend.ejemplo_api_rest.repository.SenseRepository;
import com.backend.ejemplo_api_rest.service.dto.SenseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Service
public class SenseService {

    // private final Logger log = LoggerFactory

    private final SenseRepository senseRepository;

    private final SenseDTO senseDTO;


    public Sense saveSense(SenseDTO senseDTO) {
        Sense sense = new Sense();

        sense.setId(senseDTO.getId());
        sense.setType(senseDTO.getType());
        sense.setState(senseDTO.getState());

        return senseRepository.save(sense);
    }

    public List<SenseDTO> findAllSenses() {
        List<Sense> senses = senseRepository.findAll();
        List<SenseDTO> sensesDTO = new ArrayList<>();

        for (Sense sense : senses) {
            senseDTO.setId(sense.getId());
            senseDTO.setType(sense.getType());
            senseDTO.setState(sense.getState());
        }
        return sensesDTO;
    }

    public SenseDTO findById(Long id) {
        Sense sense = senseRepository.findById(id).orElse(null);

        senseDTO.setId(sense.getId());
        return senseDTO;
    }

    public void deleteById(Long id) {
        senseRepository.deleteById(id);
    }
}
