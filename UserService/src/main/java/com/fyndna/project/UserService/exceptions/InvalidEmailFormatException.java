package com.fyndna.project.UserService.exceptions;

public class InvalidEmailFormatException extends RuntimeException
{
    public InvalidEmailFormatException(String message) {
        super(message);
    }
}