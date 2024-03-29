package com.dhacode.demo.services;

import com.dhacode.demo.dto.EmployeesDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeesDTO> findAll();

    String save(EmployeesDTO dto);

    void delete(Long id);
}
