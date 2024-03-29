package com.dhacode.demo.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class RegisterRequest {
    private String userName ;
    private String email ;
    private String password ;
}
