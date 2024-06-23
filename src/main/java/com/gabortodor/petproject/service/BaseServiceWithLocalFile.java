package com.gabortodor.petproject.service;

import com.gabortodor.petproject.dto.BaseDTO;
import com.gabortodor.petproject.entity.BaseEntityWithLocalFile;
import com.gabortodor.petproject.entity.LocalFile;
import com.gabortodor.petproject.exception.ResourceNotFoundException;
import com.gabortodor.petproject.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public abstract class BaseServiceWithLocalFile<E extends BaseEntityWithLocalFile, D extends BaseDTO, R extends BaseRepository<E>> extends BaseService<E, D, R> {

    @Autowired
    protected LocalFileService localFileService;

    protected BaseServiceWithLocalFile(Class<E> entityClass, Class<D> dtoClass, R repository) {
        super(entityClass, dtoClass, repository);
    }

    public D uploadFileToEntity(MultipartFile multipartFile, Boolean featured, UUID uuid) {
        E entity = super.findEntityById(uuid).orElseThrow(() -> new ResourceNotFoundException(super.entityClass, "id", uuid.toString()));
        LocalFile localFile = localFileService.uploadLocalFile(multipartFile);
        if (featured) {
            entity.setFeaturedLocalFile(localFile);
        } else {
            entity.getLocalFiles().add(localFile);
        }
        return convertToDTO(saveEntity(entity));
    }


}
