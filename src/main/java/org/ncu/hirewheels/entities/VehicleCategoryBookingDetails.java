package org.ncu.hirewheels.entities;

public class VehicleCategoryBookingDetails {
    private VehicleCategory vehicleCategory;
    private Booking booking;

    public VehicleCategoryBookingDetails() {
    }

    public VehicleCategoryBookingDetails(VehicleCategory vehicleCategory, Booking booking) {
        this.vehicleCategory = vehicleCategory;
        this.booking = booking;
    }

    public VehicleCategory getVehicleCategory() {
        return this.vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public Booking getBooking() {
        return this.booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "{" +
            " vehicleCategory='" + getVehicleCategory() + "'" +
            ", booking='" + getBooking() + "'" +
            "}";
    }

}
