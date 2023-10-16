package org.ncu.hirewheels.service.impl;

import java.util.Optional;

import org.ncu.hirewheels.dao.FuelTypeDao;
import org.ncu.hirewheels.dao.LocationDao;
import org.ncu.hirewheels.dao.UsersDao;
import org.ncu.hirewheels.dao.VehicleDao;
import org.ncu.hirewheels.dao.VehicleSubcategoryDao;
import org.ncu.hirewheels.entities.FuelType;
import org.ncu.hirewheels.entities.Location;
import org.ncu.hirewheels.entities.RequestVehicle;
import org.ncu.hirewheels.entities.ResponseVehicleWithPricePerDay;
import org.ncu.hirewheels.entities.Role;
import org.ncu.hirewheels.entities.UserLogin;
import org.ncu.hirewheels.entities.UserVehicle;
import org.ncu.hirewheels.entities.Users;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.VehicleSubcategory;
import org.ncu.hirewheels.exceptions.NoSuchFuelTypeExistException;
import org.ncu.hirewheels.exceptions.NoSuchLocationExistException;
import org.ncu.hirewheels.exceptions.NoSuchSubcategoryExistException;
import org.ncu.hirewheels.exceptions.NoSuchVehicleExistException;
import org.ncu.hirewheels.exceptions.UnauthorizedUserException;
import org.ncu.hirewheels.exceptions.UserNotAdminException;
import org.ncu.hirewheels.exceptions.UserNotRegisteredException;
import org.ncu.hirewheels.exceptions.VehicleNotFoundException;
import org.ncu.hirewheels.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private VehicleDao vehicleDao;
    private UsersDao userDao;
    private VehicleSubcategoryDao vehicleSubcategoryDao;
    private FuelTypeDao fuelTypeDao;
    private LocationDao locationDao;

    public AdminServiceImpl(VehicleDao vehicleDao, UsersDao userDao, VehicleSubcategoryDao vehicleSubcategoryDao,
            FuelTypeDao fuelTypeDao, LocationDao locationDao) {
        this.vehicleDao = vehicleDao;
        this.userDao = userDao;
        this.vehicleSubcategoryDao = vehicleSubcategoryDao;
        this.fuelTypeDao = fuelTypeDao;
        this.locationDao = locationDao;
    }

    @Override
    public ResponseVehicleWithPricePerDay registerVehicle(UserVehicle userVehicle)
            throws UnauthorizedUserException, UserNotAdminException, UserNotRegisteredException {
        // TODO Auto-generated method stub
        System.out.println("Starting");

        // Vehicle vehicle = userVehicle.getVehicle();
        UserLogin userLogin = userVehicle.getUserLogin();

        String email = userLogin.getEmail();
        String password = userLogin.getPassword();

        Users user = userDao.findEmailIdUsers(email);
        if (user == null) {
            throw new UserNotRegisteredException("User has No Account!");
        }

        user = userDao.findEmailAndPasswordUsers(email, password);
        if (user == null) {
            throw new UnauthorizedUserException();
        }

        // if(user.getRole())
        Role role = user.getRole();

        if (!role.getRoleName().equals("ADMIN")) {
            throw new UserNotAdminException();
        }
        RequestVehicle requestVehicle = userVehicle.getRequestVehicle();
        System.out.println(requestVehicle.getVehicleImageUrl() + " is the Image URL");
        Optional<VehicleSubcategory> subcategoryChecking = vehicleSubcategoryDao
                .findById(requestVehicle.getVehicleSubCategoryId());

        if (!subcategoryChecking.isPresent()) {
            throw new NoSuchSubcategoryExistException();
        }

        Optional<FuelType> fuelTypeChecking = fuelTypeDao.findById(requestVehicle.getFuelTypeId());

        if (!fuelTypeChecking.isPresent()) {
            throw new NoSuchFuelTypeExistException();
        }

        Optional<Location> locationChecking = locationDao.findById(requestVehicle.getLocationId());

        if (!locationChecking.isPresent()) {
            throw new NoSuchLocationExistException();
        }

        Vehicle newVehicle = new Vehicle();

        newVehicle.setVehicleSubcategory(subcategoryChecking.get());
        newVehicle.setFuelType(fuelTypeChecking.get());
        newVehicle.setLocation(locationChecking.get());
        newVehicle.setAvailabilityStaus(requestVehicle.getAvailabilityStatus());
        newVehicle.setColor(requestVehicle.getColor());
        newVehicle.setVehicleImageUrl(requestVehicle.getVehicleImageUrl());
        newVehicle.setVehicleModel(requestVehicle.getVehicleModel());
        newVehicle.setVehicleNumber(requestVehicle.getVehicleNumber());

        Vehicle finalVehicle = vehicleDao.save(newVehicle);

        System.out.println("The Vehicle Entity is ");

        ResponseVehicleWithPricePerDay response = new ResponseVehicleWithPricePerDay();

        response.setAvailabilityStaus(finalVehicle.getAvailabilityStaus());
        response.setColor(finalVehicle.getColor());
        response.setFuelTypeId(finalVehicle.getFuelType().getFuelTypeId());
        response.setLocationId(finalVehicle.getLocation().getLocationId());
        response.setPricePerDay(finalVehicle.getVehicleSubcategory().getPricePerDay());
        response.setVehicleId(finalVehicle.getVehicleId());
        response.setVehicleImageUrl(finalVehicle.getVehicleImageUrl());
        response.setVehicleModel(finalVehicle.getVehicleModel());
        response.setVehicleNumber(finalVehicle.getVehicleNumber());
        response.setVehicleSubCategoryId(finalVehicle.getVehicleSubcategory().getVehicleSubcategoryId());

        // // return vehicleDao.save(vehicle);
        // return vehicleDao.save(vehicle);
        // return newVehicle;
        System.out.println("Ending");
        return response;
    }

    @Override
    public ResponseVehicleWithPricePerDay changeAvailability(UserVehicle userVehicle, Integer id) throws VehicleNotFoundException,
            UnauthorizedUserException, UserNotAdminException, UserNotRegisteredException {
        System.out.println("Printing"+ id);

        
        // TODO Auto-generated method stub
        // Vehicle vehicle = userVehicle.getVehicle();
        UserLogin userLogin = userVehicle.getUserLogin();

        String email = userLogin.getEmail();
        String password = userLogin.getPassword();

        Users user = userDao.findEmailIdUsers(email);
        if (user == null) {
        throw new UserNotRegisteredException();
        }

        user = userDao.findEmailAndPasswordUsers(email, password);
        if (user == null) {
        throw new UnauthorizedUserException();
        }

        // if(user.getRole())
        Role role = user.getRole();

        if (!role.getRoleName().equals("ADMIN")) {
            throw new UserNotAdminException();
        }

        Optional<Vehicle> newVehicle = vehicleDao.findById(id);

        if(!newVehicle.isPresent()){
            throw new NoSuchVehicleExistException();
        }

        Vehicle updateVehicle = newVehicle.get();
        int updateAvailabilityStatus = userVehicle.getRequestVehicle().getAvailabilityStatus();
        System.out.println("Vehicle Availability Status is "+updateVehicle.getAvailabilityStaus());
        System.out.println("The Availablity Status Provided By the User "+updateAvailabilityStatus);
        updateVehicle.setAvailabilityStaus(updateAvailabilityStatus);

        Vehicle finalVehicle = vehicleDao.save(updateVehicle);

        ResponseVehicleWithPricePerDay response = new ResponseVehicleWithPricePerDay();

        response.setAvailabilityStaus(finalVehicle.getAvailabilityStaus());
        response.setColor(finalVehicle.getColor());
        response.setFuelTypeId(finalVehicle.getFuelType().getFuelTypeId());
        response.setLocationId(finalVehicle.getLocation().getLocationId());
        response.setPricePerDay(finalVehicle.getVehicleSubcategory().getPricePerDay());
        response.setVehicleId(finalVehicle.getVehicleId());
        response.setVehicleImageUrl(finalVehicle.getVehicleImageUrl());
        response.setVehicleModel(finalVehicle.getVehicleModel());
        response.setVehicleNumber(finalVehicle.getVehicleNumber());
        response.setVehicleSubCategoryId(finalVehicle.getVehicleSubcategory().getVehicleSubcategoryId());
        // .orElseThrow(() -> new VehicleNotFoundException());

        // newVehicle.setAvailabilityStaus(vehicle.getAvailabilityStaus());
        // newVehicle.setVehicleId(vehicle.getVehicleId());
        // return vehicleDao.save(newVehicle);
        // // throw new VehicleNotFoundException();
        // // return false;
        return response;
    }

}
