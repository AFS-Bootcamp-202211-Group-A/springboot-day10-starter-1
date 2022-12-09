package com.rest.springbootemployee.controller.dto;
import com.rest.springbootemployee.entity.Employee;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class CompanyResponse {

    private String id;
    private String name;
    private Integer employeesCount;

    public CompanyResponse(String id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employeesCount = employees.size();
    }

    public CompanyResponse() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Integer employeesCount) {
        this.employeesCount = employeesCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}