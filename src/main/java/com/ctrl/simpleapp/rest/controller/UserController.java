package com.ctrl.simpleapp.rest.controller;

import com.ctrl.simpleapp.records.AppUser;
import com.ctrl.simpleapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save-user")
    public AppUser saveUser(@Valid @RequestBody AppUser appUser) {
        return userService.saveUser(appUser);
    }

    @GetMapping("/user")
    public List<AppUser> fetchUserList() {
        return userService.fetchUserList();
    }

    @PutMapping("/put-user/{id}")
    public AppUser updateUser(@RequestBody AppUser appUser, @PathVariable("id") Long userId) {
        return userService.updateUser(appUser, userId);
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        return "User deleted successfully - id : " + userId;
    }

}
