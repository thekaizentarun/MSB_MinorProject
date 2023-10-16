package org.ncu.hirewheels.dao;

import java.util.List;

import org.ncu.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleDao extends JpaRepository<Vehicle, Integer>{
    // @Query(value = "SELECT v FROM Vehicle v WHERE v.vehicle_subcategory_id = :vehicle_subcategory_id")
    // public List<Vehicle> findAllVehicleWithCategoryId(@Param("vehicle_subcategory_id") String vehicle_subcategory_id);
}
