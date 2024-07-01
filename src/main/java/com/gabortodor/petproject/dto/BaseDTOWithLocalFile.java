package com.gabortodor.petproject.dto;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Base DTO class that includes a reference to a featured local file.
 * Also includes a set of associated local files.
 */
@Getter
@Setter
public class BaseDTOWithLocalFile extends BaseDTO {

    /**
     * The featured local file associated with this DTO.
     */
    @Valid
    private LocalFileDTO featuredLocalFile;

    /**
     * Set of local files associated with this DTO.
     */
    @Valid
    private Set<LocalFileDTO> localFiles;
}
