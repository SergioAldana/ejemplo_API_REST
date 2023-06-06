package com.backend.ejemplo_api_rest_.repository;

import com.backend.ejemplo_api_rest_.domain.Sense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenseRepository extends JpaRepository<Sense, Long> {

    

}
