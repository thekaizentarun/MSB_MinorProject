package org.ncu.hirewheels.entities;

import javax.persistence.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_hirewheels")
public class Vehicle {
    // vehicle_id NUMERIC(10) PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;
    // vehicle_model VARCHAR(50) NOT NULL
    @Column(length = 50, nullable = false)
    private String vehicleModel;
    // vehicle_number VARCHAR(10) NOT NULL
    @Column(length = 10, nullable = false)
    private String vehicleNumber;
    // color VARCHAR(50) NOT NULL
    @Column(length = 50, nullable = false)
    private String color;
    // availability_status NUMERIC(1) NOT NULL
    @Column(nullable = false)
    private int availabilityStaus = 1;
    // vehicle_image_url VARCHAR(500) NOT NULL
    @Column(nullable = false, length = 500)
    private String vehicleImageUrl;


    // vehicle_subcategory_id NUMERIC(10) FOREIGN KEY
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_subcategory_id",nullable = false)
    private VehicleSubcategory vehicleSubcategory;

    // location_id NUMERIC(10) NOT NULL FOREIGN KEY
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="location_id",nullable = false)
    private Location location;
    // fuel_type_id NUMERIC(10) NOT NULL FOREIGN KEY
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fuel_type_id",nullable = false)
    private FuelType fuelType;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    private Set<Booking> bookings;

    public Vehicle() {
    }

    public Vehicle(int vehicleId, String vehicleModel, String vehicleNumber, String color, int availabilityStaus, String vehicleImageUrl, VehicleSubcategory vehicleSubcategory, Location location, FuelType fuelType, Set<Booking> bookings) {
        this.vehicleId = vehicleId;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.color = color;
        this.availabilityStaus = availabilityStaus;
        this.vehicleImageUrl = vehicleImageUrl;
        this.vehicleSubcategory = vehicleSubcategory;
        this.location = location;
        this.fuelType = fuelType;
        this.bookings = bookings;
    }

    public int getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleModel() {
        return this.vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleNumber() {
        return this.vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAvailabilityStaus() {
        return this.availabilityStaus;
    }

    public void setAvailabilityStaus(int availabilityStaus) {
        this.availabilityStaus = availabilityStaus;
    }

    public String getVehicleImageUrl() {
        return this.vehicleImageUrl;
    }

    public void setVehicleImageUrl(String vehicleImageUrl) {
        this.vehicleImageUrl = vehicleImageUrl;
    }

    public VehicleSubcategory getVehicleSubcategory() {
        return this.vehicleSubcategory;
    }

    public void setVehicleSubcategory(VehicleSubcategory vehicleSubcategory) {
        this.vehicleSubcategory = vehicleSubcategory;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Set<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "{" +
            " vehicleId='" + getVehicleId() + "'" +
            ", vehicleModel='" + getVehicleModel() + "'" +
            ", vehicleNumber='" + getVehicleNumber() + "'" +
            ", color='" + getColor() + "'" +
            ", availabilityStaus='" + getAvailabilityStaus() + "'" +
            ", vehicleImageUrl='" + getVehicleImageUrl() + "'" +
            ", vehicleSubcategory='" + getVehicleSubcategory() + "'" +
            ", location='" + getLocation() + "'" +
            ", fuelType='" + getFuelType() + "'" +
            ", bookings='" + getBookings() + "'" +
            "}";
    }

    
}
