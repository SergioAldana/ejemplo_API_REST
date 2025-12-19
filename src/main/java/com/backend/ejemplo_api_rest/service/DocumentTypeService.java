package com.backend.ejemplo_api_rest.service;

import com.backend.ejemplo_api_rest.domain.DocumentType;
import com.backend.ejemplo_api_rest.repository.DocumentTypeRepository;
import com.backend.ejemplo_api_rest.service.dto.DocumentTypeDTO;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentTypeService {

    private static final Logger LOG = LoggerFactory.getLogger(DocumentTypeService.class);

    private final DocumentTypeRepository documentTypeRepository;

    public DocumentTypeService(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    /**
     * Registro para el usuario final, validaciones y seguridad.
     */
    public DocumentTypeDTO registerDocumentType(DocumentTypeDTO documentTypeDTO) {
        LOG.debug("Información creada para DocumentTypeDTO: {}", documentTypeDTO);

        /*
         * Conversión desde el DTO ⇾ a la Entidad.
         */
        DocumentType newDocumentType = new DocumentType();
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

    public DocumentTypeDTO updateDocumentType(Long id, DocumentTypeDTO documentTypeDTO) {
        LOG.debug("ID: {}\n" + "Información actualizada para Tipo de Documento: {}", id, documentTypeDTO);

        // El ID proviene directamente de la URL, no del ID del DTO.

        if (documentTypeDTO.getDocumentTypeId() != null && !documentTypeDTO.getDocumentTypeId().equals(id)) {
            throw new IllegalArgumentException("El ID del DTO no coincide con el ID de la URL");
        }

        /*
         * Conversión desde el DTO ⇾ a la Entidad.
         *
         * Si no encuentra un Tipo de Documento con ese ID, se lanza una excepción.
         * Si sí se encuentra, devuelve la entidad y la guarda en existingDocumentType.
         */
        DocumentType existingDocumentType = documentTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra el Tipo de Documento con ID: " + id));

        existingDocumentType.setAbbreviation(documentTypeDTO.getAbbreviation());
        existingDocumentType.setDocumentName(documentTypeDTO.getDocumentName());
        existingDocumentType.setState(documentTypeDTO.getState());

        DocumentType updatedDocumentType = documentTypeRepository.save(existingDocumentType);

        /*
         * Conversión desde la Entidad ⇾ al DTO.
         */
        DocumentTypeDTO updatedDocumentTypeDTO = new DocumentTypeDTO();

        updatedDocumentTypeDTO.setDocumentTypeId(updatedDocumentType.getDocumentTypeId());
        updatedDocumentTypeDTO.setAbbreviation(updatedDocumentType.getAbbreviation());
        updatedDocumentTypeDTO.setDocumentName(updatedDocumentType.getDocumentName());
        updatedDocumentTypeDTO.setState(updatedDocumentType.getState());

        return updatedDocumentTypeDTO;
    }

    public List<DocumentTypeDTO> getAllDocumentTypes() {
        List<DocumentType> documentTypes = documentTypeRepository.findAll();
        // Creación de una lista vacía para almacenar los DTO.
        List<DocumentTypeDTO> documentTypeDTOs = new ArrayList<>();

        for (int i = 0; i < documentTypes.size(); i++) {
            /*
             * Se delimitan los valores de cada objeto de Tipo de Documento de acuerdo
             * a la posición del índice "i".
             */
            DocumentType documentType = documentTypes.get(i);
            DocumentTypeDTO documentTypeDTO = new DocumentTypeDTO();

            // Se copian los datos desde la entidad ⇾ al DTO, uno por uno.
            documentTypeDTO.setDocumentTypeId(documentType.getDocumentTypeId());
            documentTypeDTO.setAbbreviation(documentType.getAbbreviation());
            documentTypeDTO.setDocumentName(documentType.getDocumentName());
            documentTypeDTO.setState(documentType.getState());

            documentTypeDTOs.add(documentTypeDTO);
        }

        return documentTypeDTOs;
    }

    public DocumentTypeDTO getDocumentTypeById(Long id) {
        DocumentType documentType = documentTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encuentra el Tipo de Documento con ID: " + id));

        DocumentTypeDTO documentTypeDTO = new DocumentTypeDTO();

        documentTypeDTO.setDocumentTypeId(documentType.getDocumentTypeId());
        documentTypeDTO.setAbbreviation(documentType.getAbbreviation());
        documentTypeDTO.setDocumentName(documentType.getDocumentName());
        documentTypeDTO.setState(documentType.getState());

        return documentTypeDTO;
    }

    public void deleteDocumentType(Long id) {
        /*
         * La verificación del ID difiere al del método updateDocumentType(findById),
         * ya que deleteDocumentType(deleteById) devuelve un void y no un Optional.
         */
        if (!documentTypeRepository.existsById(id)) {
            throw new EntityNotFoundException("No se encuentra el Tipo de Documento con ID: " + id);
        }
        documentTypeRepository.deleteById(id);
        LOG.debug("Tipo de Documento eliminado: {}", id);
    }

}
