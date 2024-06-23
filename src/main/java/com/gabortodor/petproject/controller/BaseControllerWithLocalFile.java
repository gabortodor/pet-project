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

@Controller
public abstract class BaseControllerWithLocalFile<E extends BaseEntityWithLocalFile, D extends BaseDTOWithLocalFile, R extends BaseRepository<E>, S extends BaseServiceWithLocalFile<E, D, R>> extends BaseController<E, D, R, S> {

    public BaseControllerWithLocalFile(Class<E> entityClass, Class<D> dtoClass, S service) {
        super(entityClass, dtoClass, service);
    }

    @PostMapping("uploadFileTo/{uuid}")
    public D uploadFileToEntity(@RequestParam(name = "file") MultipartFile multipartFile,
                                @RequestParam(name = "featured", required = false, defaultValue = "false") Boolean featured,
                                @PathVariable UUID uuid) {
        return service.uploadFileToEntity(multipartFile, featured, uuid);
    }


}
