package com.codeluxe.emsbackend.controller;

import com.codeluxe.emsbackend.dto.EmployeeDTO;

import com.codeluxe.emsbackend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody final EmployeeDTO dto) {
            service.addEmployee(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> retrieveAllEmployees() {
        return new ResponseEntity<>(service.findAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<EmployeeDTO> retrieveEmployeeById(@PathVariable final Long id) {
        return new ResponseEntity<>(service.findEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable final Long id, @RequestBody final EmployeeDTO employeeDetails) {
        return new ResponseEntity<>(service.updateEmployee(id, employeeDetails), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<EmployeeDTO> removeEmployee(@PathVariable final Long id) {
        return new ResponseEntity<>(service.removeEmployee(id), HttpStatus.OK);
    }



}
