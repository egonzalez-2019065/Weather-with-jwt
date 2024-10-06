package com.alexandergonzalez.weather.controller;

import com.alexandergonzalez.weather.entity.Location;
import com.alexandergonzalez.weather.entity.Weather;
import com.alexandergonzalez.weather.service.LocationService;
import com.alexandergonzalez.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/weather")
public class LocationController {

    @Autowired
    private final LocationService locationService;

    @Autowired
    private final WeatherService weatherService;

    public LocationController(LocationService locationService, WeatherService weatherService) {
        this.locationService = locationService;
        this.weatherService = weatherService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Map<String, Object>> save(@PathVariable("id") String id, @RequestBody Weather weather){
        Location location = locationService.findById(id);
        if(location != null) {
            Weather weatherToSave = weatherService.save(weather);
            location.setWeatherID(weatherToSave.getId());
            locationService.save(location.getId(), location);
            Map<String, Object> response = new HashMap<>();
            response.put("Gracias por agregar el reporte del tiempo para la ciudad: " +
                    " " + location.getCountry(), weatherToSave);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") String id){
        Location location = locationService.findById(id);
        // Verificamos que la locación si exista
        if(location != null){

            // Creamos una respuesta, solo con la locación para evitar nulos si no tiene reportes de clima
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("location", location);

            // Verificamos que a la locación ya se la haya agregado un reporte de clima
            if (location.getWeatherID() != null){
                Weather weather = weatherService.findById(location.getWeatherID());

                // Verificamos que el reporte exista
                if(weather != null) {
                    // Agregamos el reporte del clima
                    response.put("weather", weather);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
                    return new ResponseEntity<>(response, HttpStatus.OK);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
