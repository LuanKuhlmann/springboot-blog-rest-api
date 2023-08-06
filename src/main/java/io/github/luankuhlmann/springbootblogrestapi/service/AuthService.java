package io.github.luankuhlmann.springbootblogrestapi.service;

import io.github.luankuhlmann.springbootblogrestapi.dto.LoginDto;
import io.github.luankuhlmann.springbootblogrestapi.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
