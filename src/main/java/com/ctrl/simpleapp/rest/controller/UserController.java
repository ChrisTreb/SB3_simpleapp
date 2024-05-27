package com.ctrl.simpleapp.rest.controller;

import com.ctrl.simpleapp.records.User;
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
    public User saveUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/user")
    public List<User> fetchUserList() {
        return userService.fetchUserList();
    }

    @PutMapping("/put-user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long userId) {
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("/delete-bookings/{id}")
    public String deleteBookingById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        return "Book deleted successfully - id : " + userId;
    }

}
