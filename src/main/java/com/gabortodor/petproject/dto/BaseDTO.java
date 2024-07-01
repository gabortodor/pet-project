package com.gabortodor.petproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

/**
 * Base Data Transfer Object (DTO) class.
 * Provides common properties like id, createdAt, and lastModifiedAt.
 */
@Getter
@Setter
public class BaseDTO {

    /**
     * Unique identifier for the DTO.
     */
    private UUID id;

    /**
     * Timestamp when the DTO was created.
     */
    private Instant createdAt;

    /**
     * Timestamp when the DTO was last modified.
     */
    private Instant lastModifiedAt;
}
