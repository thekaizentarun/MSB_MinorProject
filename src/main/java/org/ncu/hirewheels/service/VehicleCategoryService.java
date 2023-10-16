package org.ncu.hirewheels.service;

import java.util.List;

import org.ncu.hirewheels.entities.ResponseVehicleCategory;
import org.ncu.hirewheels.entities.VehicleCategory;

public interface VehicleCategoryService {
    public ResponseVehicleCategory addVehicleCategory(VehicleCategory vehicleCategory);
    public List<ResponseVehicleCategory> getAllVehicleCategories();
}
