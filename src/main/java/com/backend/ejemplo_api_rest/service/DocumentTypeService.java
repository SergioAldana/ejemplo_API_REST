package com.backend.ejemplo_api_rest.service;

import com.backend.ejemplo_api_rest.domain.DocumentType;
import com.backend.ejemplo_api_rest.repository.DocumentTypeRepository;
import com.backend.ejemplo_api_rest.service.dto.DocumentTypeDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentTypeService.class);

    private final DocumentTypeRepository documentTypeRepository;

    /**
     * Registro para el usuario final, validaciones y seguridad.
     */
    public DocumentTypeDTO registerDocumentType(DocumentTypeDTO documentTypeDTO) {
        LOGGER.debug("Información creada para Tipo de Documento: {}", documentTypeDTO);

        /*
         * Conversión desde el DTO ⇾ a la Entidad.
         */
        DocumentType newDocumentType = new DocumentType();

        newDocumentType.setDocumentTypeId(documentTypeDTO.getDocumentTypeId());
        newDocumentType.setAbbreviation(documentTypeDTO.getAbbreviation());
        newDocumentType.setDocumentName(documentTypeDTO.getDocumentName());
        newDocumentType.setState(documentTypeDTO.getState());

        DocumentType savedDocumentType = documentTypeRepository.save(newDocumentType);

        /*
         * Conversión desde la Entidad ⇾ al DTO.
         */
        DocumentTypeDTO newDocumentTypeDTO = new DocumentTypeDTO();

        newDocumentTypeDTO.setDocumentTypeId(savedDocumentType.getDocumentTypeId());
        newDocumentTypeDTO.setAbbreviation(savedDocumentType.getAbbreviation());
        newDocumentTypeDTO.setDocumentName(savedDocumentType.getDocumentName());
        newDocumentTypeDTO.setState(savedDocumentType.getState());

        return newDocumentTypeDTO;
    }

    /**
     * Registro para el administrador, sin validaciones, ni seguridad (opcional).
     * createDocumentType
     */
    
}
