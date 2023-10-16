package org.ncu.hirewheels.entities;

public class ResponseVehicleWithPricePerDay {


    /*
     * 
     * "vehicleId": 5 {this might change},
 "vehicleModel": "AMG",
 "vehicleNumber": "INDH 345",
 "vehicleSubCategoryId": 10,
 "color": "Blue",
 "fuelTypeId": 1,
 "locationId": 1,
 "vehicleImageUrl": "https://www.mercedes-amg.com/en/
world-of-amg/news/press-information/mercedes-amggt-black-series-record-lap.html",
 "availabilityStatus": 1,
 "pricePerDay": 0
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
    private float pricePerDay;

    public ResponseVehicleWithPricePerDay() {
    }

    public ResponseVehicleWithPricePerDay(int vehicleId, String vehicleModel, String vehicleNumber, String color, int availabilityStaus, String vehicleImageUrl, int vehicleSubCategoryId, int fuelTypeId, int locationId, float pricePerDay) {
        this.vehicleId = vehicleId;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.color = color;
        this.availabilityStaus = availabilityStaus;
        this.vehicleImageUrl = vehicleImageUrl;
        this.vehicleSubCategoryId = vehicleSubCategoryId;
        this.fuelTypeId = fuelTypeId;
        this.locationId = locationId;
        this.pricePerDay = pricePerDay;
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

    public float getPricePerDay() {
        return this.pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
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
            ", pricePerDay='" + getPricePerDay() + "'" +
            "}";
    }

}
