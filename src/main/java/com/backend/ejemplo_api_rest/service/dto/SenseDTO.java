package com.backend.ejemplo_api_rest.service.dto;

import com.backend.ejemplo_api_rest.domain.enumeration.State;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class SenseDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String type;

    @NotNull
    private State state;
}
