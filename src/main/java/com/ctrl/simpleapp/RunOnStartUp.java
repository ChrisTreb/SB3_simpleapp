package com.ctrl.simpleapp;

import com.ctrl.simpleapp.dao.impl.PlaceDaoImpl;
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
    PlaceDaoImpl placeDao;

    public RunOnStartUp() {
        // Empty constructor
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LOGGER.info("Application started with success !!!");

        List<String> list = placeDao.getCountries();

        for(String country : list) {
            LOGGER.info(country);
        }

    }
}
