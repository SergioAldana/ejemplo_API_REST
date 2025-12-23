package com.backend.ejemplo_api_rest.service;

import com.backend.ejemplo_api_rest.domain.Gender;
import com.backend.ejemplo_api_rest.repository.GenderRepository;
import com.backend.ejemplo_api_rest.service.dto.GenderDTO;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderService {

    private static final Logger LOG = LoggerFactory.getLogger(GenderService.class);

    private final GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    /**
     * Registro para el usuario final, validaciones y seguridad.
     * El método principal de la funcionalidad es el responsable de orquestar
     * el flujo completo.
     */
    public GenderDTO registerGender(GenderDTO genderDTO) {
        /*
         * Opción 1:
         * Creación de una nueva instancia en el método principal.
         * Luego, envío del DTO y la instancia al método applyDTOToEntity.
         */
        Gender newGender = new Gender();
        applyDTOToEntity(genderDTO, newGender);
        /*
         * Opción 2:
         * Envío del DTO al método mapToEntity
         * Gender newGender = mapToEntity(genderDTO);
         */

        Gender savedGender = genderRepository.save(newGender);
        GenderDTO newGenderDTO = mapToDTO(savedGender);
        LOG.debug("Información de Género creada: {}", newGenderDTO);
        return newGenderDTO;
    }

    /**
     * Registro para el administrador, sin validaciones, ni seguridad (opcional).
     * createGender
     */

    public GenderDTO updateGender(Long id, GenderDTO genderDTO) {
        // El ID proviene directamente de la URL, no del ID del DTO.
        Gender existingGender = genderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra el Género con ID: " + id));
        applyDTOToEntity(genderDTO, existingGender);
        Gender updatedGender = genderRepository.save(existingGender);
        GenderDTO updatedGenderDTO = mapToDTO(updatedGender);
        LOG.debug("Información de Género actualizada, con ID {}: {}", id, updatedGenderDTO);
        return updatedGenderDTO;
    }

    public List<GenderDTO> getAllGenders() {
        List<Gender> genders = genderRepository.findAll();
        List<GenderDTO> genderDTOs = new ArrayList<>();
        for (int i = 0; i < genders.size(); i++) {
            /*
             * Obtiene el objeto de la posición en la que se encuentre el índice "i" de la lista de Géneros
             * y lo almacena en la variable gender.
             */
            Gender gender = genders.get(i);
            GenderDTO genderDTO = mapToDTO(gender);
            genderDTOs.add(genderDTO);
        }
        return genderDTOs;
    }

    /*
     * Conversión desde el DTO ⇾ a la Entidad.
     * Agregar el ID al método generaría problemas de:
     * Control del dominio
     * Seguridad
     * Trazabilidad
     * Una única responsabilidad; applyDTOToEntity SOLO transcribe datos.
     */
    private void applyDTOToEntity(GenderDTO DTO, Gender entity) {
        entity.setGenderIdentity(DTO.getGenderIdentity());
        entity.setState(DTO.getState());
    }
    /*
     * Opción 2:
     * mapToEntity crea una nueva instancia, transcribe los datos provenientes
     * y retorna la instancia creada.
     *
     * private Gender mapToEntity(GenderDTO DTO) {
     *     Gender entity = new Gender();
     *     entity.setGenderIdentity(DTO.getGenderIdentity());
     *     entity.setState(DTO.getState());
     *     return entity;
     * }
     */

    /*
     * Conversión desde la Entidad ⇾ al DTO.
     */
    private GenderDTO mapToDTO(Gender entity) {
        GenderDTO DTO = new GenderDTO();
        DTO.setGenderId(entity.getGenderId());
        DTO.setGenderIdentity(entity.getGenderIdentity());
        DTO.setState(entity.getState());
        return DTO;
    }

}
