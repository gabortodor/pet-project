package com.gabortodor.petproject.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntityWithLocalFile extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="featured_local_file_id")
    private LocalFile featuredLocalFile;

    public abstract Set<LocalFile> getLocalFiles();

    public abstract void setLocalFiles(Set<LocalFile> localFiles);
}
