package com.backend.ejemplo_api_rest.domain;

import com.backend.ejemplo_api_rest.domain.enumeration.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "sense")
@Data
public class Sense implements Serializable {

    // ¿Verificar con Sonar?
    // Anotación @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(length = 100, nullable = false, unique = true)
    private String type;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    public Sense state(State state) {
        this.state = state;
        return this;
    }
}
