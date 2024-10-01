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

    @GetMapping("/user/{id}")
    public AppUser getUsersById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/user/firstname/{search}")
    public List<AppUser> getUsersByFirstname(@PathVariable("search") String search) {
        return userService.getUsersByFirstName(search);
    }

    @GetMapping("/user/lastname/{search}")
    public List<AppUser> getUsersByLastname(@PathVariable("search") String search) {
        return userService.getUsersByLastName(search);
    }

    @GetMapping("/user/email/{search}")
    public List<AppUser> getUsersByEmail(@PathVariable("search") String search) {
        return userService.getUsersByEmail(search);
    }

    @GetMapping("/user/address/{search}")
    public List<AppUser> getUsersByAddress(@PathVariable("search") String search) {
        return userService.getUsersByAddress(search);
    }

    @GetMapping("/user/city/{search}")
    public List<AppUser> getUsersByCity(@PathVariable("search") String search) {
        return userService.getUsersByCity(search);
    }

    @GetMapping("/user/country/{search}")
    public List<AppUser> getUsersByCountry(@PathVariable("search") String search) {
        return userService.getUsersByCountry(search);
    }

    @GetMapping("/user/role/{search}")
    public List<AppUser> getUsersByRole(@PathVariable("search") String search) {
        return userService.getUsersByRole(search);
    }
}
