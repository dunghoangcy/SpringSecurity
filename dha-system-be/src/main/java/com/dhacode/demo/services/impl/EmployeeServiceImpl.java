package com.dhacode.demo.services.impl;

import com.dhacode.demo.dto.EmployeesDTO;
import com.dhacode.demo.entity.Employees;
import com.dhacode.demo.mapper.EmployeeMapper;
import com.dhacode.demo.repository.EmployeeRepository;
import com.dhacode.demo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeesDTO> findAll() {
        List<Employees> emp = employeeRepository.findAll();
        List<EmployeesDTO> empDTOs = new ArrayList<EmployeesDTO>();
        emp.forEach(employee -> empDTOs.add(EmployeeMapper.mapToEmployeesDTO(employee)));
        return empDTOs;
    }
    @Override
    public String save(EmployeesDTO dto) {
        Employees e = new Employees();
        Optional<EmployeesDTO> opDTO = Optional.ofNullable(dto);
        if (opDTO.get().getFirstName() != null &&   opDTO.get().getLastName() != null && opDTO.get().getEmail() != null) {
            e = EmployeeMapper.mapToEmployees(opDTO.get());
            employeeRepository.save(e);
            return "Add New Employee Successfully";
        }else {
            return "Employee Add Failed";
        }
    }

    @Override
    public void delete(Long id) {
          employeeRepository.deleteById(id);
    }



}
