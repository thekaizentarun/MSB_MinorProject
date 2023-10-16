package org.ncu.hirewheels.entities;

public class ResponseFuelType {
    private int fuelTypeId;
    private String fuelType;

    public ResponseFuelType() {
    }

    public ResponseFuelType(int fuelTypeId, String fuelType) {
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;
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

    @Override
    public String toString() {
        return "{" +
            " fuelTypeId='" + getFuelTypeId() + "'" +
            ", fuelType='" + getFuelType() + "'" +
            "}";
    }

}
