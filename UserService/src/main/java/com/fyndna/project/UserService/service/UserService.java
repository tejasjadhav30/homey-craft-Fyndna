    package com.fyndna.project.UserService.service;


    import com.fyndna.project.UserService.exceptions.EmailIdAlreadyExistException;
    import com.fyndna.project.UserService.exceptions.EmailIdNotExistException;
    import com.fyndna.project.UserService.model.User;

    import java.util.List;
    import java.util.Optional;

    public interface UserService {

        Optional<User> findUserByEmailAndPassword(String emailId,String password);
        List<User> findByRole(String role);
        User registerUser(User user) throws EmailIdAlreadyExistException;
        Optional<User> getUserByEmailId(String emailId) throws EmailIdNotExistException;
        User updateUser(String emailId,User user) throws EmailIdNotExistException;
        boolean deleteUser(String emailId);
        List<User> getAllUser();
        boolean validateUser(User user);


    }
