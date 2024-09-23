package com.ctrl.simpleapp.dao;

import com.ctrl.simpleapp.records.AppUser;

import java.util.Date;
import java.util.List;

public interface AppUserDao {

    List<AppUser> getUsersByStringCriteria(String criteria, String search);

    List<AppUser> getUsersByDateCriteria(Date criteria, String search);

    List<AppUser> getUserById(Long id);

}
