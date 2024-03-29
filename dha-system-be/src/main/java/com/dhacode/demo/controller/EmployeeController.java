package com.dhacode.demo.controller;


import com.dhacode.demo.dto.EmployeesDTO;
import com.dhacode.demo.entity.Employees;
import com.dhacode.demo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/employ")
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping("/getAll")
    public Collection<EmployeesDTO> getAllEmployee(){
        Collection<EmployeesDTO> employees = employeeService.findAll();
        return employees;
    }


    @PostMapping("add")
    public String addEmployee(@RequestBody EmployeesDTO dto){
        return employeeService.save(dto);
    }

    @GetMapping("delete/{employeeId}")
    public void delete(@PathVariable Long employeeId){
        employeeService.delete(employeeId);
    }
}
