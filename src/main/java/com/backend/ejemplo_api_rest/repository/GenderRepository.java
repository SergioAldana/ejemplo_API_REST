package com.backend.ejemplo_api_rest.repository;

import com.backend.ejemplo_api_rest.domain.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
}
