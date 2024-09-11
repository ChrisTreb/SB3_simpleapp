package com.ctrl.simpleapp.dao;

import com.ctrl.simpleapp.records.AppUser;

import java.util.Date;
import java.util.List;

public interface AppUserDao {

    List<AppUser> getUserByStringCriteria(String criteria, String search);

    List<AppUser> getUserByDateCriteria(Date criteria, String search);

}
