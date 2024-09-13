package com.example.volunteer_mgm.app_user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class App_UserService {

    private final App_UserRepository app_userRepository;

    @Autowired
    public App_UserService(App_UserRepository app_userRepository) {
        this.app_userRepository = app_userRepository;
    }


    ///get method to find the user
    public List<App_User> getApp_User() {
        return app_userRepository.findAll();

    }

    ///post method to add new user
    public void addNewApp_User(App_User app_user) {
        Optional<App_User> app_userOptional = app_userRepository.findApp_UserByEmail(app_user.getEmail());
        if (app_userOptional.isPresent()) {
            throw new IllegalStateException("Email already in use");
        }
        app_userRepository.save(app_user);
    }

    ///delete method to delete existing user
    public void deleteApp_User(Long app_userId) {
        boolean exists = app_userRepository.existsById(app_userId);
        if (!exists) {
            throw new IllegalStateException("the user with id " + app_userId + " does not exist");
        }
        app_userRepository.deleteById(app_userId);
    }

    ///put method to update an existing user
    @Transactional
    public void updateApp_User(Long app_userId, String last_name, String first_name, String email){
        App_User app_user = app_userRepository.findById(app_userId).orElseThrow(() -> new IllegalStateException("the user with id " + app_userId + " does not exist"));

        if (last_name != null && !last_name.isEmpty() && !Objects.equals(app_user.getLast_name(), last_name)){
            app_user.setLast_name(last_name);
        }

        if (first_name != null && !first_name.isEmpty() && !Objects.equals(app_user.getFirst_name(), first_name)){
            app_user.setFirst_name(first_name);
        }

        if (email != null && !email.isEmpty() && !Objects.equals(app_user.getEmail(), email)){
            Optional<App_User> app_userOptional = app_userRepository.findApp_UserByEmail(email);
            if (app_userOptional.isPresent()){
                throw new IllegalStateException("This email is already in use");
            }
            app_user.setEmail(email);
        }
    }
}
