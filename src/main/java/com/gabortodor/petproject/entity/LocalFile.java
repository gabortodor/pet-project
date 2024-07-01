package com.gabortodor.petproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.envers.Audited;

/**
 * Entity representing a local file with a path and hash.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Entity(name = "local_file")
public class LocalFile extends BaseEntity {

    /**
     * File path of the local file.
     */
    @Column(name = "path")
    private String path;

    /**
     * Hash of the file's content in hexadecimal format.
     */
    @Column(name = "hash_hex")
    private String hashHex;
}
