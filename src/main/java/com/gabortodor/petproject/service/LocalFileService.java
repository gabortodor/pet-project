package com.gabortodor.petproject.service;

import com.gabortodor.petproject.dto.LocalFileDTO;
import com.gabortodor.petproject.entity.LocalFile;
import com.gabortodor.petproject.repository.LocalFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalFileService extends BaseService<LocalFile, LocalFileDTO, LocalFileRepository> {

    @Autowired
    public LocalFileService(LocalFileRepository repository) {
        super(LocalFile.class, LocalFileDTO.class, repository);
    }
}
