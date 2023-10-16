package org.ncu.hirewheels.service;

import java.util.List;

import org.ncu.hirewheels.entities.ResponseVehicleSubcategory;
import org.ncu.hirewheels.exceptions.NoSuchVehicleCategoryExistException;


public interface VehicleSubcategoryService {
    public ResponseVehicleSubcategory addVehicleSubcategory(ResponseVehicleSubcategory requestVehicleSubcategory) throws NoSuchVehicleCategoryExistException;
    public List<ResponseVehicleSubcategory> getAllVehicleSubcategories();
}
