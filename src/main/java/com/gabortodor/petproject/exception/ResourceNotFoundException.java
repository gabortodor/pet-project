package com.gabortodor.petproject.exception;


import lombok.Getter;

/**
 * Exception thrown when a requested resource is not found.
 */
@Getter
public class ResourceNotFoundException extends RuntimeException {
    /**
     * The class of the resource that was not found.
     */
    private final Class<?> resourceClass;

    /**
     * The name of the key used to search for the resource.
     */
    private final String keyName;

    /**
     * The value of the key used to search for the resource.
     */
    private final String keyValue;

    /**
     * Constructs a new {@link ResourceNotFoundException} with the specified resource class.
     *
     * @param resourceClass the class of the resource that was not found
     */
    public ResourceNotFoundException(Class<?> resourceClass) {
        this.resourceClass = resourceClass;
        this.keyName = null;
        this.keyValue = null;
    }

    /**
     * Constructs a new {@link ResourceNotFoundException} with the specified resource class, key name, and key value.
     *
     * @param resourceClass the class of the resource that was not found
     * @param keyName the name of the key used to search for the resource
     * @param keyValue the value of the key used to search for the resource
     */
    public ResourceNotFoundException(Class<?> resourceClass, String keyName, String keyValue) {
        this.resourceClass = resourceClass;
        this.keyName = keyName;
        this.keyValue = keyValue;
    }

    /**
     * Generates an error message for this exception.
     *
     * @return the generated error message
     */
    public String generateErrorMessage() {
        if (this.keyName != null && this.keyValue != null) {
            return String.format("Cannot find %s entity with %s: %s!", this.resourceClass.getSimpleName(), this.keyName, this.keyValue);
        }
        return String.format("Cannot find %s entity!", this.resourceClass.getSimpleName());
    }
}
