package com.codeluxe.emsbackend.dto;

import com.codeluxe.emsbackend.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Optional;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public static EmployeeDTO from(Employee employee) {
        return builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
    }

}
