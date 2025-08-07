package com.fyndna.project.UserService.exceptions;

public class InvalidMobileNumberException extends RuntimeException
{
    public InvalidMobileNumberException(String message)
    {
        super(message);
    }
}