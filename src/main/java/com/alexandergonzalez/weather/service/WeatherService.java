package com.alexandergonzalez.weather.service;

import com.alexandergonzalez.weather.entity.Weather;
import com.alexandergonzalez.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    // Método que guardar una temperatura
    public Weather save(Weather weather){
        Weather weatherToSave = weatherRepository.save(weather);
        return weatherToSave;
    }

    // Método para devolver una temperatura
    public Weather findById(String id){
        Weather weatherFound = weatherRepository.findById(id).orElse(null);
        return weatherFound;
    }
}
