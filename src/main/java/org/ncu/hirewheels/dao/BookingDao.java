package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao  extends JpaRepository<Booking, Integer>{
    
}
