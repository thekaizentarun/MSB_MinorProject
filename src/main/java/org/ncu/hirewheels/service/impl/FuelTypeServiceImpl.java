package org.ncu.hirewheels.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ncu.hirewheels.dao.FuelTypeDao;
import org.ncu.hirewheels.entities.FuelType;
import org.ncu.hirewheels.entities.ResponseFuelType;
import org.ncu.hirewheels.service.FuelTypeService;
import org.springframework.stereotype.Service;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {
    private FuelTypeDao fuelTypeDao;

    public FuelTypeServiceImpl(FuelTypeDao fuelTypeDao) {
        this.fuelTypeDao = fuelTypeDao;
    }

    @Override
    public ResponseFuelType addFuelType(FuelType fuelType) {
        // TODO Auto-generated method stub
        FuelType newFuelType = fuelTypeDao.save(fuelType);
        ResponseFuelType responseFuelType = new ResponseFuelType();
        responseFuelType.setFuelType(newFuelType.getFuelType());
        responseFuelType.setFuelTypeId(newFuelType.getFuelTypeId());
        return responseFuelType;
    }

    @Override
    public List<ResponseFuelType> getAllFuelTypes() {
        // TODO Auto-generated method stub
        List<FuelType> fuelTypes = fuelTypeDao.findAll();
        List<ResponseFuelType> responseFuelTypes = new ArrayList<>();
        for (FuelType newFuelType : fuelTypes) {
            ResponseFuelType responseFuelType = new ResponseFuelType();
            responseFuelType.setFuelType(newFuelType.getFuelType());
            responseFuelType.setFuelTypeId(newFuelType.getFuelTypeId());
            responseFuelTypes.add(responseFuelType);
        }

        return responseFuelTypes;
    }

}
