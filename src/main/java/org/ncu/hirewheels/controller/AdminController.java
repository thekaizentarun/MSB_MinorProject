package org.ncu.hirewheels.controller;



import org.ncu.hirewheels.entities.ResponseVehicleWithPricePerDay;
import org.ncu.hirewheels.entities.UserVehicle;
import org.ncu.hirewheels.exceptions.UnauthorizedUserException;
import org.ncu.hirewheels.exceptions.UserNotAdminException;
import org.ncu.hirewheels.exceptions.UserNotRegisteredException;
import org.ncu.hirewheels.exceptions.VehicleNotFoundException;
import org.ncu.hirewheels.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hirewheel/v1")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping(value = "/sayAdmin")
    public String sayHello() {
        return "Hello To All From Admin Controller";
    }
    @PostMapping(value ="/vehicles")
    public ResponseEntity<ResponseVehicleWithPricePerDay> addVehicle(@RequestBody UserVehicle userVehicle) throws UnauthorizedUserException, UserNotAdminException, UserNotRegisteredException{
        return new ResponseEntity<ResponseVehicleWithPricePerDay>(adminService.registerVehicle(userVehicle), HttpStatus.CREATED);
    }
    @PutMapping(value = "/vehicles/{id}")
    public ResponseEntity<ResponseVehicleWithPricePerDay> updateVehicle(@PathVariable Integer id, @RequestBody UserVehicle userVehicle) throws UserNotRegisteredException, VehicleNotFoundException, UnauthorizedUserException, UserNotAdminException{
        return new ResponseEntity<ResponseVehicleWithPricePerDay>(adminService.changeAvailability(userVehicle, id), HttpStatus.ACCEPTED);
    }

}
