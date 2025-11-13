package com.backend.ejemplo_api_rest.domain;

import com.backend.ejemplo_api_rest.domain.enumeration.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "document_type")
public class DocumentType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_type_id")
    private Long documentTypeId;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(length = 10, nullable = false, unique = true)
    private String abbreviation;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "document_name", length = 50, nullable = false, unique = true)
    private String documentName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    /**
     * La relación bidireccional es innecesaria.
     */

    /*
     * Constructor sin parámetros o sin argumentos.
     * El compilador proporciona este constructor si no se define ninguno.
     */
    public DocumentType() {
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

    //@EqualsAndHashCode

    /*
     * En lugar de acceder directamente a los atributos,
     * se utilizan los métodos getters para garantizar la compatibilidad con Hibernate.
     * Además, usar los getters respeta cualquier lógica adicional que estos puedan contener
     * (transformaciones, validaciones, etc.), asegurando que la salida del método
     * refleje el estado público real del objeto.
     */
    @Override
    public String toString() {
        return "DocumentType{" +
                "documentTypeId=" + getDocumentTypeId() +
                ", abbreviation'=" + getAbbreviation() + "'" +
                ", documentName'=" + getDocumentName() + "'" +
                ", state='" + state + '\'' +
                "}";
    }

}
