package com.rest.springbootemployee.controller.mapper;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.rest.springbootemployee.controller.dto.EmployeeRequest;
import com.rest.springbootemployee.controller.dto.EmployeeResponse;
import com.rest.springbootemployee.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequest,employee);
        return employee;
    }

    public EmployeeResponse toResponse(Employee employee){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        BeanUtils.copyProperties(employee, employeeResponse);

        return employeeResponse;
    }

    public List<Employee> toEntity (List<EmployeeRequest> employeesRequest){
        return employeesRequest.stream()
                .map(employeeRequest -> this.toEntity(employeeRequest))
                .collect(Collectors.toList());
    }

    public List<EmployeeResponse> toResponse (List<Employee> employees){
        return employees.stream()
                .map(employee -> this.toResponse(employee))
                .collect(Collectors.toList());
    }
}
