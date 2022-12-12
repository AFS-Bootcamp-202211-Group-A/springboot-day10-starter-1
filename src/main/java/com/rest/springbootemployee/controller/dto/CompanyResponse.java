package com.rest.springbootemployee.controller.dto;

import com.rest.springbootemployee.entity.Employee;

import java.util.List;

public class CompanyResponse {
    private String id;
    private String name;
    private Integer employeeCount;

    public CompanyResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public CompanyResponse() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }
}
