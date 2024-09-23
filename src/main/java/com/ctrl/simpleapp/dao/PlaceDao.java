package com.ctrl.simpleapp.dao;

import com.ctrl.simpleapp.records.Place;

import java.util.Date;
import java.util.List;

public interface PlaceDao {

    List<Place> getPlacesByStringCriteria(String criteria, String search);

    List<Place> getPlacesByDateCriteria(Date criteria, String search);

    List<Place> getPlaceById(Long id);

    List<Place> getPlacesByRating(int rating);
}
