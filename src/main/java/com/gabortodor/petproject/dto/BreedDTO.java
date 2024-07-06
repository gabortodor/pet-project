package com.gabortodor.petproject.dto;

import com.gabortodor.petproject.entity.constant.AnimalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO representing a breed with a type and name.
 */
@Getter
@Setter
public class BreedDTO extends BaseDTO {

    /**
     * Type of the animal (e.g., DOG, CAT) for this breed.
     */
    @NotNull
    private AnimalType type;

    /**
     * Name of the breed.
     */
    @NotBlank
    private String name;
}
