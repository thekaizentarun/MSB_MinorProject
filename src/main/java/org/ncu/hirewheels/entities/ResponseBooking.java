package org.ncu.hirewheels.entities;

import java.time.LocalDateTime;

public class ResponseBooking {
    /*
     * "bookingId": 4 {Note: this field change},
 "pickupDate": "2020-07-17",
 "dropoffDate": "2020-07-18",
 "bookingDate": "2020-06-29",
 "amount": 1000,
 "locationId": 1,
 "vehicleId": 3,
 "userId": 1
     */
    private int bookingId;
    private LocalDateTime pickupDate;
    private LocalDateTime dropoffDate;
    private LocalDateTime bookingDate;
    private int locationId;
    private float amount;
    private int userId;
    private int vehicleId;


    public ResponseBooking() {
    }

    public ResponseBooking(int bookingId, LocalDateTime pickupDate, LocalDateTime dropoffDate, LocalDateTime bookingDate, int locationId, float amount, int userId, int vehicleId) {
        this.bookingId = bookingId;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.bookingDate = bookingDate;
        this.locationId = locationId;
        this.amount = amount;
        this.userId = userId;
        this.vehicleId = vehicleId;
    }

    public int getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getPickupDate() {
        return this.pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDateTime getDropoffDate() {
        return this.dropoffDate;
    }

    public void setDropoffDate(LocalDateTime dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public LocalDateTime getBookingDate() {
        return this.bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getLocationId() {
        return this.locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String toString() {
        return "{" +
            " bookingId='" + getBookingId() + "'" +
            ", pickupDate='" + getPickupDate() + "'" +
            ", dropoffDate='" + getDropoffDate() + "'" +
            ", bookingDate='" + getBookingDate() + "'" +
            ", locationId='" + getLocationId() + "'" +
            ", amount='" + getAmount() + "'" +
            ", userId='" + getUserId() + "'" +
            ", vehicleId='" + getVehicleId() + "'" +
            "}";
    }

}
