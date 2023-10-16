package org.ncu.hirewheels.controller;

import java.util.ArrayList;
import java.util.List;

import org.ncu.hirewheels.entities.ResponseVehicle;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hirewheel/v1")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping(value = "/sayVehicle")
    public String sayHello() {
        return "Hello To All From Vehicle Controller";
    }
    @GetMapping(value ="/vehicles")
    public ResponseEntity<List<ResponseVehicle>> getVehicles(){
        System.out.println("Vehicles is My");
        System.out.println();
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        List<ResponseVehicle> newVehicle = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            ResponseVehicle tempVehicle = new ResponseVehicle();
            tempVehicle.setVehicleId(vehicle.getVehicleId());
            // "vehicleModel": null,
        // "vehicleNumber": null,
        // "color": null,
        // "availabilityStaus": 1,
        // "vehicleImageUrl": null,
            tempVehicle.setVehicleModel(vehicle.getVehicleModel());
            tempVehicle.setVehicleNumber(vehicle.getVehicleNumber());
            tempVehicle.setColor(vehicle.getColor());
            tempVehicle.setAvailabilityStaus(vehicle.getAvailabilityStaus());
            tempVehicle.setVehicleImageUrl(vehicle.getVehicleImageUrl());
            tempVehicle.setFuelTypeId(vehicle.getFuelType().getFuelTypeId());
            tempVehicle.setVehicleSubCategoryId(vehicle.getVehicleSubcategory().getVehicleSubcategoryId());
            tempVehicle.setLocationId(vehicle.getLocation().getLocationId());
            newVehicle.add(tempVehicle);
        }
        return new ResponseEntity<List<ResponseVehicle>>(newVehicle, HttpStatus.OK);
    }
}
