package com.Kunal.accounts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String resourceName,String field, String value) {
        super(String.format("%s not found with given  %s : '%s'",resourceName,field,value));
    }
}
