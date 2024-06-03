package com.gabortodor.petproject.repository;

import com.gabortodor.petproject.entity.LocalFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocalFileRepository extends JpaRepository<LocalFile, UUID> {
}
