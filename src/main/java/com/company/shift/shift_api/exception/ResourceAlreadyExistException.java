package com.company.shift.shift_api.exception;


public class ResourceAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 2L;
    public ResourceAlreadyExistException(String msg) {
        super(msg);
    }
}
