package com.ctrl.simpleapp.service.impl;

import com.ctrl.simpleapp.dao.PlaceDao;
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

    @Autowired
    PlaceDao placeDao;

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

    @Override
    public Place getPlaceById(Long id) {
        return placeDao.getPlaceById(id).getFirst();
    }

    @Override
    public List<Place> getPlacesByName(String search) {
        return placeDao.getPlacesByStringCriteria("name", search);
    }

    @Override
    public List<Place> getPlacesByDescription(String search) {
        return placeDao.getPlacesByStringCriteria("description", search);
    }

    @Override
    public List<Place> getPlacesByPhoneNumber(String search) {
        return placeDao.getPlacesByStringCriteria("phone_number", search);
    }

    @Override
    public List<Place> getPlacesByEmail(String search) {
        return placeDao.getPlacesByStringCriteria("email", search);
    }

    @Override
    public List<Place> getPlacesByAddress(String search) {
        return placeDao.getPlacesByStringCriteria("address", search);
    }

    @Override
    public List<Place> getPlacesByCity(String search) {
        return placeDao.getPlacesByStringCriteria("city", search);
    }

    @Override
    public List<Place> getPlacesByCountry(String search) {
        return placeDao.getPlacesByStringCriteria("country", search);
    }

    @Override
    public List<Place> getPlacesByRating(int search) {
        return placeDao.getPlacesByRating(search);
    }
}
