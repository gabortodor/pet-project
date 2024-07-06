package com.gabortodor.petproject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO representing a local file with a path and hash.
 */
@Getter
@Setter
public class LocalFileDTO extends BaseDTO {

    /**
     * File path of the local file.
     */
    @NotBlank
    private String path;

    /**
     * Hash of the file's content in hexadecimal format.
     */
    private String hashHex;

}
