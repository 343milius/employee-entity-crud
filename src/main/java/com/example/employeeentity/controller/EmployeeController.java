package com.example.employeeentity.controller;

import com.example.employeeentity.model.Employee;
import com.example.employeeentity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/callback")
    public ResponseEntity getCallBack() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "Awesome!");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public Map saveEmployee(@Valid @RequestBody Employee employee) {
        employeeRepository.save(employee);
        Map<String, Object> map = new HashMap<String, Object>();
        for (Employee newEmployee : employeeRepository.findAll()) {
            if (newEmployee.equals(employee)) {
                map.put("id", newEmployee.getId());
            }
        }
        map.put("operation", Result.EMPLOYEE_ADDED);
        return map;
    }

    @PostMapping("/employees/{id}")
    private Map deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeRepository.deleteById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("operation", Result.EMPLOYEE_DELETED);
        return map;
    }

}
