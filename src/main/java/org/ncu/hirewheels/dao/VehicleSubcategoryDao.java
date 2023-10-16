package org.ncu.hirewheels.dao;

import java.util.List;

import org.ncu.hirewheels.entities.VehicleSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleSubcategoryDao extends JpaRepository<VehicleSubcategory, Integer>{
    // @Query(value = "SELECT v FROM VehicleSubcategory v WHERE v.vehicle_category_id  = :vehicle_category_id")
    // public VehicleSubcategory findCategoryWithSubcategoryId(@Param("vehicle_category_id") String vehicle_category_id);
}
