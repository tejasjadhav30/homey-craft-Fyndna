package com.fyndna.project.UserService.controller;

import com.fyndna.project.UserService.exceptions.EmailIdAlreadyExistException;
import com.fyndna.project.UserService.exceptions.EmailIdNotExistException;
import com.fyndna.project.UserService.model.User;
import com.fyndna.project.UserService.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userServiceImpl;

   private RestTemplate restTemplate;

    @PostMapping("/register")
    public ResponseEntity<?> registrationOfUser(@Valid @RequestBody User user) {
        try {
            User registeredUser = userServiceImpl.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (EmailIdAlreadyExistException e) {
            return new ResponseEntity<>("Email already exists: " + user.getEmailId(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>("Registration failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userServiceImpl.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> validateUser(@RequestBody User user) {
        boolean isValid = userServiceImpl.validateUser(user);
        if (isValid) {
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Email or Password", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        return new ResponseEntity<>(userServiceImpl.findByRole(role), HttpStatus.OK);
    }

    @PutMapping("/{emailId}")
    public ResponseEntity<?> updateUser(@PathVariable String emailId, @RequestBody User user) {
        try {
            User updatedUser = userServiceImpl.updateUser(emailId, user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (EmailIdNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{emailId}")
    public ResponseEntity<String> deleteUser(@PathVariable String emailId) {
        boolean deleted = userServiceImpl.deleteUser(emailId);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

}
