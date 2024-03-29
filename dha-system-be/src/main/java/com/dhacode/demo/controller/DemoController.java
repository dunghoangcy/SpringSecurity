package com.dhacode.demo.controller;


import com.dhacode.demo.auth.AuthenticationRequest;
import com.dhacode.demo.auth.AuthenticationResponse;
import com.dhacode.demo.auth.RegisterRequest;
import com.dhacode.demo.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/demo")
public class DemoController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register
            (@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login
            (@RequestBody AuthenticationRequest request)
    {
        return ResponseEntity.ok(authenticationService.authenticate(request));

    }
}
