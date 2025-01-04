package com.ctrl.simpleapp.service.impl;

import com.ctrl.simpleapp.configuration.JasyptEncryptorConfig;
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

    @Autowired
    JasyptEncryptorConfig jasyptEncryptorConfig;

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
    public AppUser getUserById(Long id) {
        return appUserDao.getUserById(id).getFirst();
    }

    @Override
    public int countUsers() {
        return appUserDao.countUsers();
    }

    @Override
    public List<AppUser> getUsersByLastName(String search) {
        return appUserDao.getUsersByStringCriteria("lastname", search);
    }

    @Override
    public List<AppUser> getUsersByFirstName(String search) {
        return appUserDao.getUsersByStringCriteria("firstname", search);
    }

    @Override
    public List<AppUser> getUsersByEmail(String search) {
        return appUserDao.getUsersByStringCriteria("email", search);
    }

    @Override
    public List<AppUser> getUsersByAddress(String search) {
        return appUserDao.getUsersByStringCriteria("address", search);
    }

    @Override
    public List<AppUser> getUsersByCity(String search) {
        return appUserDao.getUsersByStringCriteria("city", search);
    }

    @Override
    public List<AppUser> getUsersByCountry(String search) {
        return appUserDao.getUsersByStringCriteria("country", search);
    }

    @Override
    public List<AppUser> getUsersByRole(String search) {
        return appUserDao.getUsersByStringCriteria("role", search);
    }

    @Override
    public List<AppUser> getUsersByIdRange(Long firstId, Long limit) {
        return appUserDao.getUserByIdRange(firstId, limit);
    }

    @Override
    public AppUser getUserWithCredentials(String login, String password) {
        return appUserDao.getUserWithCredentials(login, password);
    }

    @Override
    public AppUser encryptPassword(AppUser user) {
        return new AppUser(
                user.id(),
                user.created_at(),
                user.lastname(),
                user.firstname(),
                user.email(),
                user.gender(),
                user.date_of_birth(),
                user.address(),
                user.city(),
                user.country(),
                user.role(),
                user.image(),
                user.login(),
                jasyptEncryptorConfig.passwordEncryptor().encrypt(user.password())
        );
    }

    @Override
    public AppUser getUserByLogin(String login) {
        return appUserDao.getUserByLogin(login);
    }
}
