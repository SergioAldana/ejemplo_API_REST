package com.backend.ejemplo_api_rest.service.dto;

import com.backend.ejemplo_api_rest.domain.enumeration.State;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class GenderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long genderId;

    @NotNull
    @Size(min = 1, max = 50)
    private String genderIdentity;

    @NotNull
    private State state;

    public GenderDTO() {
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
    public String toString() {
        return "GenderDTO{" +
                "genderId=" + getGenderId() +
                ", genderIdentity'=" + getGenderIdentity() + "'" +
                ", state='" + getState() + "'" +
                "}";
    }

}
