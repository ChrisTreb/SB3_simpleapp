package com.ctrl.simpleapp.service.impl;

import com.ctrl.simpleapp.records.User;
import com.ctrl.simpleapp.rest.api.repository.UserRepository;
import com.ctrl.simpleapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            User userDB = userRepository.findById(userId).get();
            return userRepository.save(userDB);
        } else {
            LOGGER.error("User bot found in our database - id : {}", user.id());
            return null;
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.findById(userId);
        LOGGER.info("User deleted - id : {}", userId);
    }
}
