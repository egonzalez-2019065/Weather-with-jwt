package com.alexandergonzalez.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String id;
    private String name;
    private String lastname;
    private String username;
    private String password;

    public RegisterDto(String id, String name, String lastname, String username){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
    }

}
