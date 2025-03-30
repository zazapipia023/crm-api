package org.colizeum.crmapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GuideNotFoundException extends RuntimeException {
    public GuideNotFoundException(String message) {
        super(message);
    }
}
