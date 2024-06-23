package com.gabortodor.petproject.repository;

import com.gabortodor.petproject.entity.LocalFile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalFileRepository extends BaseRepository<LocalFile> {

    Optional<LocalFile> findByHashHex(String hashHex);
}
