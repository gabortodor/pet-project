package com.gabortodor.petproject.dto;

import com.gabortodor.petproject.entity.BaseEntityWithLocalFile;
import com.gabortodor.petproject.entity.constant.AnimalGender;
import com.gabortodor.petproject.entity.constant.AnimalType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AnimalDTO extends BaseDTOWithLocalFile {

    @NotNull
    private AnimalType type;

    @NotNull
    private AnimalGender gender;

    @NotBlank
    private String name;

    @PastOrPresent
    private Instant birthDate;

    @PastOrPresent
    private Instant broughtInAt;

    @NotNull
    @Valid
    private BreedDTO breed;

    private String color;

    private String furType;

    private String bodySize;

    private Boolean chipped;

    private String description;
}
