package com.gabortodor.petproject.controller;

import com.gabortodor.petproject.dto.AnimalDTO;
import com.gabortodor.petproject.entity.Animal;
import com.gabortodor.petproject.repository.AnimalRepository;
import com.gabortodor.petproject.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/animal")
public class AnimalController extends BaseControllerWithLocalFile<Animal, AnimalDTO, AnimalRepository, AnimalService> {

    @Autowired
    public AnimalController(AnimalService service) {
        super(Animal.class, AnimalDTO.class, service);
    }
}
