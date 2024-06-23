package com.gabortodor.petproject.controller;

import com.gabortodor.petproject.dto.LocalFileDTO;
import com.gabortodor.petproject.entity.LocalFile;
import com.gabortodor.petproject.repository.LocalFileRepository;
import com.gabortodor.petproject.service.LocalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLConnection;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/local-file")
public class LocalFileController extends BaseController<LocalFile, LocalFileDTO, LocalFileRepository, LocalFileService> {

    @Autowired
    public LocalFileController(LocalFileService localFileService) {
        super(LocalFile.class, LocalFileDTO.class, localFileService);
    }

    @GetMapping("/download/{uuid}")
    public ResponseEntity<Resource> download(@PathVariable UUID uuid) throws IOException {
        Resource resource = service.downloadLocalFile(uuid);

        return ResponseEntity.ok()
                .contentLength(resource.contentLength())
                .contentType(getMediaTypeFromFileName(resource.getFilename()))
                .body(resource);
    }

    private MediaType getMediaTypeFromFileName(String filename) {
        return MediaType.parseMediaType(URLConnection.guessContentTypeFromName(filename));
    }

}
