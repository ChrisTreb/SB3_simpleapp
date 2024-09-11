package com.ctrl.simpleapp.service;

import com.ctrl.simpleapp.records.AppUser;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser appUser);

    List<AppUser> fetchUserList();

    AppUser updateUser(AppUser appUser, Long userId);

    void deleteUserById(Long userId);

    List<AppUser> getUsersByLastName(String search);
}
