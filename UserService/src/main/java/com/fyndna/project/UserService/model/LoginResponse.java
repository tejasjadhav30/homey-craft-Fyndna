package com.fyndna.project.UserService.model;

public class LoginResponse
{
    private String message;
    private String token;

    public LoginResponse(String message, String token)
    {
        this.message = message;
        this.token = token;
    }

    // Getters and setters
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
