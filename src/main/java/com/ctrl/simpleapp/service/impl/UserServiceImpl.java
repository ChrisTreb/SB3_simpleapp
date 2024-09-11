package com.ctrl.simpleapp.service.impl;

import com.ctrl.simpleapp.dao.AppUserDao;
import com.ctrl.simpleapp.records.AppUser;
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

    @Autowired
    AppUserDao appUserDao;

    @Override
    public AppUser saveUser(AppUser appUser) {
        return userRepository.save(appUser);
    }

    @Override
    public List<AppUser> fetchUserList() {
        return (List<AppUser>) userRepository.findAll();
    }

    @Override
    public AppUser updateUser(AppUser appUser, Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            AppUser appUserDB = userRepository.findById(userId).get();
            return userRepository.save(appUserDB);
        } else {
            LOGGER.error("User not found in our database - id : {}", appUser.id());
            return null;
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.findById(userId);
        LOGGER.info("User deleted - id : {}", userId);
    }

    @Override
    public List<AppUser> getUsersByLastName(String search) {
        return appUserDao.getUserByStringCriteria("lastname", search);
    }
}
