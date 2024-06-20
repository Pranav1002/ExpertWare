package com.project.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OrderAlreadyExistException extends RuntimeException{

    public OrderAlreadyExistException(String msg){
        super(msg);
    }

}
