package org.ncu.hirewheels.service;


import java.util.List;

import org.ncu.hirewheels.entities.RequestBooking;
import org.ncu.hirewheels.entities.ResponseBooking;
import org.ncu.hirewheels.exceptions.InsufficientBalanceException;
import org.ncu.hirewheels.exceptions.LocationNotFoundException;
import org.ncu.hirewheels.exceptions.UnauthorizedUserException;
import org.ncu.hirewheels.exceptions.UserNotRegisteredException;

public interface BookingService {
    public ResponseBooking addBooking(RequestBooking bookingUser) 
    throws InsufficientBalanceException,  UserNotRegisteredException,UnauthorizedUserException, LocationNotFoundException;
    public List<ResponseBooking> getAllBooking();
}
