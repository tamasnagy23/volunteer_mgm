package com.example.volunteer_mgm.app_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerNewApp_User(@RequestBody App_User app_user){
        app_userService.addNewApp_User(app_user);
    }

    @DeleteMapping(path = "{app_userId}")
    public void deleteApp_User(@PathVariable ("app_userId") Long app_userId){
        app_userService.deleteApp_User(app_userId);
    }

    @PutMapping("{app_userId}")
    public void updateApp_User(@PathVariable("app_userId") Long app_userId, @RequestParam(required = false) String last_name,
                               @RequestParam(required = false) String first_name, @RequestParam(required = false) String email){
        app_userService.updateApp_User(app_userId, last_name, first_name, email);
    }
}
