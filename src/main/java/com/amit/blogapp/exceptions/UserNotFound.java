package com.amit.blogapp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFound extends RuntimeException {
    // This is Runtime exception so it is unchecked exception.
    private String resource;
    private String fieldName;
    private Long id;

    public UserNotFound(){

    }

   public UserNotFound(String resource, String fieldName, Long id){
        super(String.format("%s not found with %s :%l",resource,fieldName,id));
        this.resource = resource;
        this.fieldName = fieldName;
        this.id = id;
    }
}
