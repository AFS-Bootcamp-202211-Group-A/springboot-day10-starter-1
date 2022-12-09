package com.rest.springbootemployee.controller.dto;

import com.rest.springbootemployee.entity.Employee;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

public class CompanyRequest {

    private String name;

    public CompanyRequest(String name) {
        this.name = name;
    }

    public CompanyRequest(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
