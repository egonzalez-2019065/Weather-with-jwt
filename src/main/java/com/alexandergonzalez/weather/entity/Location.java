package com.alexandergonzalez.weather.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "location")
public class Location {

    @Id
    private String id;
    private String city;
    private String country;
    private String region;
    private String weatherID;
}
