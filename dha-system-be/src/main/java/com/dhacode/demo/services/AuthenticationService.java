package com.dhacode.demo.services;

import com.dhacode.demo.auth.AuthenticationRequest;
import com.dhacode.demo.auth.AuthenticationResponse;
import com.dhacode.demo.auth.RegisterRequest;

public interface AuthenticationService {

    public AuthenticationResponse register(RegisterRequest request);
    public AuthenticationResponse authenticate(AuthenticationRequest request);
}
