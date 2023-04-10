package com.blogapp.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResoureceNotFoundExcepeiton extends RuntimeException{
    String resurceName;
    String fieldName;
    long fieldValue;

    public ResoureceNotFoundExcepeiton(String resurceName,String fieldName,long fieldValue) {
        super(String.format("%s not found with %s:%l",resurceName,fieldName,fieldValue));
        this.resurceName = resurceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;

    }
}
