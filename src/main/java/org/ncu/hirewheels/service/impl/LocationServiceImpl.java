package org.ncu.hirewheels.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.ncu.hirewheels.dao.CityDao;
import org.ncu.hirewheels.dao.LocationDao;
import org.ncu.hirewheels.entities.City;
import org.ncu.hirewheels.entities.Location;
import org.ncu.hirewheels.entities.ResponseLocation;
import org.ncu.hirewheels.exceptions.NoSuchCityExistException;
import org.ncu.hirewheels.service.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{
    private LocationDao locationDao;
    private CityDao cityDao;

    public LocationServiceImpl(LocationDao locationDao, CityDao cityDao) {
        this.locationDao = locationDao;
        this.cityDao = cityDao;
    }

    @Override
    public ResponseLocation addLocation(ResponseLocation requestLocation) {
        // TODO Auto-generated method stub
        Location l = new Location();
        l.setAddress(requestLocation.getAddress());
        // requestLocation.getCityId()
        System.out.println("The City Id is "+requestLocation.getCityId());
        Optional<City> city  = cityDao.findById(requestLocation.getCityId());
        if(!city.isPresent()){
            throw new NoSuchCityExistException();
        }
        l.setCity(city.get());

        l.setLocationName(requestLocation.getLocationName());
        l.setPincode(requestLocation.getPincode());
        Location newLocation = locationDao.save(l);
        ResponseLocation responseLocation = new ResponseLocation();

        responseLocation.setLocationName(newLocation.getLocationName());
        responseLocation.setCityId(newLocation.getCity().getCityId());
        responseLocation.setLocationId(newLocation.getLocationId());
        responseLocation.setAddress(newLocation.getAddress());
        responseLocation.setPincode(newLocation.getPincode());

        return responseLocation;
    }

    @Override
    public List<ResponseLocation> getAllLocations() {
        // TODO Auto-generated method stub
        List<ResponseLocation> responseLocations = new ArrayList<>();
        List<Location> locations = locationDao.findAll();
        for (Location newLocation : locations) {
            ResponseLocation responseLocation = new ResponseLocation();

            responseLocation.setLocationName(newLocation.getLocationName());
            responseLocation.setCityId(newLocation.getCity().getCityId());
            responseLocation.setLocationId(newLocation.getLocationId());
            responseLocation.setAddress(newLocation.getAddress());
            responseLocation.setPincode(newLocation.getPincode());
            responseLocations.add(responseLocation);
        }
        return responseLocations;
    }
    
}
