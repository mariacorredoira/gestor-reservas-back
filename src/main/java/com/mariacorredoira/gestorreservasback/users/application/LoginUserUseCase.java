package com.mariacorredoira.gestorreservasback.users.application;

import com.mariacorredoira.gestorreservasback.security.JwtUtil;
import com.mariacorredoira.gestorreservasback.security.SecurityUser;
import com.mariacorredoira.gestorreservasback.users.infrastructure.controller.request.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUserUseCase {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public String execute(LoginRequest request) {
        try {
            Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            SecurityUser userDetails = (SecurityUser) auth.getPrincipal();
            String token = jwtUtil.generateToken(userDetails.getUsername(), userDetails.getUser().getRole());
            return token;
        } catch (AuthenticationException e) {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}
