package com.gabortodor.petproject.controller;

import com.gabortodor.petproject.dto.BaseDTO;
import com.gabortodor.petproject.entity.BaseEntity;
import com.gabortodor.petproject.exception.ResourceNotFoundException;
import com.gabortodor.petproject.repository.BaseRepository;
import com.gabortodor.petproject.service.BaseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Abstract base controller class providing REST API endpoints for basic CRUD operations on entities.
 *
 * @param <E> the type of the entity
 * @param <D> the type of the DTO
 * @param <R> the type of the repository
 * @param <S> the type of the service
 */
@RestController
public abstract class BaseController<E extends BaseEntity, D extends BaseDTO, R extends BaseRepository<E>, S extends BaseService<E, D, R>> {

    protected final S service;

    private final Class<E> entityClass;
    private final Class<D> dtoClass;


    public BaseController(Class<E> entityClass, Class<D> dtoClass, S service) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.service = service;
    }

    /**
     * Finds an entity by its {@link UUID}.
     *
     * @param uuid the {@link UUID} of the entity to find
     * @return the found DTO
     * @throws ResourceNotFoundException if the entity with the given {@link UUID} is not found
     */
    @GetMapping("/{uuid}")
    public D findById(@PathVariable UUID uuid) {
        return service.findById(uuid).orElseThrow(() -> new ResourceNotFoundException(entityClass, "id", uuid.toString()));
    }

    /**
     * Finds all entities.
     *
     * @return a list of all DTOs
     */
    @GetMapping
    public List<D> findAll() {
        return service.findAll();
    }

    /**
     * Saves an entity.
     *
     * @param dto the DTO to save
     * @return the saved DTO
     */
    @PostMapping
    public D save(@RequestBody @Valid D dto) {
        return service.save(dto);
    }

    /**
     * Updates an entity by its {@link UUID}.
     *
     * @param uuid the {@link UUID} of the entity to update
     * @param dto  the updated DTO data
     * @return the updated DTO
     */
    @PutMapping("/{uuid}")
    public D update(@PathVariable UUID uuid, @RequestBody @Valid D dto) {
        return service.update(uuid, dto);
    }

    /**
     * Deletes an entity by its {@link UUID}.
     *
     * @param uuid the {@link UUID} of the entity to delete
     */
    @DeleteMapping("/{uuid}")
    public void deleteById(@PathVariable UUID uuid) {
        service.deleteById(uuid);
    }
}
