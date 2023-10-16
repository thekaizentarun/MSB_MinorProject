package org.ncu.hirewheels.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ncu.hirewheels.dao.VehicleCategoryDao;
import org.ncu.hirewheels.entities.ResponseVehicleCategory;
import org.ncu.hirewheels.entities.VehicleCategory;
import org.ncu.hirewheels.service.VehicleCategoryService;
import org.springframework.stereotype.Service;

@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService {
    private VehicleCategoryDao vehicleCategoryDao;

    public VehicleCategoryServiceImpl(VehicleCategoryDao vehicleCategoryDao) {
        this.vehicleCategoryDao = vehicleCategoryDao;
    }

    @Override
    public ResponseVehicleCategory addVehicleCategory(VehicleCategory vehicleCategory) {
        // TODO Auto-generated method stub
        VehicleCategory newVehicle = vehicleCategoryDao.save(vehicleCategory);
        ResponseVehicleCategory responseVehicleCategory = new ResponseVehicleCategory();
        responseVehicleCategory.setVehicleCategoryId(newVehicle.getVehicleCategoryId());
        responseVehicleCategory.setVehicleCategoryName(newVehicle.getVehicleCategoryName());
        return responseVehicleCategory;
    }

    @Override
    public List<ResponseVehicleCategory> getAllVehicleCategories() {
        // TODO Auto-generated method stub
        List<VehicleCategory> vehicleCategories = vehicleCategoryDao.findAll();
        List<ResponseVehicleCategory> responseVehicleCategories = new ArrayList<>();
        
        for (VehicleCategory newVehicle : vehicleCategories) {
            ResponseVehicleCategory responseVehicleCategory = new ResponseVehicleCategory();
            responseVehicleCategory.setVehicleCategoryId(newVehicle.getVehicleCategoryId());
            responseVehicleCategory.setVehicleCategoryName(newVehicle.getVehicleCategoryName());
            responseVehicleCategories.add(responseVehicleCategory);
        }
        return responseVehicleCategories;
    }

}
