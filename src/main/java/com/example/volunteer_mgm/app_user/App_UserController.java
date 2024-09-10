package com.example.volunteer_mgm.app_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/app_user")
public class App_UserController {

    private final App_UserService app_userService;

    @Autowired
    public App_UserController(App_UserService app_userService) {
        this.app_userService = app_userService;
    }

    @GetMapping
    public List<App_User> getUser() {
        return app_userService.getApp_User();
    }
}
