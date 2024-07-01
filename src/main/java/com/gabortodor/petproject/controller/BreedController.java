package com.gabortodor.petproject.controller;

import com.gabortodor.petproject.dto.BreedDTO;
import com.gabortodor.petproject.entity.Breed;
import com.gabortodor.petproject.repository.BreedRepository;
import com.gabortodor.petproject.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing Breed entities via REST API endpoints.
 */
@RestController
@RequestMapping("/api/v1/breed")
public class BreedController extends BaseController<Breed, BreedDTO, BreedRepository, BreedService> {

    @Autowired
    public BreedController(BreedService service) {
        super(Breed.class, BreedDTO.class, service);
    }
}
