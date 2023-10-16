package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.entities.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryDao extends JpaRepository<VehicleCategory, Integer> {
    
}
