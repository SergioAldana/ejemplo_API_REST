package com.backend.ejemplo_api_rest.service.dto;

import com.backend.ejemplo_api_rest.domain.DocumentType;
import com.backend.ejemplo_api_rest.domain.enumeration.State;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DocumentTypeDTO implements Serializable {

    private Long documentTypeId;

    @NotNull
    @Size(min = 1, max = 10)
    private String abbreviation;

    @NotNull
    @Size(min = 1, max = 50)
    private String documentName;

    @NotNull
    private State state;

}
