package com.gabortodor.petproject.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Base entity class that includes a reference to a featured local file.
 * Requires implementation of methods to manage associated local files.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntityWithLocalFile extends BaseEntity {

    /**
     * The featured local file associated with this entity.
     */
    @ManyToOne
    @JoinColumn(name = "featured_local_file_id")
    private LocalFile featuredLocalFile;

    /**
     * Gets the set of associated local files.
     *
     * @return the set of local files
     */
    public abstract Set<LocalFile> getLocalFiles();

    /**
     * Sets the associated local files.
     *
     * @param localFiles the set of local files
     */
    public abstract void setLocalFiles(Set<LocalFile> localFiles);
}
