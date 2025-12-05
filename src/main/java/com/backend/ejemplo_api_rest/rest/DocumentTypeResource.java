package com.backend.ejemplo_api_rest.rest;

import com.backend.ejemplo_api_rest.service.DocumentTypeService;
import com.backend.ejemplo_api_rest.service.dto.DocumentTypeDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document-types")
public class DocumentTypeResource {

    private static final Logger LOG = LoggerFactory.getLogger(DocumentTypeResource.class);

    private final DocumentTypeService documentTypeService;

    public DocumentTypeResource(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @PostMapping("")
    public ResponseEntity<DocumentTypeDTO> createDocumentType(@Valid @RequestBody DocumentTypeDTO documentTypeDTO) {
        LOG.debug("Solicitud REST para guardar un Tipo de Documento: {}", documentTypeDTO);

        DocumentTypeDTO newDocumentTypeDTO = documentTypeService.registerDocumentType(documentTypeDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newDocumentTypeDTO);
    }

}
