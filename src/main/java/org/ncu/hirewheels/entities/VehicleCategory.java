package org.ncu.hirewheels.entities;

import javax.persistence.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "vehiclecategory_hirewheels")
public class VehicleCategory {
    // vehicle_category_id NUMERIC(10) PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleCategoryId;
    // vehicle_category_name VARCHAR(50) NOT NULL UNIQUE
    @Column(nullable = false,unique = true,length = 50)
    private String vehicleCategoryName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "vehicleCategory")
    private Set<VehicleSubcategory> vehicleSubcategories;


    public VehicleCategory() {
    }

    public VehicleCategory(int vehicleCategoryId, String vehicleCategoryName, Set<VehicleSubcategory> vehicleSubcategories) {
        this.vehicleCategoryId = vehicleCategoryId;
        this.vehicleCategoryName = vehicleCategoryName;
        this.vehicleSubcategories = vehicleSubcategories;
    }

    public int getVehicleCategoryId() {
        return this.vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategoryName() {
        return this.vehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
    }

    public Set<VehicleSubcategory> getVehicleSubcategories() {
        return this.vehicleSubcategories;
    }

    public void setVehicleSubcategories(Set<VehicleSubcategory> vehicleSubcategories) {
        this.vehicleSubcategories = vehicleSubcategories;
    }

    @Override
    public String toString() {
        return "{" +
            " vehicleCategoryId='" + getVehicleCategoryId() + "'" +
            ", vehicleCategoryName='" + getVehicleCategoryName() + "'" +
            ", vehicleSubcategories='" + getVehicleSubcategories() + "'" +
            "}";
    }
   
    
}
