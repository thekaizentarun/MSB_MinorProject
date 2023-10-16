package org.ncu.hirewheels.entities;


import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "city_hirewheels")
public class City {
    // city_id NUMERIC(10) PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId;
    // city_name VARCHAR(50) NOT NULL
    @Column(length = 50,nullable = false)
    private String cityName;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "city")
    private Set<Location> locations;

    public City() {
    }

    public City(int cityId, String cityName, Set<Location> locations) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.locations = locations;
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

    public Set<Location> getLocations() {
        return this.locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "{" +
            " cityId='" + getCityId() + "'" +
            ", cityName='" + getCityName() + "'" +
            ", locations='" + getLocations() + "'" +
            "}";
    }

   
}
