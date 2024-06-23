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

    public List<D> findAll() {
        return convertToDTOList(findAllEntities());
    }

    protected List<E> findAllEntities() {
        return repository.findAll();
    }

    public Optional<D> findById(UUID uuid) {
        return findEntityById(uuid).map(this::convertToDTO);
    }

    protected Optional<E> findEntityById(UUID uuid) {
        return repository.findById(uuid);
    }

    public D save(D dto) {
        return convertToDTO(saveEntity(convertToEntity(dto)));
    }

    protected E saveEntity(E entity) {
        return repository.save(entity);
    }

    public List<D> saveAll(List<D> dtoList) {
        return convertToDTOList(saveAllEntities(convertToEntityList(dtoList)));
    }

    protected List<E> saveAllEntities(List<E> entityList) {
        return repository.saveAll(entityList);
    }

    public D update(UUID uuid, D dto) {
        return convertToDTO(updateEntity(uuid, convertToEntity(dto)));
    }

    protected E updateEntity(UUID uuid, E entity) {
        entity.setId(uuid);
        return saveEntity(entity);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    protected List<E> convertToEntityList(List<D> dtoList) {
        return dtoList.stream().map(this::convertToEntity).toList();
    }

    protected List<D> convertToDTOList(List<E> entityList) {
        return entityList.stream().map(this::convertToDTO).toList();
    }

    protected E convertToEntity(D dto) {
        return modelMapper.map(dto, entityClass);
    }

    protected D convertToDTO(E entity) {
        return modelMapper.map(entity, dtoClass);
    }
}
