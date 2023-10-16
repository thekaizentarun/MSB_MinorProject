package org.ncu.hirewheels.controller;


import java.util.List;

import org.ncu.hirewheels.entities.RequestBooking;
import org.ncu.hirewheels.entities.ResponseBooking;
import org.ncu.hirewheels.exceptions.InsufficientBalanceException;
import org.ncu.hirewheels.exceptions.UnauthorizedUserException;
import org.ncu.hirewheels.exceptions.UserNotRegisteredException;
import org.ncu.hirewheels.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hirewheel/v1")
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(value = "/bookings" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBooking> addBooking(@RequestBody RequestBooking requestBooking) 
        throws UserNotRegisteredException, InsufficientBalanceException, UnauthorizedUserException {
        return new ResponseEntity<ResponseBooking>(bookingService.addBooking(requestBooking), HttpStatus.CREATED);
    }
    @GetMapping(value = "/bookings")
    public ResponseEntity<List<ResponseBooking>> getAllBooking(){
        return new ResponseEntity<List<ResponseBooking>>(bookingService.getAllBooking(), HttpStatus.ACCEPTED);
    }
}
