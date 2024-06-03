package com.ctrl.simpleapp.service.impl;

import com.ctrl.simpleapp.records.Place;
import com.ctrl.simpleapp.rest.api.repository.PlaceRepository;
import com.ctrl.simpleapp.service.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceServiceImpl.class);

    @Autowired
    PlaceRepository placeRepository;

    @Override
    public Place savePlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public List<Place> fetchPlaceList() {
        return (List<Place>) placeRepository.findAll();
    }

    @Override
    public Place updatePlace(Place place, Long placeId) {

        if (placeRepository.findById(placeId).isPresent()) {
            Place placeDB = placeRepository.findById(placeId).get();
            return placeRepository.save(placeDB);
        } else {
            LOGGER.error("Place not found in our database - id : {}", place.id());
            return null;
        }
    }

    @Override
    public void deletePlaceById(Long placeId) {
        placeRepository.findById(placeId);
        LOGGER.info("Place deleted - id : {}", placeId);
    }
}
