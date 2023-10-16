package org.ncu.hirewheels.entities;

public class ResponseVehicleCategory {
    private int vehicleCategoryId;
    // vehicle_category_name VARCHAR(50) NOT NULL UNIQUE
    private String vehicleCategoryName;

    public ResponseVehicleCategory() {
    }

    public ResponseVehicleCategory(int vehicleCategoryId, String vehicleCategoryName) {
        this.vehicleCategoryId = vehicleCategoryId;
        this.vehicleCategoryName = vehicleCategoryName;
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

    @Override
    public String toString() {
        return "{" +
            " vehicleCategoryId='" + getVehicleCategoryId() + "'" +
            ", vehicleCategoryName='" + getVehicleCategoryName() + "'" +
            "}";
    }

}
