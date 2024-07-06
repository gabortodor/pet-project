package com.gabortodor.petproject.repository;

import com.gabortodor.petproject.entity.LocalFile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for {@link LocalFile} entities.
 * Provides CRUD operations, additional query methods.
 */
@Repository
public interface LocalFileRepository extends BaseRepository<LocalFile> {

    /**
     * Finds a {@link LocalFile} entity by its hash in hexadecimal format.
     *
     * @param hashHex the hash in hexadecimal format
     * @return an optional containing the {@link LocalFile} entity if found, otherwise empty
     */
    Optional<LocalFile> findByHashHex(String hashHex);
}
