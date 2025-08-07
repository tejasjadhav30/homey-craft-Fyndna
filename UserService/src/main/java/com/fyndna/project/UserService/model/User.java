package com.fyndna.project.UserService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @Column(length = 50, unique = true, nullable = false)
    @Email(message = "Email must be valid (e.g. name@gmail.com)")
    @NotBlank(message = "Email cannot be empty")
    private String emailId;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "Username cannot be empty")
    private String username;

    @Column(length = 10)
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Column(length = 10)
    private String gender;

    @Column(length = 20)
    private String role;
}
