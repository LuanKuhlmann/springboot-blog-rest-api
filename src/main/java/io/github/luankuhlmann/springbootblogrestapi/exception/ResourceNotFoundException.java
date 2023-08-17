package io.github.luankuhlmann.springbootblogrestapi.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResponseStatus annotation cause Spring Boot to respond with the specified HTTP status code whenever
 * this exception is thrown from your controller.
 */
@Getter
@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{
    private final String resourceName;
    private final String fieldName;
    private final long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
