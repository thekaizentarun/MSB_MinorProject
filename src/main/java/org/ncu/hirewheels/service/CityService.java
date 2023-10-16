package org.ncu.hirewheels.service;

import java.util.List;

import org.ncu.hirewheels.entities.City;
import org.ncu.hirewheels.entities.ResponseCity;

public interface CityService {
    public ResponseCity addCity(City city);
    public List<ResponseCity> getAllCities();
}
