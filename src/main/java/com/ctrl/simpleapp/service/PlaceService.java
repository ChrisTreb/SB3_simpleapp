package com.ctrl.simpleapp.service;

import com.ctrl.simpleapp.records.Place;

import java.util.List;

public interface PlaceService {

    Place savePlace(Place place);

    List<Place> fetchPlaceList();

    Place updatePlace(Place place, Long placeId);

    void deletePlaceById(Long placeId);
}
