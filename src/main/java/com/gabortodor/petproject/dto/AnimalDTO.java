package com.gabortodor.petproject.dto;

import com.gabortodor.petproject.entity.constant.AnimalGender;
import com.gabortodor.petproject.entity.constant.AnimalType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * DTO representing an animal with various attributes and associations.
 */
@Getter
@Setter
public class AnimalDTO extends BaseDTOWithLocalFile {

    /**
     * Type of the animal (e.g., DOG, CAT).
     */
    @NotNull
    private AnimalType type;

    /**
     * Gender of the animal (e.g., MALE, FEMALE).
     */
    @NotNull
    private AnimalGender gender;

    /**
     * Name of the animal.
     */
    @NotBlank
    private String name;

    /**
     * Birthdate of the animal.
     */
    @PastOrPresent
    private Instant birthDate;

    /**
     * Timestamp when the animal was brought in.
     */
    @PastOrPresent
    private Instant broughtInAt;

    /**
     * Breed of the animal.
     */
    @NotNull
    @Valid
    private BreedDTO breed;

    /**
     * Color of the animal.
     */
    private String color;

    /**
     * Type of the animal's fur.
     */
    private String furType;

    /**
     * Size of the animal's body.
     */
    private String bodySize;

    /**
     * Indicates whether the animal is chipped.
     */
    private Boolean chipped;

    /**
     * Description of the animal.
     */
    private String description;
}
