package org.ncu.hirewheels.entities;

public class ResponseLocation {
    private int locationId;
    // location_name VARCHAR(50) NOT NULL
    private String locationName;
    // address VARCHAR(100) NOT NULL
    private String address;
    // pincode CHAR(6) NOT NULL
    private long pincode;
    // city_id NUMERIC(10) NOT NULL FOREIGN KEY
    private int cityId;

    public ResponseLocation() {
    }

    public ResponseLocation(int locationId, String locationName, String address, long pincode, int cityId) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.address = address;
        this.pincode = pincode;
        this.cityId = cityId;
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

    public int getCityId() {
        return this.cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "{" +
            " locationId='" + getLocationId() + "'" +
            ", locationName='" + getLocationName() + "'" +
            ", address='" + getAddress() + "'" +
            ", pincode='" + getPincode() + "'" +
            ", cityId='" + getCityId() + "'" +
            "}";
    }

}
