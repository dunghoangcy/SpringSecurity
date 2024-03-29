package com.dhacode.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDTO {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;

}
