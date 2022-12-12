package com.rest.springbootemployee.controller.mapper;

import com.rest.springbootemployee.controller.dto.CompanyRequest;
import com.rest.springbootemployee.controller.dto.CompanyResponse;
import com.rest.springbootemployee.entity.Company;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapper {
    public Company toEntity(CompanyRequest companyRequest){
        Company company = new Company();
        BeanUtils.copyProperties(companyRequest,company);
        return company;
    }
    public CompanyResponse toResponse(Company company){
        CompanyResponse companyResponse = new CompanyResponse();
        BeanUtils.copyProperties(company, companyResponse);
        Integer companyEmployeesCount = company.getEmployeeCount();
        companyResponse.setEmployeesCount(companyEmployeesCount);
        return companyResponse;
    }
    public List<Company> toEntity (List<CompanyRequest> companiesRequest){
        return companiesRequest.stream()
                .map(companyRequest -> this.toEntity(companyRequest))
                .collect(Collectors.toList());
    }
    public List<CompanyResponse> toResponse (List<Company> companies){
        return companies.stream()
                .map(company -> this.toResponse(company))
                .collect(Collectors.toList());
    }
}
