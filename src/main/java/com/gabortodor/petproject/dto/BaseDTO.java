package com.gabortodor.petproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class BaseDTO {

    private UUID id;

    private Instant createdAt;

    private Instant lastModifiedAt;
}
