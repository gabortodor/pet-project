package com.gabortodor.petproject.dto;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BaseDTOWithLocalFile extends BaseDTO {

    @Valid
    private LocalFileDTO featuredLocalFile;

    @Valid
    private Set<LocalFileDTO> localFiles;
}
