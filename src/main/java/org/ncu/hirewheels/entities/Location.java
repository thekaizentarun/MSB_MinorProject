package org.ncu.hirewheels.entities;


import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "location_hirewheels")
public class Location {
    // location_id NUMERIC(10) PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int locationId;
    // location_name VARCHAR(50) NOT NULL
    @Column(length = 50,nullable = false)
    private String locationName;
    // address VARCHAR(100) NOT NULL
    @Column(length = 100,nullable = false)
    private String address;
    // pincode CHAR(6) NOT NULL
    @Column(length = 6,nullable = false)
    private long pincode;
    // city_id NUMERIC(10) NOT NULL FOREIGN KEY
    @ManyToOne(cascade = CascadeType.ALL
    )
    @JoinColumn(name="city_id",nullable = false)
    private City city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Set<Vehicle> vehicles;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Set<Booking> bookings;


    public Location() {
    }

    public Location(int locationId, String locationName, String address, long pincode, City city, Set<Vehicle> vehicles, Set<Booking> bookings) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.address = address;
        this.pincode = pincode;
        this.city = city;
        this.vehicles = vehicles;
        this.bookings = bookings;
    }

    public int getLocationId() {
        return this.locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPincode() {
        return this.pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
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
            " locationId='" + getLocationId() + "'" +
            ", locationName='" + getLocationName() + "'" +
            ", address='" + getAddress() + "'" +
            ", pincode='" + getPincode() + "'" +
            ", city='" + getCity() + "'" +
            ", vehicles='" + getVehicles() + "'" +
            ", bookings='" + getBookings() + "'" +
            "}";
    }


}
