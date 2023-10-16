package org.ncu.hirewheels.controller;

import java.util.List;

import org.ncu.hirewheels.entities.ResponseLocation;
import org.ncu.hirewheels.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hirewheel/v1")
public class LocationController {
    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @PostMapping(value = "/location")
    public ResponseEntity<ResponseLocation> addLocation(@RequestBody ResponseLocation requestLocation){
        return new ResponseEntity<ResponseLocation>(locationService.addLocation(requestLocation), HttpStatus.CREATED);
    }
    @GetMapping(value = "/location")
    public ResponseEntity<List<ResponseLocation>> getAllLocations(){
        return new ResponseEntity<List<ResponseLocation>>(locationService.getAllLocations(), HttpStatus.ACCEPTED);
    }
}
