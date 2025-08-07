package com.fyndna.project.UserService.service;

import com.fyndna.project.UserService.exceptions.EmailIdAlreadyExistException;
import com.fyndna.project.UserService.exceptions.EmailIdNotExistException;
import com.fyndna.project.UserService.exceptions.InvalidMobileNumberException;
import com.fyndna.project.UserService.model.User;
import com.fyndna.project.UserService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private RestTemplate restTemplate;


    @Override
    public Optional<User> findUserByEmailAndPassword(String emailId, String password) {
        Optional<User> user= userRepository.findUserByEmailIdAndPassword(emailId,password);
        return user;
    }



    @Override
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }

    @Override
    public User registerUser(User user) throws EmailIdAlreadyExistException {
        Optional<User> existingUser= userRepository.findUserByEmailId(user.getEmailId());
       if(existingUser.isPresent()){
           throw new EmailIdAlreadyExistException("User with "+ user.getEmailId()+" is already exist");
       }
       return userRepository.save(user);

    }

    @Override
    public Optional<User> getUserByEmailId(String emailId) throws EmailIdNotExistException {
        Optional<User> user = userRepository.findUserByEmailId(emailId);
        if (user.isEmpty()) {
            throw new EmailIdNotExistException("User with email " + emailId + " not found.");
        }
        return user;
    }

    @Override
    public User updateUser(String emailId, User user) throws EmailIdNotExistException {
        Optional<User> existUser= userRepository.findUserByEmailId(emailId);
        if(existUser.isEmpty()){
            throw new EmailIdNotExistException("provided "+ user.getEmailId()+ " is not exist");
        }
            User user1 = new User();
            user1.setMobileNumber(user.getMobileNumber());
            user1.setGender(user.getGender());
            user1.setPassword(user.getPassword());
            user1.setUsername(user.getUsername());
            user1.setEmailId(user.getEmailId());
            user1.setRole(user1.getRole());
return userRepository.save(user1);
    }

    @Override
    public boolean deleteUser(String emailId) {
        Optional<User> existUser= userRepository.findUserByEmailId(emailId);
        if (existUser.isPresent()) {
            userRepository.deleteById(emailId);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public boolean validateUser(User user) {
        Optional<User> existingUser = userRepository.findUserByEmailIdAndPassword(user.getEmailId(), user.getPassword());
        return existingUser.isPresent();
    }

}
