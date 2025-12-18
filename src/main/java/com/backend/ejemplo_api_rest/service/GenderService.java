package com.backend.ejemplo_api_rest.service;

import com.backend.ejemplo_api_rest.domain.Gender;
import com.backend.ejemplo_api_rest.repository.GenderRepository;
import com.backend.ejemplo_api_rest.service.dto.GenderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GenderService {

    private static final Logger LOG = LoggerFactory.getLogger(GenderService.class);

    private final GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    /**
     * Registro para el usuario final, validaciones y seguridad.
     */
    public GenderDTO registerGender(GenderDTO genderDTO) {
        LOG.debug("Información creada para GenderDTO: {}", genderDTO);
        Gender newGender = mapToEntity(genderDTO);
        Gender savedGender = genderRepository.save(newGender);
        return mapToDTO(savedGender);
    }

    private Gender mapToEntity(GenderDTO DTO) {
        /*
         * Conversión desde el DTO ⇾ a la Entidad.
         */
        Gender entity = new Gender();
        entity.setGenderId(DTO.getGenderId());
        entity.setGenderIdentity(DTO.getGenderIdentity());
        entity.setState(DTO.getState());
        return entity;
    }

    private GenderDTO mapToDTO(Gender entity) {
        /*
         * Conversión desde la Entidad ⇾ al DTO.
         */
        GenderDTO DTO = new GenderDTO();
        DTO.setGenderId(entity.getGenderId());
        DTO.setGenderIdentity(entity.getGenderIdentity());
        DTO.setState(entity.getState());
        return DTO;
    }

}
