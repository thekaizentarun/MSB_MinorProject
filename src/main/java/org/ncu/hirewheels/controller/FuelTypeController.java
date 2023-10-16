package org.ncu.hirewheels.controller;

import java.util.List;

import org.ncu.hirewheels.entities.FuelType;
import org.ncu.hirewheels.entities.ResponseFuelType;
import org.ncu.hirewheels.service.FuelTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hirewheel/v1")
public class FuelTypeController {
    private FuelTypeService fuelTypeService;

    public FuelTypeController(FuelTypeService fuelTypeService) {
        this.fuelTypeService = fuelTypeService;
    }

    @PostMapping(value = "/fuelType")
    public ResponseEntity<ResponseFuelType> addFuelType(@RequestBody FuelType fuelType){
        return new ResponseEntity<ResponseFuelType>(fuelTypeService.addFuelType(fuelType), HttpStatus.CREATED);
    }
    @GetMapping(value = "/fuelType")
    public ResponseEntity<List<ResponseFuelType>> getAllFuelType(){
        return new ResponseEntity<List<ResponseFuelType>>(fuelTypeService.getAllFuelTypes(), HttpStatus.ACCEPTED);
    }
}
