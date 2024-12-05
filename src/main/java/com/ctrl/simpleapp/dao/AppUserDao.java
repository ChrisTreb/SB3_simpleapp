package com.ctrl.simpleapp.dao;

import com.ctrl.simpleapp.records.AppUser;

import java.util.Date;
import java.util.List;

public interface AppUserDao {

    int countUsers();

    List<AppUser> getUsersByStringCriteria(String criteria, String search);

    List<AppUser> getUsersByDateCriteria(Date criteria, String search);

    List<AppUser> getUserById(Long id);

    List<AppUser> getUserByIdRange(Long firstId, Long limit);

    AppUser getUserWithCredentials(String login, String password);

    AppUser getUserByLogin(String login);
}
