package com.gabortodor.petproject.service;

import com.gabortodor.petproject.dto.BaseDTO;
import com.gabortodor.petproject.entity.BaseEntity;
import com.gabortodor.petproject.repository.BaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Abstract base service class providing common operations for entities.
 *
 * @param <E> the type of the entity
 * @param <D> the type of the DTO
 * @param <R> the type of the repository
 */
@Service
public abstract class BaseService<E extends BaseEntity, D extends BaseDTO, R extends BaseRepository<E>> {

    @Autowired
    protected ModelMapper modelMapper;

    protected R repository;

    protected final Class<E> entityClass;
    protected final Class<D> dtoClass;

    protected BaseService(Class<E> entityClass, Class<D> dtoClass, R repository) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.repository = repository;
    }

    /**
     * Finds all DTOs.
     *
     * @return a list of all DTOs
     */
    public List<D> findAll() {
        return convertToDTOList(findAllEntities());
    }

    /**
     * Finds all entities.
     *
     * @return a list of all entities
     */
    protected List<E> findAllEntities() {
        return repository.findAll();
    }

    /**
     * Finds a DTO by its {@link UUID}.
     *
     * @param uuid the {@link UUID} of the DTO
     * @return an optional containing the DTO if found, otherwise empty
     */
    public Optional<D> findById(UUID uuid) {
        return findEntityById(uuid).map(this::convertToDTO);
    }

    /**
     * Finds an entity by its {@link UUID}.
     *
     * @param uuid the {@link UUID} of the entity
     * @return an optional containing the entity if found, otherwise empty
     */
    protected Optional<E> findEntityById(UUID uuid) {
        return repository.findById(uuid);
    }

    /**
     * Saves a DTO.
     *
     * @param dto the DTO to save
     * @return the saved DTO
     */
    public D save(D dto) {
        return convertToDTO(saveEntity(convertToEntity(dto)));
    }

    /**
     * Saves an entity.
     *
     * @param entity the entity to save
     * @return the saved entity
     */
    protected E saveEntity(E entity) {
        return repository.save(entity);
    }

    /**
     * Saves a list of DTOs.
     *
     * @param dtoList the list of DTOs to save
     * @return the list of saved DTOs
     */
    public List<D> saveAll(List<D> dtoList) {
        return convertToDTOList(saveAllEntities(convertToEntityList(dtoList)));
    }

    /**
     * Saves a list of entities.
     *
     * @param entityList the list of entities to save
     * @return the list of saved entities
     */
    protected List<E> saveAllEntities(List<E> entityList) {
        return repository.saveAll(entityList);
    }

    /**
     * Updates a DTO by its {@link UUID}.
     *
     * @param uuid the {@link UUID} of the DTO to update
     * @param dto  the new DTO data
     * @return the updated DTO
     */
    public D update(UUID uuid, D dto) {
        return convertToDTO(updateEntity(uuid, convertToEntity(dto)));
    }

    /**
     * Updates an entity by its {@link UUID}.
     *
     * @param uuid   the {@link UUID} of the entity to update
     * @param entity the new entity data
     * @return the updated entity
     */
    protected E updateEntity(UUID uuid, E entity) {
        entity.setId(uuid);
        return saveEntity(entity);
    }

    /**
     * Deletes an entity by its {@link UUID}.
     *
     * @param uuid the {@link UUID} of the entity to delete
     */
    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    /**
     * Converts a list of DTOs to a list of entities.
     *
     * @param dtoList the list of DTOs to convert
     * @return the list of converted entities
     */
    protected List<E> convertToEntityList(List<D> dtoList) {
        return dtoList.stream().map(this::convertToEntity).toList();
    }

    /**
     * Converts a list of entities to a list of DTOs.
     *
     * @param entityList the list of entities to convert
     * @return the list of converted DTOs
     */
    protected List<D> convertToDTOList(List<E> entityList) {
        return entityList.stream().map(this::convertToDTO).toList();
    }

    /**
     * Converts a DTO to an entity.
     *
     * @param dto the DTO to convert
     * @return the converted entity
     */
    protected E convertToEntity(D dto) {
        return modelMapper.map(dto, entityClass);
    }

    /**
     * Converts an entity to a DTO.
     *
     * @param entity the entity to convert
     * @return the converted DTO
     */
    protected D convertToDTO(E entity) {
        return modelMapper.map(entity, dtoClass);
    }
}
