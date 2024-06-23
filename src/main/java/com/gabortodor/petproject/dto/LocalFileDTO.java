package com.gabortodor.petproject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalFileDTO extends BaseDTO {

    @NotBlank
    private String path;

    private String hashHex;

}
