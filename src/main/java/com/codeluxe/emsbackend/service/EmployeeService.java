package com.codeluxe.emsbackend.service;

import com.codeluxe.emsbackend.dto.EmployeeDTO;
import com.codeluxe.emsbackend.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    void addEmployee(final EmployeeDTO employeeDTO);

    EmployeeDTO findEmployeeById(final Long id);

    List<EmployeeDTO> findAllEmployees();

    EmployeeDTO updateEmployee(final Long id, final EmployeeDTO employeeDTO);

    EmployeeDTO removeEmployee(final Long id);

}
