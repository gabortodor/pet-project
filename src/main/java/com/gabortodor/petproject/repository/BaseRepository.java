package com.gabortodor.petproject.repository;

import com.gabortodor.petproject.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Base repository interface for entities extending {@link BaseEntity}.
 * Provides basic CRUD operations and specification executor functionality.
 *
 * @param <E> the type of the entity
 */
@Repository
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, UUID>, JpaSpecificationExecutor<E> {
}
