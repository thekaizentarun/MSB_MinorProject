package org.ncu.hirewheels.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "booking_hirewheels")
public class Booking {

    // booking_id NUMERIC(10) PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;
    // pickup_date DATE NOT NULL
    @Column(nullable = false)
    private LocalDateTime pickupDate;
    // dropoff_date DATE NOT NULL
    @Column(nullable = false)
    private LocalDateTime dropoffDate;
    // booking_date DATE NOT NULL
    @Column(nullable = false)
    private LocalDateTime bookingDate;
    // amount NUMERIC(10,2) NOT NULL
    @Column(nullable = false)
    private float amount;

    // location_id NUMERIC(10) NOT NULL FOREIGN KEY
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
    // vehicle_id NUMERIC(10) NOT NULL FOREIGN KEY
    @ManyToOne()
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
    // user_id NUMERIC(10) NOT NULL FOREIGN KEY
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;


    public Booking() {
    }

    public Booking(int bookingId, LocalDateTime pickupDate, LocalDateTime dropoffDate, LocalDateTime bookingDate, float amount, Location location, Vehicle vehicle, Users users) {
        this.bookingId = bookingId;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.location = location;
        this.vehicle = vehicle;
        this.users = users;
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

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "{" +
            " bookingId='" + getBookingId() + "'" +
            ", pickupDate='" + getPickupDate() + "'" +
            ", dropoffDate='" + getDropoffDate() + "'" +
            ", bookingDate='" + getBookingDate() + "'" +
            ", amount='" + getAmount() + "'" +
            ", location='" + getLocation() + "'" +
            ", vehicle='" + getVehicle() + "'" +
            ", users='" + getUsers() + "'" +
            "}";
    }
    
}
