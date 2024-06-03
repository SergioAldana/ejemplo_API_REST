package com.backend.ejemplo_api_rest.service;

import com.backend.ejemplo_api_rest.domain.Sense;
import com.backend.ejemplo_api_rest.repository.SenseRepository;
import com.backend.ejemplo_api_rest.service.dto.SenseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SenseService {

    private final SenseRepository senseRepository;

    // private final SenseDTO senseDTO;


    /*
     * @Transactional
     * Transferencia de datos en grupo
     * Por ejemplo para el método findAllSenses serviría
     */
    /*
    public Sense saveSense(SenseDTO senseDTO) {
        Sense sense = new Sense();

        sense.setId(senseDTO.getId());
        sense.setType(senseDTO.getType());
        sense.setState(senseDTO.getState());

        return senseRepository.save(sense);
    }
     */


    /*
    Este metodo creo que esta retornando un valor vacio
     */

    public List<SenseDTO> findAllSenses() {
        List<Sense> senses = senseRepository.findAll();
        List<SenseDTO> sensesDTO = new ArrayList<>();

        for (int i = 0; i < senses.size(); i++) {
            /**
             * Obtenemos el objeto Sense en la posición i
             */
            Sense sense = senses.get(i);

            SenseDTO senseDTO = new SenseDTO();

            senseDTO.setId(sense.getId());
            senseDTO.setType(sense.getType());
            senseDTO.setState(sense.getState());
            sensesDTO.add(senseDTO);
        }
        return sensesDTO;
    }

    /*
    public SenseDTO findById(Long id) {
        Sense sense = senseRepository.findById(id).orElse(null);

        senseDTO.setId(sense.getId());
        return senseDTO;
    }

    public void deleteById(Long id) {
        senseRepository.deleteById(id);
    }

     */
}
