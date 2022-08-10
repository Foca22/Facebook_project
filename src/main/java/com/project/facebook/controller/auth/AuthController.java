package com.project.facebook.controller.auth;

import com.project.facebook.dto.auth.AuthReq;
import com.project.facebook.exceptions.credentials.InvalidCredentialsException;
import com.project.facebook.exceptions.messages.ExceptionMessages;
import com.project.facebook.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class AuthController {

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    public AuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/auth")
    public String generateToken(@RequestBody AuthReq authRequest) throws InvalidCredentialsException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new InvalidCredentialsException(ExceptionMessages.INVALID_CREDENTIALS.getErrorMessage(),
                    ExceptionMessages.INVALID_CREDENTIALS.getHttpStatusCode());
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
