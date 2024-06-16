package com.gabortodor.petproject.dto;

import com.gabortodor.petproject.entity.constant.AnimalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreedDTO extends BaseDTO {

    @NotNull
    private AnimalType type;

    @NotBlank
    private String name;
}
