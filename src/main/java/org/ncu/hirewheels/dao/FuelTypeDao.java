package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeDao extends JpaRepository<FuelType, Integer> {
    
}
