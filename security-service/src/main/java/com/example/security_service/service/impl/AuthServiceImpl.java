package com.example.security_service.service.impl;

import com.example.security_service.service.AuthService;
import org.springframework.stereotype.Service;

public class AuthServiceImpl {
    @Service
    public class AuthServiceImpl implements AuthService {

        @Override
        public String authenticate(AuthRequest authRequest) {
            // Implement authentication with Keycloak here
            return "JWT Token";
        }

        @Override
        public String refreshToken(RefreshTokenRequest refreshTokenRequest) {
            // Implement token refresh with Keycloak here
            return "New JWT Token";
        }
    }
}
