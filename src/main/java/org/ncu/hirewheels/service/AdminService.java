package org.ncu.hirewheels.service;

import org.ncu.hirewheels.entities.ResponseVehicleWithPricePerDay;
import org.ncu.hirewheels.entities.UserVehicle;
import org.ncu.hirewheels.exceptions.UnauthorizedUserException;
import org.ncu.hirewheels.exceptions.UserNotAdminException;
import org.ncu.hirewheels.exceptions.UserNotRegisteredException;
import org.ncu.hirewheels.exceptions.VehicleNotFoundException;

public interface AdminService {
    public ResponseVehicleWithPricePerDay registerVehicle(UserVehicle userVehicle) 
    throws UnauthorizedUserException, UserNotAdminException, UserNotRegisteredException;
    public ResponseVehicleWithPricePerDay changeAvailability(UserVehicle userVehicle, Integer id) 
    throws VehicleNotFoundException, UnauthorizedUserException, UserNotAdminException, UserNotRegisteredException;
}
