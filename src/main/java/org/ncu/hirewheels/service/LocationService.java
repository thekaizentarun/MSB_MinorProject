package org.ncu.hirewheels.service;

import java.util.List;


import org.ncu.hirewheels.entities.ResponseLocation;
import org.ncu.hirewheels.exceptions.NoSuchLocationExistException;

public interface LocationService {
    public ResponseLocation addLocation(ResponseLocation requestLocation) throws NoSuchLocationExistException;
    public List<ResponseLocation> getAllLocations();
}
