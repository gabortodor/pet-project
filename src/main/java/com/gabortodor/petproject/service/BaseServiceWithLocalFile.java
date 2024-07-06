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

/**
 * Abstract base service class providing file upload functionality for entities with local files.
 *
 * @param <E> the type of the entity
 * @param <D> the type of the DTO
 * @param <R> the type of the repository
 */
@Service
public abstract class BaseServiceWithLocalFile<E extends BaseEntityWithLocalFile, D extends BaseDTO, R extends BaseRepository<E>> extends BaseService<E, D, R> {

    @Autowired
    protected LocalFileService localFileService;

    protected BaseServiceWithLocalFile(Class<E> entityClass, Class<D> dtoClass, R repository) {
        super(entityClass, dtoClass, repository);
    }

    /**
     * Uploads a file and associates it with an entity.
     *
     * @param multipartFile the file to upload
     * @param featured      whether the file should be set as featured or not
     * @param uuid          the {@link UUID} of the entity
     * @return the updated DTO with the file associated
     */
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
