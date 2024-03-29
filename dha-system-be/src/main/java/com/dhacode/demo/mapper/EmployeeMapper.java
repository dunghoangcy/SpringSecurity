package com.dhacode.demo.mapper;

import com.dhacode.demo.dto.EmployeesDTO;
import com.dhacode.demo.entity.Employees;

public class EmployeeMapper {

    public static Employees mapToEmployees(EmployeesDTO dto){
        return Employees
                .builder()
                .employeeId(dto.getEmployeeId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .build();
    }

    public static EmployeesDTO mapToEmployeesDTO(Employees e){
        return EmployeesDTO
                .builder()
                .employeeId(e.getEmployeeId())
                .firstName(e.getFirstName())
                .lastName(e.getLastName())
                .email(e.getEmail())
                .build();
    }
}
