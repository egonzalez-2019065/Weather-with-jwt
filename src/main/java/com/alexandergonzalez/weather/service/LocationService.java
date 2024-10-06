package com.alexandergonzalez.weather.service;

import com.alexandergonzalez.weather.entity.Location;
import com.alexandergonzalez.weather.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private final LocationRepository locationRepository;


    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }



    // Crear un método para guardar el reporte del clima para una ubicación
    public Location save(String id, Location location){
        Location found = locationRepository.findById(id).orElse(null);
        assert found != null;
        Location locationToSave = locationRepository.save(location);
        return locationToSave;

    }

    // Crear un método para obtener el reporte del clima para una ubicación
    public Location  findById(String id){
        Location locationFound = locationRepository.findById(id).orElse(null);
        return locationFound;
    }
}
