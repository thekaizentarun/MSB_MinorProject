package org.ncu.hirewheels.service;

import java.util.List;

import org.ncu.hirewheels.entities.FuelType;
import org.ncu.hirewheels.entities.ResponseFuelType;


public interface FuelTypeService {
    public ResponseFuelType addFuelType(FuelType fuelType);
    public List<ResponseFuelType> getAllFuelTypes();
}
