package org.ncu.hirewheels.entities;


public class RequestBooking {
    private int userId;
    private int vehicleId;
    private String pickupDate;
    private String dropoffDate;
    private String bookingDate;
    private int locationId;
    private float amount;


    public RequestBooking() {
    }

    public RequestBooking(int userId, int vehicleId, String pickupDate, String dropoffDate, String bookingDate, 
        int locationId, float amount) {
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.bookingDate = bookingDate;
        this.locationId = locationId;
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

    public String getPickupDate() {
        return this.pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getDropoffDate() {
        return this.dropoffDate;
    }

    public void setDropoffDate(String dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public String getBookingDate() {
        return this.bookingDate;
    }

    public void setBookingDate(String bookingDate) {
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

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", vehicleId='" + getVehicleId() + "'" +
            ", pickupDate='" + getPickupDate() + "'" +
            ", dropoffDate='" + getDropoffDate() + "'" +
            ", bookingDate='" + getBookingDate() + "'" +
            ", locationId='" + getLocationId() + "'" +
            ", amount='" + getAmount() + "'" +
            "}";
    }
   

}
