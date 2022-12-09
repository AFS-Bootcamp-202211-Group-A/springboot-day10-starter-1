package com.rest.springbootemployee.controller.mapper;

import com.rest.springbootemployee.controller.dto.CompanyResponse;
import com.rest.springbootemployee.entity.Company;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public CompanyResponse toResponse(Company company) {
        CompanyResponse companyResponse = new CompanyResponse();
        int size = 0;
        if (company.getEmployees() != null) {
            size = company.getEmployees().size();
        }
        BeanUtils.copyProperties(company, companyResponse);
        companyResponse.setEmployeeCount(size);
        return companyResponse;
    }
}
