package com.gabortodor.petproject.controller;

import com.gabortodor.petproject.dto.BaseDTOWithLocalFile;
import com.gabortodor.petproject.entity.BaseEntityWithLocalFile;
import com.gabortodor.petproject.repository.BaseRepository;
import com.gabortodor.petproject.service.BaseServiceWithLocalFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Abstract base controller class providing REST API endpoints for entities with local file uploads.
 *
 * @param <E> the type of the entity
 * @param <D> the type of the DTO
 * @param <R> the type of the repository
 * @param <S> the type of the service
 */
@Controller
public abstract class BaseControllerWithLocalFile<E extends BaseEntityWithLocalFile, D extends BaseDTOWithLocalFile, R extends BaseRepository<E>, S extends BaseServiceWithLocalFile<E, D, R>> extends BaseController<E, D, R, S> {

    public BaseControllerWithLocalFile(Class<E> entityClass, Class<D> dtoClass, S service) {
        super(entityClass, dtoClass, service);
    }

    /**
     * Uploads a file and associates it with an entity.
     *
     * @param multipartFile the {@link MultipartFile} to upload
     * @param featured      whether the file should be set as featured
     * @param uuid          the {@link UUID} of the entity
     * @return the updated DTO with the file associated
     */
    @PostMapping("uploadFileTo/{uuid}")
    public D uploadFileToEntity(@RequestParam(name = "file") MultipartFile multipartFile,
                                @RequestParam(name = "featured", required = false, defaultValue = "false") Boolean featured,
                                @PathVariable UUID uuid) {
        return service.uploadFileToEntity(multipartFile, featured, uuid);
    }


}
