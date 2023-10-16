package org.ncu.hirewheels.controller;

import java.util.List;

import org.ncu.hirewheels.entities.ResponseVehicleCategory;
import org.ncu.hirewheels.entities.VehicleCategory;
import org.ncu.hirewheels.service.VehicleCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hirewheel/v1")
public class VehicleCategoryController {
    private VehicleCategoryService vehicleCategoryService;

    public VehicleCategoryController(VehicleCategoryService vehicleCategoryService) {
        this.vehicleCategoryService = vehicleCategoryService;
    }

    @PostMapping(value = "/vehicleCategory")
    public ResponseEntity<ResponseVehicleCategory> addVehicleCategory(@RequestBody VehicleCategory vehicleCategory){
        return new ResponseEntity<>(vehicleCategoryService.addVehicleCategory(vehicleCategory), HttpStatus.CREATED);
    }
    @GetMapping(value = "/vehicleCategory")
    public ResponseEntity<List<ResponseVehicleCategory>> getAllVehicleCategories(){
        return new ResponseEntity<>(vehicleCategoryService.getAllVehicleCategories(), HttpStatus.ACCEPTED);
    }
}
