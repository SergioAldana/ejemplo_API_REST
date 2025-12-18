package com.backend.ejemplo_api_rest.domain;

import com.backend.ejemplo_api_rest.domain.enumeration.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "gender")
public class Gender implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id")
    private Long genderId;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gender_identity", length = 50, nullable = false, unique = true)
    private String genderIdentity;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    /**
     * La relación bidireccional es innecesaria.
     */

    public Gender() {
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public String getGenderIdentity() {
        return genderIdentity;
    }

    public void setGenderIdentity(String genderIdentity) {
        this.genderIdentity = genderIdentity;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Gender)) {
            return false;
        }
        Gender gender = (Gender) o;
        return getGenderId() != null && getGenderId().equals(gender.getGenderId());
    }

    @Override
    public int hashCode() {
        return (getGenderId() != null) ? getGenderId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId=" + getGenderId() +
                ", genderIdentity'=" + getGenderIdentity() + "'" +
                ", state'=" + getState() + "'" +
                "}";

    }

}
