package com.rest.springbootemployee.controller.dto;

import com.rest.springbootemployee.entity.Employee;

import java.util.List;

public class CompanyRequest {
    private String name;
    private List<Employee> employees;
    public CompanyRequest(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
