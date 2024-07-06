package com.gabortodor.petproject.service;

import com.gabortodor.petproject.dto.AnimalDTO;
import com.gabortodor.petproject.entity.Animal;
import com.gabortodor.petproject.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing {@link Animal} entities.
 */
@Service
public class AnimalService extends BaseServiceWithLocalFile<Animal, AnimalDTO, AnimalRepository>{

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        super(Animal.class, AnimalDTO.class, animalRepository);
    }

}
