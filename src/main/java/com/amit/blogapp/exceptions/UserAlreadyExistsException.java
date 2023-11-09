package com.amit.blogapp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAlreadyExistsException extends RuntimeException{
    private String resource;
    private String field;
    private Long id;
    public UserAlreadyExistsException(String resource,String field,Long id){
        super(String.format("%s with this %s: %l already exists",resource,field,id));
        this.resource = resource;
        this.field = field;
        this.id= id;
    }
}
