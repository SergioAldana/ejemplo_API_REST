package com.backend.ejemplo_API_REST.domain;

import com.backend.ejemplo_API_REST.domain.enumeration.State;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "sense")
public class Sense implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private State state;

}
