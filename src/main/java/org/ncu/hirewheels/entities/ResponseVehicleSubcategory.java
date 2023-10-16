package org.ncu.hirewheels.entities;

public class ResponseVehicleSubcategory {
    private int vehicleSubcategoryId;
    // vehicle_subcategory_name VARCHAR(50) NOT NULL UNIQUE

    private String vehicleSubcategoryName;
    // price_per_day NUMERIC(10,2) NOT NULL

    private float pricePerDay;
    // vehicle_category_id NUMERIC(10) NOT NULL FOREIGN KEY

    private int vehicleCategoryId;

    public ResponseVehicleSubcategory() {
    }

    public ResponseVehicleSubcategory(int vehicleSubcategoryId, String vehicleSubcategoryName, float pricePerDay, int vehicleCategoryId) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
        this.vehicleSubcategoryName = vehicleSubcategoryName;
        this.pricePerDay = pricePerDay;
        this.vehicleCategoryId = vehicleCategoryId;
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

    public int getVehicleCategoryId() {
        return this.vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    @Override
    public String toString() {
        return "{" +
            " vehicleSubcategoryId='" + getVehicleSubcategoryId() + "'" +
            ", vehicleSubcategoryName='" + getVehicleSubcategoryName() + "'" +
            ", pricePerDay='" + getPricePerDay() + "'" +
            ", vehicleCategoryId='" + getVehicleCategoryId() + "'" +
            "}";
    }

}
