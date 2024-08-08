package com.example.security_service.service;

public interface AuthService {
    String authenticate(AuthRequest authRequest);
    String refreshToken(RefreshTokenRequest refreshTokenRequest);
}
