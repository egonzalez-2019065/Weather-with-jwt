package com.alexandergonzalez.weather.repository;

import com.alexandergonzalez.weather.entity.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeatherRepository extends MongoRepository<Weather, String> {
}
