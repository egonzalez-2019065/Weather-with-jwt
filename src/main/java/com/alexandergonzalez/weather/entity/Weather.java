package com.alexandergonzalez.weather.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "weather")
public class Weather {

    @Id
    private String id;
    private double temp;
    private double pressure;
    private double humedity;

    
}
