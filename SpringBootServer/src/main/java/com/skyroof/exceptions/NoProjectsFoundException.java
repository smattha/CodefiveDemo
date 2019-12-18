package com.skyroof.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No Projects for this User")
public class NoProjectsFoundException extends RuntimeException {

    public NoProjectsFoundException() {
        super();
    }

    public NoProjectsFoundException(String message) {
        super(message);
    }

    public NoProjectsFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoProjectsFoundException(Throwable cause) {
        super(cause);
    }
}
