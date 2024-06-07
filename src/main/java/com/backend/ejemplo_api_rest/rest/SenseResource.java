package com.backend.ejemplo_api_rest.rest;

import com.backend.ejemplo_api_rest.service.SenseService;
import com.backend.ejemplo_api_rest.service.dto.SenseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class SenseResource {

    private static final String ENTITY_NAME = "sense";

    private final SenseService senseService;

    /*
    @PostMapping("/sense")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SenseDTO> createSense(@Valid @RequestBody SenseDTO senseDTO) throws URISyntaxException {
        if (senseDTO.getId() != null) {
            throw new BadRequestAlertException("A new sense cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SenseDTO result = senseService.saveSense(senseDTO);
        return ResponseEntity.created(new URI("/api/sense/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

     */

    @GetMapping("/sense")
    public List<SenseDTO> getAllSenses() {
        return senseService.findAllSenses();
    }


    /*
    @GetMapping("/sense/{id}")
    public ResponseEntity<SenseDTO> getSense(@PathVariable Long id) {
        SenseDTO senseDTO = senseService.findById(id);
        return ResponseUtil.wrapOrNotFound(senseDTO);
    }

    @DeleteMapping("/sense/{id}")
    public ResponseEntity<Void> deleteSense(@PathVariable Long id) {
        senseService.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

     */




}
