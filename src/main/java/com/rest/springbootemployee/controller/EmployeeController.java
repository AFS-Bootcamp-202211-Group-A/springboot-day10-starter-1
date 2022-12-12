package com.rest.springbootemployee.controller;

import com.rest.springbootemployee.controller.dto.EmployeeRequest;
import com.rest.springbootemployee.controller.dto.EmployeeResponse;
import com.rest.springbootemployee.controller.mapper.EmployeeMapper;
import com.rest.springbootemployee.entity.Employee;
import com.rest.springbootemployee.exception.InvalidIdException;
import com.rest.springbootemployee.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    private void validateObjectId(String id){
        if(!ObjectId.isValid(id)){
            throw new InvalidIdException();
        }
    }

    @GetMapping
    public List<EmployeeResponse> getAll() {
        List<Employee> employees = employeeService.findAll();
        return employeeMapper.toResponse(employees);
    }

    @GetMapping("/{id}")
    public EmployeeResponse getById(@PathVariable String id) {
        validateObjectId(id);
        Employee employee = employeeService.findById(id);
        return employeeMapper.toResponse(employee);
    }

    @GetMapping(params = {"gender"})
    public List<EmployeeResponse> getByGender(@RequestParam String gender) {
        List<Employee> employees = employeeService.findByGender(gender);
        return employeeMapper.toResponse(employees);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee add(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.toEntity(employeeRequest);
        return employeeService.create(employee);
    }
    @PutMapping("/{id}")
    public Employee update(@PathVariable String id, @RequestBody EmployeeRequest employeeRequest) {
        validateObjectId(id);
        Employee employee = employeeMapper.toEntity(employeeRequest);
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        validateObjectId(id);
        employeeService.delete(id);
    }


    @GetMapping(params = {"page", "pageSize"})
    public List<EmployeeResponse> getByPage(int page, int pageSize) {
        List<Employee> employees = employeeService.findByPage(page, pageSize);
        return employeeMapper.toResponse(employees);
    }

}
