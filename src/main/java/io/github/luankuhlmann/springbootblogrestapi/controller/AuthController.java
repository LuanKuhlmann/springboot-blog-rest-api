package io.github.luankuhlmann.springbootblogrestapi.controller;

import io.github.luankuhlmann.springbootblogrestapi.dto.LoginDto;
import io.github.luankuhlmann.springbootblogrestapi.dto.RegisterDto;
import io.github.luankuhlmann.springbootblogrestapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        String response = authService.login(loginDto);
        return ResponseEntity.ok(response);
    }

    // Build Register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(RegisterDto registerDto) {
        String responce = authService.register(registerDto);
        return new ResponseEntity<>(responce, HttpStatus.CREATED);
    }
}
