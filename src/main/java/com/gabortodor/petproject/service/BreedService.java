package com.gabortodor.petproject.service;

import com.gabortodor.petproject.dto.BreedDTO;
import com.gabortodor.petproject.entity.Breed;
import com.gabortodor.petproject.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreedService extends BaseService<Breed, BreedDTO, BreedRepository> {

    @Autowired
    public BreedService(BreedRepository repository) {
        super(Breed.class, BreedDTO.class, repository);
    }
}
