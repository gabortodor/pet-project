package com.gabortodor.petproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.envers.Audited;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Entity(name = "local_file")
public class LocalFile extends BaseEntity {

    @Column(name = "path")
    private String path;
}
