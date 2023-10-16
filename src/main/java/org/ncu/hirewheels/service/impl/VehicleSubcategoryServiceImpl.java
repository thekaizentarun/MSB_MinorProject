package org.ncu.hirewheels.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.ncu.hirewheels.dao.VehicleCategoryDao;
import org.ncu.hirewheels.dao.VehicleSubcategoryDao;
import org.ncu.hirewheels.entities.ResponseVehicleSubcategory;
import org.ncu.hirewheels.entities.VehicleCategory;
import org.ncu.hirewheels.entities.VehicleSubcategory;
import org.ncu.hirewheels.exceptions.NoSuchVehicleCategoryExistException;
import org.ncu.hirewheels.service.VehicleSubcategoryService;
import org.springframework.stereotype.Service;

@Service
public class VehicleSubcategoryServiceImpl implements VehicleSubcategoryService {
    private VehicleSubcategoryDao vehicleSubcategoryDao;
    private VehicleCategoryDao vehicleCategoryDao;

    public VehicleSubcategoryServiceImpl(VehicleSubcategoryDao vehicleSubcategoryDao,
            VehicleCategoryDao vehicleCategoryDao) {
        this.vehicleSubcategoryDao = vehicleSubcategoryDao;
        this.vehicleCategoryDao = vehicleCategoryDao;
    }

    @Override
    public ResponseVehicleSubcategory addVehicleSubcategory(ResponseVehicleSubcategory requestVehicleSubcategory) throws NoSuchVehicleCategoryExistException{
        // TODO Auto-generated method stub
        String vehicleSubcategoryName = requestVehicleSubcategory.getVehicleSubcategoryName();
        float pricePerDay = requestVehicleSubcategory.getPricePerDay();
        int vehicleCategoryId = requestVehicleSubcategory.getVehicleCategoryId();
        Optional<VehicleCategory> vehicleCategory = vehicleCategoryDao.findById(vehicleCategoryId);

        if(!vehicleCategory.isPresent()){
            throw new NoSuchVehicleCategoryExistException();
        }
        VehicleSubcategory vehicleSubcategory = new VehicleSubcategory();
        vehicleSubcategory.setPricePerDay(pricePerDay);
        vehicleSubcategory.setVehicleSubcategoryName(vehicleSubcategoryName);
        vehicleSubcategory.setVehicleCategory(vehicleCategory.get());
        VehicleSubcategory finalVehicleSubcategory = vehicleSubcategoryDao.save(vehicleSubcategory);

        ResponseVehicleSubcategory responseVehicleSubcategory = new ResponseVehicleSubcategory();

        responseVehicleSubcategory.setPricePerDay(pricePerDay);
        responseVehicleSubcategory.setVehicleCategoryId(vehicleCategoryId);
        responseVehicleSubcategory.setVehicleSubcategoryId(finalVehicleSubcategory.getVehicleSubcategoryId());
        responseVehicleSubcategory.setVehicleSubcategoryName(vehicleSubcategoryName);

        return responseVehicleSubcategory;
    }

    @Override
    public List<ResponseVehicleSubcategory> getAllVehicleSubcategories() {
        // TODO Auto-generated method stub
        List<ResponseVehicleSubcategory> responseVehicleSubcategories = new ArrayList<>();
        List<VehicleSubcategory> vehicleSubcategories = vehicleSubcategoryDao.findAll();
        for (VehicleSubcategory vehicleSubcategory : vehicleSubcategories) {
            ResponseVehicleSubcategory responseVehicleSubcategory = new ResponseVehicleSubcategory();

            responseVehicleSubcategory.setPricePerDay(vehicleSubcategory.getPricePerDay());
            responseVehicleSubcategory
                    .setVehicleCategoryId(vehicleSubcategory.getVehicleCategory().getVehicleCategoryId());
            responseVehicleSubcategory.setVehicleSubcategoryId(vehicleSubcategory.getVehicleSubcategoryId());
            responseVehicleSubcategory.setVehicleSubcategoryName(vehicleSubcategory.getVehicleSubcategoryName());
            responseVehicleSubcategories.add(responseVehicleSubcategory);
        }
        return responseVehicleSubcategories;
    }

}
