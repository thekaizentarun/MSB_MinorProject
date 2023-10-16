package org.ncu.hirewheels.controller;

import java.util.List;

import org.ncu.hirewheels.entities.City;
import org.ncu.hirewheels.entities.ResponseCity;
import org.ncu.hirewheels.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hirewheel/v1")
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(value = "/city")
    public ResponseEntity<ResponseCity> addCity(@RequestBody City city){
        return new ResponseEntity<ResponseCity>(cityService.addCity(city), HttpStatus.CREATED);
    }
    @GetMapping(value = "/city")
    public ResponseEntity<List<ResponseCity>> getAllCities(){
        return new ResponseEntity<List<ResponseCity>>(cityService.getAllCities(), HttpStatus.ACCEPTED);
    }
}
