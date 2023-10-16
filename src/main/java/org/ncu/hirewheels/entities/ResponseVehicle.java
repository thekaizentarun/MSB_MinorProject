package org.ncu.hirewheels.entities;

public class ResponseVehicle {
    /*
     * "vehicleId": 57,
        "vehicleModel": "Maruti",
        "vehicleNumber": "HR26",
        "color": "Black",
        "availabilityStaus": 1,
        "vehicleImageUrl": null,
        "vehicleSubcategory": null,
        "location": null,
        "fuelType": null,
        "bookings": null
     */
    private int vehicleId;
    private String vehicleModel;
    private String vehicleNumber;
    private String color;
    private int availabilityStaus;
    private String vehicleImageUrl;
    private int vehicleSubCategoryId;
    private int fuelTypeId;
    private int locationId;

    public ResponseVehicle() {
    }

    public ResponseVehicle(int vehicleId, String vehicleModel, String vehicleNumber, String color, int availabilityStaus, String vehicleImageUrl, int vehicleSubCategoryId, int fuelTypeId, int locationId) {
        this.vehicleId = vehicleId;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.color = color;
        this.availabilityStaus = availabilityStaus;
        this.vehicleImageUrl = vehicleImageUrl;
        this.vehicleSubCategoryId = vehicleSubCategoryId;
        this.fuelTypeId = fuelTypeId;
        this.locationId = locationId;
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

    public int getVehicleSubCategoryId() {
        return this.vehicleSubCategoryId;
    }

    public void setVehicleSubCategoryId(int vehicleSubCategoryId) {
        this.vehicleSubCategoryId = vehicleSubCategoryId;
    }

    public int getFuelTypeId() {
        return this.fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public int getLocationId() {
        return this.locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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
            ", vehicleSubCategoryId='" + getVehicleSubCategoryId() + "'" +
            ", fuelTypeId='" + getFuelTypeId() + "'" +
            ", locationId='" + getLocationId() + "'" +
            "}";
    }
}
