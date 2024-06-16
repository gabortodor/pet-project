package com.gabortodor.petproject.exception;


import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final Class<?> resourceClass;
    private final String keyName;
    private final String keyValue;

    public ResourceNotFoundException(Class<?> resourceClass) {
        this.resourceClass = resourceClass;
        this.keyName = null;
        this.keyValue = null;
    }

    public ResourceNotFoundException(Class<?> resourceClass, String keyName, String keyValue) {
        this.resourceClass = resourceClass;
        this.keyName = keyName;
        this.keyValue = keyValue;
    }

    public String generateErrorMessage() {
        if (this.keyName != null && this.keyValue != null) {
            return String.format("Cannot find %s entity with %s: %s!", this.resourceClass.getSimpleName(), this.keyName, this.keyValue);
        }
        return String.format("Cannot find %s entity!", this.resourceClass.getSimpleName());
    }
}
