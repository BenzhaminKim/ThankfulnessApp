package com.thankfulness.thankfulness.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotMatchException extends RuntimeException {

    public UserNotMatchException(UUID id){
        super("User doesn't match"+ id);
    }
}
