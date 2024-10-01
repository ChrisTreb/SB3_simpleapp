package com.ctrl.simpleapp.service;

import com.ctrl.simpleapp.records.Place;

import java.util.List;

public interface PlaceService {

    Place savePlace(Place place);

    List<Place> fetchPlaceList();

    Place updatePlace(Place place, Long placeId);

    void deletePlaceById(Long placeId);

    Place getPlaceById(Long id);

    List<Place> getPlacesByName(String search);

    List<Place> getPlacesByDescription(String search);

    List<Place> getPlacesByPhoneNumber(String search);

    List<Place> getPlacesByEmail(String search);

    List<Place> getPlacesByAddress(String search);

    List<Place> getPlacesByCity(String search);

    List<Place> getPlacesByCountry(String search);

    List<Place> getPlacesByRating(int search);

    List<String> getCountries();
}
