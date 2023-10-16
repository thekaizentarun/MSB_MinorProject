package org.ncu.hirewheels.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "fueltype_hirewheels")
public class FuelType {
    // fuel_type_id NUMERIC(10) PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // fuel_type VARCHAR(50) NOT NULL UNIQUE
    private int fuelTypeId;
    @Column(length = 50,nullable = false,unique = true)
    private String fuelType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "fuelType")
    private Set<Vehicle> vehicles;

    public FuelType() {
    }

    public FuelType(int fuelTypeId, String fuelType, Set<Vehicle> vehicles) {
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;
        this.vehicles = vehicles;
    }

    public int getFuelTypeId() {
        return this.fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Set<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "{" +
            " fuelTypeId='" + getFuelTypeId() + "'" +
            ", fuelType='" + getFuelType() + "'" +
            ", vehicles='" + getVehicles() + "'" +
            "}";
    }


}
