package com.ctrl.simpleapp.service;

import com.ctrl.simpleapp.records.AppUser;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser appUser);

    List<AppUser> fetchUserList();

    AppUser updateUser(AppUser appUser, Long userId);

    void deleteUserById(Long userId);

    AppUser getUserById(Long id);

    List<AppUser> getUsersByLastName(String search);

    List<AppUser> getUsersByFirstName(String search);

    List<AppUser> getUsersByEmail(String search);

    List<AppUser> getUsersByAddress(String search);

    List<AppUser> getUsersByCity(String search);

    List<AppUser> getUsersByCountry(String search);

    List<AppUser> getUsersByRole(String search);

    List<AppUser> getUsersByIdRange(Long firstId, Long lastId);
}
