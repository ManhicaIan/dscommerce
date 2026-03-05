package com.manhica.dscommerce.services.exceptions;

public class ReferentialIntegrityViolationException extends RuntimeException{
    public ReferentialIntegrityViolationException(String msg){
        super(msg);
    }
}
