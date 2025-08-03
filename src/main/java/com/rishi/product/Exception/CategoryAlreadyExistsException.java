package com.rishi.product.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlreadyExistsException extends RuntimeException{
    public CategoryAlreadyExistsException(String message)
    {
        super(message);
    }
}
