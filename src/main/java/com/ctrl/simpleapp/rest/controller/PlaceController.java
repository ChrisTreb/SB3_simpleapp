package com.ctrl.simpleapp.rest.controller;

import com.ctrl.simpleapp.records.Place;
import com.ctrl.simpleapp.service.PlaceService;
import io.swagger.v3.oas.annotations.Operation;
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

    @PostMapping("/save-place")
    public Place savePlace(@Valid @RequestBody Place place) {
        return placeService.savePlace(place);
    }

    @GetMapping("/place")
    public List<Place> fetchPlaceList() {
        return placeService.fetchPlaceList();
    }

    @PutMapping("/put-place/{id}")
    public Place updatePlace(@RequestBody Place place, @PathVariable("id") Long placeId) {
        return placeService.updatePlace(place, placeId);
    }

    @DeleteMapping("/delete-place/{id}")
    public String deletePlaceById(@PathVariable("id") Long placeId) {
        placeService.deletePlaceById(placeId);
        return "Place deleted successfully - id : " + placeId;
    }

    @GetMapping("/place/{id}")
    public Place getPlacesById(@PathVariable("id") Long placeId) {
        return placeService.getPlaceById(placeId);
    }

    @GetMapping("/place/name/{search}")
    public List<Place> getPlaceByName(@PathVariable("search") String search) {
        return placeService.getPlacesByName(search);
    }

    @GetMapping("/place/email/{search}")
    public List<Place> getPlacesByEmail(@PathVariable("search") String search) {
        return placeService.getPlacesByEmail(search);
    }

    @GetMapping("/place/address/{search}")
    public List<Place> getPlacesByAddress(@PathVariable("search") String search) {
        return placeService.getPlacesByAddress(search);
    }

    @GetMapping("/place/city/{search}")
    public List<Place> getPlacesByCity(@PathVariable("search") String search) {
        return placeService.getPlacesByCity(search);
    }

    @GetMapping("/place/country/{search}")
    public List<Place> getPlacesByCountry(@PathVariable("search") String search) {
        return placeService.getPlacesByCountry(search);
    }

    @GetMapping("/place/description/{search}")
    public List<Place> getPlacesByDescription(@PathVariable("search") String search) {
        return placeService.getPlacesByDescription(search);
    }

    @GetMapping("/place/rating/{search}")
    public List<Place> getPlacesByRating(@PathVariable("search") int search) {
        return placeService.getPlacesByRating(search);
    }

    @Operation(summary = "Get all unique countries", description = "Returns a list of string : country")
    @GetMapping("/place/countries")
    public List<String> getCountries() {
        return placeService.getCountries();
    }

    @Operation(summary = "Get all unique cities by selected country", description = "Returns a list of string : city")
    @GetMapping("/place/country/cities/{search}")
    public List<String> getCitiesByCountry(@PathVariable("search") String search) {
        return placeService.getCitiesByCountry(search);
    }

    @Operation(summary = "Get places by id between first and last", description = "Returns a list of places, default values : id = 1, limit 9")
    @GetMapping("/place/id")
    public List<Place> getPlacesByIdRange(@RequestParam(defaultValue = "1") Long firstId,
                                           @RequestParam(defaultValue = "9") Long limit) {
        return placeService.getPlacesByIdRange(firstId, limit);
    }
}
