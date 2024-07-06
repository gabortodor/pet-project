package com.gabortodor.petproject.entity;

import com.gabortodor.petproject.entity.constant.AnimalType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.envers.Audited;

/**
 * Entity representing a breed with a type and name.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Entity(name = "breed")
public class Breed extends BaseEntity {

    /**
     * Type of the animal (e.g., DOG, CAT) for this breed.
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AnimalType type;

    /**
     * Name of the breed.
     */
    @Column(name = "name")
    private String name;
}
