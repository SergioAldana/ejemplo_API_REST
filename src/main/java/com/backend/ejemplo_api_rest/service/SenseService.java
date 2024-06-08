package com.backend.ejemplo_api_rest.service;

import com.backend.ejemplo_api_rest.domain.Sense;
import com.backend.ejemplo_api_rest.repository.SenseRepository;
import com.backend.ejemplo_api_rest.service.dto.SenseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SenseService {

    private static final Logger logger = LoggerFactory.getLogger(SenseService.class);
    private final SenseRepository senseRepository;

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

    public List<SenseDTO> findAllSenses() /*throws Exception*/ {
        try {
            List<Sense> senses = senseRepository.findAll();
            List<SenseDTO> sensesDTO = new ArrayList<>();

            for (int i = 0; i < senses.size(); i++) {
                // Obtenemos el objeto Sense en la posición i
                Sense sense = senses.get(i);

                SenseDTO senseDTO = new SenseDTO();

                senseDTO.setId(sense.getId());
                senseDTO.setType(sense.getType());
                senseDTO.setState(sense.getState());
                sensesDTO.add(senseDTO);
            }
            return sensesDTO;
        } catch (Exception e) {
            logger.error(e.getMessage());
            // Puedes lanzar una excepción personalizada si es necesario
            //throw new CustomException("Error retrieving senses", e);
            // ¿esto iria en el controlador? NO, PARECIDOS SOLAMENTE
            // Joas Dev
            // throw new ApiException("Error in query", HttpStatus.NOT_FOUND);
            return new ArrayList<>();
        }
    }

    /*
    public SenseDTO findById(Long id) {
        Sense sense = senseRepository.findById(id).orElse(null);
        SenseDTO senseDTO = new SenseDTO();

        senseDTO.setId(sense.getId());
        return senseDTO;
    }
    */

    /*

    public void deleteById(Long id) {
        senseRepository.deleteById(id);
    }

     */
}
