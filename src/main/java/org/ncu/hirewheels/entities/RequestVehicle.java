package org.ncu.hirewheels.entities;

public class RequestVehicle {
    /*
     * "vehicleModel": "AMG",
 "vehicleNumber": "INDH 345",
 "vehicleSubCategoryId": 1,
 "color": "Blue",
 "fuelTypeId": 1,
 "locationId": 1,
 "vehicleImageUrl": "https://www.mercedes-amg.com/en/
world-of-amg/news/press-information/mercedes-amg-gtblack-series-record-lap.html",
 "availabilityStatus": 1
     */
    private String vehicleModel;
    private String vehicleNumber;
    private int vehicleSubCategoryId;
    private String color;
    private int fuelTypeId;
    private int locationId;
    private String vehicleImageUrl;
    private int availabilityStatus;


    public RequestVehicle() {
    }
   

    public RequestVehicle(String vehicleModel, String vehicleNumber, int vehicleSubCategoryId, String color, int fuelTypeId, int locationId, String vehicleImageUrl, int availabilityStatus) {
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.vehicleSubCategoryId = vehicleSubCategoryId;
        this.color = color;
        this.fuelTypeId = fuelTypeId;
        this.locationId = locationId;
        this.vehicleImageUrl = vehicleImageUrl;
        this.availabilityStatus = availabilityStatus;
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

    public int getVehicleSubCategoryId() {
        return this.vehicleSubCategoryId;
    }

    public void setVehicleSubCategoryId(int vehicleSubCategoryId) {
        this.vehicleSubCategoryId = vehicleSubCategoryId;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getVehicleImageUrl() {
        return this.vehicleImageUrl;
    }

    public void setVehicleImageUrl(String vehicleImageUrl) {
        this.vehicleImageUrl = vehicleImageUrl;
    }

    public int getAvailabilityStatus() {
        return this.availabilityStatus;
    }

    public void setAvailabilityStatus(int availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public String toString() {
        return "{" +
            " vehicleModel='" + getVehicleModel() + "'" +
            ", vehicleNumber='" + getVehicleNumber() + "'" +
            ", vehicleSubCategoryId='" + getVehicleSubCategoryId() + "'" +
            ", color='" + getColor() + "'" +
            ", fuelTypeId='" + getFuelTypeId() + "'" +
            ", locationId='" + getLocationId() + "'" +
            ", vehicleImageUrl='" + getVehicleImageUrl() + "'" +
            ", availabilityStatus='" + getAvailabilityStatus() + "'" +
            "}";
    }

}
