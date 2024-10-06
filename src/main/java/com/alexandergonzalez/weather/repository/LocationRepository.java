package com.alexandergonzalez.weather.repository;

import com.alexandergonzalez.weather.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {

}
