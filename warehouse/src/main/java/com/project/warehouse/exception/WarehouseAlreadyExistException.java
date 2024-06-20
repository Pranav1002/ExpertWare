package com.project.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WarehouseAlreadyExistException extends RuntimeException{

    public WarehouseAlreadyExistException(String msg){
        super(msg);
    }

}
