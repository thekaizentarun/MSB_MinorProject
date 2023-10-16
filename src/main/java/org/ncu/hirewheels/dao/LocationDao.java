package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDao extends JpaRepository<Location, Integer> {
    
}
