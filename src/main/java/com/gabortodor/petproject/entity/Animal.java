package com.gabortodor.petproject.entity;

import com.gabortodor.petproject.entity.constant.AnimalGender;
import com.gabortodor.petproject.entity.constant.AnimalType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.time.Instant;
import java.util.Set;

/**
 * Entity representing an animal with various attributes and associations.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
@Entity(name = "animal")
public class Animal extends BaseEntityWithLocalFile {

    /**
     * Type of the animal (e.g., DOG, CAT).
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AnimalType type;

    /**
     * Gender of the animal (e.g., MALE, FEMALE).
     */
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private AnimalGender gender;

    /**
     * Name of the animal.
     */
    @Column(name = "name")
    private String name;

    /**
     * Birthdate of the animal.
     */
    @Column(name = "birth_date")
    private Instant birthDate;

    /**
     * Timestamp when the animal was brought in.
     */
    @Column(name = "brought_in_at")
    private Instant broughtInAt;

    /**
     * Breed of the animal.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "breed_id", nullable = false)
    private Breed breed;

    /**
     * Color of the animal.
     */
    @Column(name = "color")
    private String color;

    /**
     * Type of the animal's fur.
     */
    @Column(name = "fur_type")
    private String furType;

    /**
     * Size of the animal's body.
     */
    @Column(name = "body_size")
    private String bodySize;

    /**
     * Indicates whether the animal is chipped or not.
     */
    @Column(name = "is_chipped")
    private Boolean chipped;

    /**
     * Description of the animal.
     */
    @Column(name = "description")
    private String description;

    /**
     * Set of local files associated with the animal.
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "animal_local_file",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "local_file_id")
    )
    private Set<LocalFile> localFiles;
}
