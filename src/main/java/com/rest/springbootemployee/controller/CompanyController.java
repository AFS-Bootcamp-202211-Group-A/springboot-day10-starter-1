package com.rest.springbootemployee.controller;

import com.rest.springbootemployee.controller.dto.CompanyRequest;
import com.rest.springbootemployee.controller.dto.CompanyResponse;
import com.rest.springbootemployee.controller.dto.EmployeeRequest;
import com.rest.springbootemployee.controller.dto.EmployeeResponse;
import com.rest.springbootemployee.controller.mapper.CompanyMapper;
import com.rest.springbootemployee.controller.mapper.EmployeeMapper;
import com.rest.springbootemployee.entity.Company;
import com.rest.springbootemployee.service.CompanyService;
import com.rest.springbootemployee.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;
    private CompanyMapper companyMapper;
    private EmployeeMapper employeeMapper;

    public CompanyController(CompanyService companyService, CompanyMapper companyMapper, EmployeeMapper employeeMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping
    public List<CompanyResponse> getAll() {
        List<Company> companies = companyService.findAll();
        return companyMapper.toResponse(companies);
    }

    @GetMapping("/{id}")
    public CompanyResponse getById(@PathVariable String id) {
        Company company = companyService.findById(id);
        return companyMapper.toResponse(company);
    }

    @GetMapping("/{id}/employees")
    public List<EmployeeResponse> getEmployees(@PathVariable String id) {
        return employeeMapper.toResponse(companyService.getEmployees(id));
    }

    @GetMapping(params = {"page", "pageSize"})
    public List<CompanyResponse> getByPage(Integer page, Integer pageSize) {
        List<Company> companies = companyService.findByPage(page, pageSize);
        return companyMapper.toResponse(companies);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Company create(@RequestBody CompanyRequest companyRequest) {
        Company company = companyMapper.toEntity(companyRequest);
        return companyService.create(company);
    }

    @PutMapping("/{id}")
    public Company update(@PathVariable String id, @RequestBody CompanyRequest companyRequest) {
        Company company = companyMapper.toEntity(companyRequest);
        return companyService.update(id, company);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable String id) {
        companyService.delete(id);
    }
}
