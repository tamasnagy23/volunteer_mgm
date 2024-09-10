package com.example.volunteer_mgm.app_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class App_UserService {

    private final App_UserRepository app_userRepository;

    @Autowired
    public App_UserService(App_UserRepository app_userRepository) {
        this.app_userRepository = app_userRepository;
    }


    public List<App_User> getApp_User() {
        return app_userRepository.findAll();

    }

    public void addNewApp_User(App_User app_user) {
        Optional<App_User> app_userOptional = app_userRepository.findApp_UserByEmail(app_user.getEmail());
        if (app_userOptional.isPresent()){
            throw new IllegalStateException("Email already in use");
        }
        app_userRepository.save(app_user);
    }
}
