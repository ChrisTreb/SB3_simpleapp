package com.ctrl.simpleapp.rest.controller;

import com.ctrl.simpleapp.records.Place;
import com.ctrl.simpleapp.service.PlaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class PlaceController {

    @Autowired
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping("/save-places")
    public Place savePlace(@Valid @RequestBody Place place) {
        return placeService.savePlace(place);
    }

    @GetMapping("/places")
    public List<Place> fetchPlaceList() {
        return placeService.fetchPlaceList();
    }

    @PutMapping("/put-places/{id}")
    public Place updatePlace(@RequestBody Place place, @PathVariable("id") Long placeId) {
        return placeService.updatePlace(place, placeId);
    }

    @DeleteMapping("/delete-places/{id}")
    public String deletePlaceById(@PathVariable("id") Long placeId) {
        placeService.deletePlaceById(placeId);
        return "Place deleted successfully - id : " + placeId;
    }
}
