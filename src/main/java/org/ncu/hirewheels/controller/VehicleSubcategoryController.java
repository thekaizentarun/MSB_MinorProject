package org.ncu.hirewheels.controller;

import java.util.List;

import org.ncu.hirewheels.entities.ResponseVehicleSubcategory;
import org.ncu.hirewheels.entities.VehicleSubcategory;
import org.ncu.hirewheels.service.VehicleSubcategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hirewheel/v1")
public class VehicleSubcategoryController {
    private VehicleSubcategoryService vehicleSubcategoryService;

    public VehicleSubcategoryController(VehicleSubcategoryService vehicleSubcategoryService) {
        this.vehicleSubcategoryService = vehicleSubcategoryService;
    }

    @PostMapping(value = "/vehicleSubcategory")
    public ResponseEntity<ResponseVehicleSubcategory> addVehicleSubcategory(@RequestBody ResponseVehicleSubcategory requestVehicleSubcategory){
        return new ResponseEntity<ResponseVehicleSubcategory>(vehicleSubcategoryService.addVehicleSubcategory(requestVehicleSubcategory), HttpStatus.CREATED);
    }
    @GetMapping(value = "/vehicleSubcategory")
    public ResponseEntity<List<ResponseVehicleSubcategory>> getAllVehicleSubcategories(){
        return new ResponseEntity<List<ResponseVehicleSubcategory>>(vehicleSubcategoryService.getAllVehicleSubcategories(), HttpStatus.ACCEPTED);
    }
}
