package com.backend.ejemplo_api_rest.service.dto;

import com.backend.ejemplo_api_rest.domain.enumeration.State;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class DocumentTypeDTO implements Serializable {

    /*
     * En Java, cuando una clase implementa Serializable,
     * es recomendable declarar manualmente un serialVersionUID.
     * Buena práctica defensiva.
     */
    private static final long serialVersionUID = 1L;

    private Long documentTypeId;

    @NotNull
    @Size(min = 1, max = 10)
    private String abbreviation;

    @NotNull
    @Size(min = 1, max = 50)
    private String documentName;

    @NotNull
    private State state;

    public DocumentTypeDTO() {
    }

    public Long getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "documentTypeId=" + getDocumentTypeId() +
                ", abbreviation'=" + getAbbreviation() + "'" +
                ", documentName'=" + getDocumentName() + "'" +
                ", state='" + getState() + "'" +
                "}";
    }

}
