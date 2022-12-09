package com.rest.springbootemployee.controller.dto;

import com.rest.springbootemployee.entity.Employee;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class CompanyResponse {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String name;
    private List<Employee> employees;

    public CompanyResponse(String id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public CompanyResponse() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
