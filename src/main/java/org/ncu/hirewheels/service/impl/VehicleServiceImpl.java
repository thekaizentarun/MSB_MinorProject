package org.ncu.hirewheels.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.ncu.hirewheels.dao.BookingDao;
import org.ncu.hirewheels.dao.VehicleDao;
import org.ncu.hirewheels.dao.VehicleSubcategoryDao;
import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.VehicleCategory;
import org.ncu.hirewheels.entities.VehicleCategoryBookingDetails;
import org.ncu.hirewheels.entities.VehicleSubcategory;
import org.ncu.hirewheels.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleDao vehicleDao;
    private BookingDao bookingDao;
    private VehicleSubcategoryDao vehicleSubcategoryDao;
    

    public VehicleServiceImpl(VehicleDao vehicleDao, BookingDao bookingDao, VehicleSubcategoryDao vehicleSubcategoryDao) {
        this.vehicleDao = vehicleDao;
        this.bookingDao = bookingDao;
        this.vehicleSubcategoryDao = vehicleSubcategoryDao;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        // TODO Auto-generated method stub
        return vehicleDao.findAll();
    }

    @Override
    public List<Vehicle> getAvailableVehicles(VehicleCategoryBookingDetails vehicleCategoryBookingDetails) {
        // TODO Auto-generated method stub
        VehicleCategory vehicleCategory = vehicleCategoryBookingDetails.getVehicleCategory();
        Booking bookingDetails = vehicleCategoryBookingDetails.getBooking();

        int categoryId = vehicleCategory.getVehicleCategoryId();
        int locationId = bookingDetails.getLocation().getLocationId();
        LocalDateTime pickUpDate = bookingDetails.getPickupDate();
        LocalDateTime dropDate = bookingDetails.getDropoffDate();

        // Get Subcategory using Categry
        // VehicleSubcategory vehicleSubcategory = 
        
        // Finding Subcategories firstly
        // List<VehicleSubcategory> vehicleSubcategories = vehicleSubcategoryDao.findAllIVehicleWithSubcategoryId(categoryId);
        
        // ALL Vehicle
        List<Vehicle> vehicles = vehicleDao.findAll();

        // for (VehicleSubcategory vehicleSubcategory : vehicleSubcategories) {
        //     vehicles.addAll(vehicleDao.findAllVehicleWithCategoryId(vehicleSubcategory.getVehicleCategory().getVehicleCategoryId()));
        // }
        
        List<VehicleSubcategory> vehicleSubcategories = vehicleSubcategoryDao.findAll();
        
        
        List<Vehicle> vehiclesOnlyCategory = new ArrayList<>();



        List<Vehicle> vehicleList = new ArrayList<>();

        



        // Condition Applied HEre that vehicleid is categoryId
        List<Booking> bookingList = bookingDao.findAll();
        // 
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getLocation().getLocationId() == locationId && vehicle.getAvailabilityStaus() == 1) {
                for (VehicleSubcategory vehicleSubcategory : vehicleSubcategories) {
                    if(vehicleSubcategory.getVehicleCategory().getVehicleCategoryId() == categoryId){
                        for (Booking booking : bookingList) {
                            if (booking.getPickupDate().compareTo(pickUpDate) >= 0
                                    || booking.getDropoffDate().compareTo(dropDate) <= 0) {
                                vehicleList.add(vehicle);
                            }
                        }
                    }
                }
            }
        }
        return vehicleList;
        // return null;
    }

}
