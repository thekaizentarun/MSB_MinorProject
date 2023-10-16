package org.ncu.hirewheels.service;

import java.util.List;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.VehicleCategoryBookingDetails;

public interface VehicleService {
    public List<Vehicle> getAllVehicles();
    public List<Vehicle>  getAvailableVehicles(VehicleCategoryBookingDetails vehicleCategoryBookingDetails);
}
