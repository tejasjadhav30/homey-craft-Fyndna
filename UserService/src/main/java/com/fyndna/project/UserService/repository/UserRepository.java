package com.fyndna.project.UserService.repository;

import com.fyndna.project.UserService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findUserByEmailId(String emailId);
    Optional<User> findUserByEmailIdAndPassword(String emailId, String password);
    List<User> findByRole(String role);

}
