package com.gabortodor.petproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * Base entity class for all entities.
 * Provides common properties like id, createdAt, and lastModifiedAt.
 */
@Getter
@Setter
@ToString
@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    /**
     * Unique identifier for the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * Timestamp when the entity was created.
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;

    /**
     * UUID of the user, who created the entity.
     */
    @Column(name = "created_by", nullable = false, updatable = false)
    @CreatedBy
    private UUID createdBy;

    /**
     * Timestamp when the entity was last modified.
     */
    @Column(name = "last_modified_at")
    @LastModifiedDate
    private Instant lastModifiedAt;

    /**
     * UUID of the user, who last modified the entity.
     */
    @Column(name = "last_modified_by", nullable = false, updatable = false)
    @LastModifiedBy
    private UUID lastModifiedBy;
}
