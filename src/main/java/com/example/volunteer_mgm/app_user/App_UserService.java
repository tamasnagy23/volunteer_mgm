package com.example.volunteer_mgm.app_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
}
