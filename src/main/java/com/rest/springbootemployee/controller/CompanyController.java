package com.rest.springbootemployee.controller;

import com.rest.springbootemployee.controller.dto.CompanyRequest;
import com.rest.springbootemployee.controller.dto.CompanyResponse;
import com.rest.springbootemployee.controller.mapper.CompanyMapper;
import com.rest.springbootemployee.entity.Company;
import com.rest.springbootemployee.exception.IdInvalidException;
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

    public CompanyController(CompanyService companyService, CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }

    @GetMapping
    public List<CompanyResponse> getAll() {
        return companyMapper.toResponseList(companyService.findAll());
    }

    //to do
    @GetMapping("/{id}")
    public CompanyResponse getById(@PathVariable String id) {
        if (!id.isEmpty()){
            return companyMapper.toResponse(companyService.findById(id));
        }
        throw new IdInvalidException();
    }


    @GetMapping("/{id}/employees")
    public List<Employee> getEmployees(@PathVariable String id) {
        return companyService.getEmployees(id);
    }

    @GetMapping(params = {"page", "pageSize"})
    public List<Company> getByPage(Integer page, Integer pageSize) {
        return companyService.findByPage(page, pageSize);
    }

    //to do
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyResponse create(@RequestBody CompanyRequest companyRequest) {
        return companyMapper.toResponse(companyService.create(companyMapper.toEntity(companyRequest)));
    }

    //to do
    @PutMapping("/{id}")
    public CompanyResponse update(@PathVariable String id, @RequestBody CompanyRequest companyRequest) {
        if (!id.isEmpty()){
            return companyMapper.toResponse(companyService.update(id, companyMapper.toEntity(companyRequest)));
        }
        throw new IdInvalidException();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable String id) {
        System.out.println("ID: "+ id);
        if (!id.isEmpty() && id.trim().length() > 0){
            companyService.delete(id);
        }
        else {
            throw new IdInvalidException();
        }
    }
}
