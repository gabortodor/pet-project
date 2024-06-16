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

    @GetMapping("/{uuid}")
    public D findById(@PathVariable UUID uuid) {
        return service.findById(uuid).orElseThrow(() -> new ResourceNotFoundException(entityClass, "id", uuid.toString()));
    }

    @GetMapping
    public List<D> findAll() {
        return service.findAll();
    }

    @PostMapping
    public D save(@RequestBody @Valid D dto) {
        return service.save(dto);
    }

    @PutMapping("/{uuid}")
    public D update(@PathVariable UUID uuid, @RequestBody @Valid D dto) {
        return service.update(uuid, dto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteById(@PathVariable UUID uuid) {
        service.deleteById(uuid);
    }
}
