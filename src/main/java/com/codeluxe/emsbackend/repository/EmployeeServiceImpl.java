package com.codeluxe.emsbackend.repository;

import com.codeluxe.emsbackend.dto.EmployeeDTO;
import com.codeluxe.emsbackend.entity.Employee;
import com.codeluxe.emsbackend.exception.EmployeeNotFoundException;
import com.codeluxe.emsbackend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;


    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );
        repository.save(employee);
    }

    @Override
    public EmployeeDTO findEmployeeById(final Long id) {
        val employee = repository.findById(id);
        return employee.map(EmployeeDTO::from).orElse(null);
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return repository.findAll().stream().map(EmployeeDTO::from).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(final Long id, final EmployeeDTO employeeDTO) {
        val employee = repository.findById(id).orElseThrow(
                ()-> new EmployeeNotFoundException("Employee with an id "+id+" does not exist."));
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        repository.save(employee);

        return EmployeeDTO.from(employee);
    }

    @Override
    public EmployeeDTO removeEmployee(final Long id) {
        val employee = repository.findById(id).orElseThrow(
                ()-> new EmployeeNotFoundException("Employee not found."));
        repository.deleteById(id);

        return EmployeeDTO.from(employee);
    }
}
