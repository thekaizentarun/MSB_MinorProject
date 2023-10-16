package org.ncu.hirewheels.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ncu.hirewheels.dao.CityDao;
import org.ncu.hirewheels.entities.City;
import org.ncu.hirewheels.entities.ResponseCity;
import org.ncu.hirewheels.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    private CityDao cityDao;

    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public ResponseCity addCity(City city) {
        // TODO Auto-generated method stub
        ResponseCity responseCity = new ResponseCity();
        City newCity = cityDao.save(city);
        responseCity.setCityId(newCity.getCityId());
        responseCity.setCityName(newCity.getCityName());
        return responseCity;
    }

    @Override
    public List<ResponseCity> getAllCities() {
        // TODO Auto-generated method stub

        List<City> cities = cityDao.findAll();
        List<ResponseCity> responseCities = new ArrayList<ResponseCity>();

        for (City newCity : cities) {
            System.out.println("THE City is "+newCity.getCityId());
            ResponseCity responseCity = new ResponseCity();
            responseCity.setCityId(newCity.getCityId());
            responseCity.setCityName(newCity.getCityName());
            responseCities.add(responseCity);
        }

        return responseCities;
    }

}
