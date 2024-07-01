package com.gabortodor.petproject.repository;

import com.gabortodor.petproject.entity.Animal;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Animal} entities.
 * Provides CRUD operations and additional query methods.
 */
@Repository
public interface AnimalRepository extends BaseRepository<Animal> {
}
