package com.gabortodor.petproject.entity;

import com.gabortodor.petproject.entity.constant.AnimalType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.envers.Audited;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Entity(name = "breed")
public class Breed extends BaseEntity {
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AnimalType type;

    @Column(name = "name")
    private String name;
}
