package com.fyndna.project.UserService.model;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String>
{
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private Pattern EMAIL_PATTERN;
    private String domain;

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
        domain = constraintAnnotation.domain();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            return false;
        }
        return email.endsWith(domain);
    }
}
