package com.backend.ejemplo_api_rest.domain;

import com.backend.ejemplo_api_rest.domain.enumeration.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "document_type")
@Data
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

    public DocumentType abbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
        return this;
    }

    public DocumentType documentName(String documentName) {
        this.documentName = documentName;
        return this;
    }

    public DocumentType state(State state) {
        this.state = state;
        return this;
    }

}
