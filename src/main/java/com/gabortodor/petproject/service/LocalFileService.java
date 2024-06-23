package com.gabortodor.petproject.service;

import com.gabortodor.petproject.dto.LocalFileDTO;
import com.gabortodor.petproject.entity.LocalFile;
import com.gabortodor.petproject.exception.ResourceNotFoundException;
import com.gabortodor.petproject.repository.LocalFileRepository;
import lombok.extern.log4j.Log4j2;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
public class LocalFileService extends BaseService<LocalFile, LocalFileDTO, LocalFileRepository> {

    @Value("${pet_project.uploads.directory}")
    private String uploadsDirectory;

    @Autowired
    public LocalFileService(LocalFileRepository repository) {
        super(LocalFile.class, LocalFileDTO.class, repository);
    }

    public LocalFile uploadLocalFile(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            //TODO exception
            log.error("Empty multipart file received.");
        }
        try {
            final String hexString = getHashFromBytes(multipartFile.getBytes());
            Optional<LocalFile> optionalLocalFile = repository.findByHashHex(hexString);
            if (optionalLocalFile.isPresent()) {
                return optionalLocalFile.get();
            }
            File uploadDir = new File(uploadsDirectory);
            if (!uploadDir.exists()) uploadDir.mkdirs();
            String filePath = uploadDir + File.separator + multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(filePath));
            LocalFile localFile = new LocalFile();
            localFile.setPath(filePath);
            localFile.setHashHex(hexString);
            return repository.save(localFile);
        } catch (IOException exception) {
            //TODO exception
            log.error("IOException occured during file upload.");
            throw new RuntimeException(exception);
        }
    }

    public Resource downloadLocalFile(UUID uuid) {
        LocalFile localFile = repository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException(entityClass, "id", uuid.toString()));

        Path path = Paths.get(localFile.getPath());
        try {
            return new ByteArrayResource(Files.readAllBytes(path)) {
                @Override
                public String getFilename() {
                    return path.getFileName().toString();
                }
            };
        } catch (IOException exception) {
            //TODO exception
            log.error("IOException occured during file download.");
            throw new RuntimeException(exception);
        }
    }

    public static String getHashFromBytes(byte[] bytes) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            return toHexString(messageDigest.digest(bytes));
        } catch (NoSuchAlgorithmException exception) {
            //TODO exception
            log.error("NoSuchAlgorithmException occured during hash generation.");
            throw new RuntimeException(exception);
        }
    }

    private static String toHexString(byte[] hashBytes) {
        BigInteger number = new BigInteger(1, hashBytes);
        return StringUtils.leftPad(number.toString(16), 32, '0');

    }
}
