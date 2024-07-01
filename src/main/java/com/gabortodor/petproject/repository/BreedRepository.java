package com.gabortodor.petproject.repository;

import com.gabortodor.petproject.entity.Breed;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Breed} entities.
 * Provides CRUD operations and additional query methods.
 */
@Repository
public interface BreedRepository extends BaseRepository<Breed> {
}
