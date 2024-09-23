package com.ctrl.simpleapp;

import com.ctrl.simpleapp.dao.impl.AppUserDaoImpl;
import com.ctrl.simpleapp.records.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RunOnStartUp implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunOnStartUp.class);

    @Autowired
    AppUserDaoImpl appUserDao;

    public RunOnStartUp() {
        // Empty constructor
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LOGGER.info("Application started with success !!!");

        List<AppUser> list =  appUserDao.getUsersByStringCriteria("firstname", "Christophe");

        for (AppUser user : list) {
            LOGGER.info(String.valueOf(user));
        }

    }
}
