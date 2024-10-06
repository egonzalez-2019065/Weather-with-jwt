package com.alexandergonzalez.weather.controller;

import com.alexandergonzalez.weather.dto.AuthDto;
import com.alexandergonzalez.weather.dto.LoginDto;
import com.alexandergonzalez.weather.dto.RegisterDto;
import com.alexandergonzalez.weather.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthDto> login(@RequestBody LoginDto login){
        AuthDto authDto = this.authService.login(login);
        return ResponseEntity.ok(authDto);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDto> register(@RequestBody RegisterDto dto){
        RegisterDto userDto = this.authService.register(dto);
        return ResponseEntity.ok(userDto);
    }


}
