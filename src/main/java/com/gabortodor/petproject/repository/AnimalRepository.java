package com.gabortodor.petproject.repository;

import com.gabortodor.petproject.entity.Animal;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends BaseRepository<Animal> {
}
