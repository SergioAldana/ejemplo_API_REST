package com.backend.ejemplo_api_rest.repository;

import com.backend.ejemplo_api_rest.domain.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
    
}
