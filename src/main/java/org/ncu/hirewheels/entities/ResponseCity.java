package org.ncu.hirewheels.entities;

public class ResponseCity {
    private int cityId;
    // city_name VARCHAR(50) NOT NULL
    private String cityName;

    public ResponseCity() {
    }

    public ResponseCity(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public int getCityId() {
        return this.cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "{" +
            " cityId='" + getCityId() + "'" +
            ", cityName='" + getCityName() + "'" +
            "}";
    }

}
