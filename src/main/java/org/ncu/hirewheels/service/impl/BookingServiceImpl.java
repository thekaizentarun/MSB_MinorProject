package org.ncu.hirewheels.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.ncu.hirewheels.dao.BookingDao;
import org.ncu.hirewheels.dao.LocationDao;
import org.ncu.hirewheels.dao.UsersDao;
import org.ncu.hirewheels.dao.VehicleDao;
import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.Location;
import org.ncu.hirewheels.entities.RequestBooking;
import org.ncu.hirewheels.entities.ResponseBooking;
import org.ncu.hirewheels.entities.Users;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.exceptions.InsufficientBalanceException;
import org.ncu.hirewheels.exceptions.LocationNotFoundException;
import org.ncu.hirewheels.exceptions.UnauthorizedUserException;
import org.ncu.hirewheels.exceptions.UserNotRegisteredException;
import org.ncu.hirewheels.exceptions.VehicleNotFoundException;
import org.ncu.hirewheels.service.BookingService;
import org.springframework.stereotype.Service;
@Service
public class BookingServiceImpl implements BookingService{
    private UsersDao userDao;
    private BookingDao bookingDao;
    private VehicleDao vehicleDao;
    private LocationDao locationDao;


    public BookingServiceImpl(UsersDao userDao, BookingDao bookingDao, VehicleDao vehicleDao, LocationDao locationDao) {
        this.userDao = userDao;
        this.bookingDao = bookingDao;
        this.vehicleDao  = vehicleDao;
        this.locationDao = locationDao;
    }
    
    @Override
    public ResponseBooking addBooking(RequestBooking requestBooking) 
        throws InsufficientBalanceException, UserNotRegisteredException, UnauthorizedUserException {
        // TODO Auto-generated method stub
        int userId = requestBooking.getUserId();
        int vehicleId = requestBooking.getVehicleId();
        String pickup = requestBooking.getPickupDate();
        String dropoff = requestBooking.getDropoffDate();
        String booking = requestBooking.getBookingDate();
        int locationId = requestBooking.getLocationId();
        float amount = requestBooking.getAmount();

        Optional<Users> user = userDao.findById(userId);
        Optional<Vehicle> vehicle = vehicleDao.findById(vehicleId);
        Optional<Location> location = locationDao.findById(locationId);

        if(!user.isPresent()){
            throw new UserNotRegisteredException();
        }
        if(!vehicle.isPresent()){
            throw new VehicleNotFoundException();
        }
        if(!location.isPresent()){
            throw new LocationNotFoundException();
        }

        LocalDate pickupDate = LocalDate.parse(pickup.split("T")[0]);
        LocalDateTime pickupDateTime = pickupDate.atStartOfDay();
        System.out.println(pickupDateTime);

        LocalDate dropoffDate = LocalDate.parse(dropoff.split("T")[0]);
        LocalDateTime dropoffDateTime = dropoffDate.atStartOfDay();
        System.out.println(dropoffDateTime);
        
        LocalDate bookingDate = LocalDate.parse(booking.split("T")[0]);
        LocalDateTime bookingDateTime = bookingDate.atStartOfDay();
        System.out.println(bookingDateTime);

        Users finalUser = user.get();

        if(finalUser.getWalletMoney() < amount){
            throw new InsufficientBalanceException();
        }


        finalUser.setWalletMoney(finalUser.getWalletMoney() - amount);
        userDao.save(finalUser);
        // bookingDao.save(booking);
        Booking bookingDetails = new Booking();
        bookingDetails.setVehicle(vehicle.get());
        bookingDetails.setUsers(finalUser);
        bookingDetails.setPickupDate(pickupDateTime);
        bookingDetails.setLocation(location.get());
        bookingDetails.setDropoffDate(dropoffDateTime);
        bookingDetails.setBookingDate(bookingDateTime);
        bookingDetails.setAmount(amount);
        bookingDetails = bookingDao.save(bookingDetails);
        ResponseBooking responseBooking = new ResponseBooking();
        responseBooking.setBookingId(bookingDetails.getBookingId());
        responseBooking.setAmount(amount);
        responseBooking.setBookingDate(bookingDateTime);
        responseBooking.setDropoffDate(dropoffDateTime);
        responseBooking.setLocationId(locationId);
        responseBooking.setPickupDate(pickupDateTime);
        responseBooking.setUserId(userId);
        responseBooking.setVehicleId(vehicleId);
        return responseBooking;


    }

    @Override
    public List<ResponseBooking> getAllBooking() {
        // TODO Auto-generated method stub
        List<Booking> bookings = bookingDao.findAll();
        List<ResponseBooking> responseBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            ResponseBooking responseBooking = new ResponseBooking();
            responseBooking.setBookingId(booking.getBookingId());
            responseBooking.setAmount(booking.getAmount());
            responseBooking.setBookingDate(booking.getBookingDate());
            responseBooking.setDropoffDate(booking.getDropoffDate());
            responseBooking.setLocationId(booking.getLocation().getLocationId());
            responseBooking.setPickupDate(booking.getPickupDate());
            responseBooking.setUserId(booking.getUsers().getUserId());
            responseBooking.setVehicleId(booking.getVehicle().getVehicleId());
            responseBookings.add(responseBooking);
        }
        return responseBookings;
    }
    
}
