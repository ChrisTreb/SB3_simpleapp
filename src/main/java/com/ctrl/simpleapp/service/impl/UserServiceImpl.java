package com.ctrl.simpleapp.service.impl;

import com.ctrl.simpleapp.records.User;
import com.ctrl.simpleapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public List<User> fetchUserList() {
        return List.of();
    }

    @Override
    public User updateUser(User user, Long userId) {
        return null;
    }

    @Override
    public void deleteUserById(Long userId) {

    }
}
