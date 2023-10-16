package org.ncu.hirewheels.entities;



import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "vehiclesubcategory_hirewheels")
public class VehicleSubcategory {
    // vehicle_subcategory_id NUMERIC(10) PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleSubcategoryId;
    // vehicle_subcategory_name VARCHAR(50) NOT NULL UNIQUE
    @Column(length = 50,nullable = false,unique = true)
    private String vehicleSubcategoryName;
    // price_per_day NUMERIC(10,2) NOT NULL
    @Column(nullable = false, length = 10)
    private float pricePerDay;
    // vehicle_category_id NUMERIC(10) NOT NULL FOREIGN KEY
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_category_id",nullable = false)
    private VehicleCategory vehicleCategory;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "vehicleSubcategory")
    private Set<Vehicle> vehicles;


    public VehicleSubcategory() {
        
    }

    public VehicleSubcategory(int vehicleSubcategoryId, String vehicleSubcategoryName, float pricePerDay, VehicleCategory vehicleCategory, Set<Vehicle> vehicles) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
        this.vehicleSubcategoryName = vehicleSubcategoryName;
        this.pricePerDay = pricePerDay;
        this.vehicleCategory = vehicleCategory;
        this.vehicles = vehicles;
    }

    public int getVehicleSubcategoryId() {
        return this.vehicleSubcategoryId;
    }

    public void setVehicleSubcategoryId(int vehicleSubcategoryId) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
    }

    public String getVehicleSubcategoryName() {
        return this.vehicleSubcategoryName;
    }

    public void setVehicleSubcategoryName(String vehicleSubcategoryName) {
        this.vehicleSubcategoryName = vehicleSubcategoryName;
    }

    public float getPricePerDay() {
        return this.pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public VehicleCategory getVehicleCategory() {
        return this.vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
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
            " vehicleSubcategoryId='" + getVehicleSubcategoryId() + "'" +
            ", vehicleSubcategoryName='" + getVehicleSubcategoryName() + "'" +
            ", pricePerDay='" + getPricePerDay() + "'" +
            ", vehicleCategory='" + getVehicleCategory() + "'" +
            ", vehicles='" + getVehicles() + "'" +
            "}";
    }


}
