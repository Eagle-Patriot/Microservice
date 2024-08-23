package com.eaglepatriot.employeeservice.Controller;

import com.eaglepatriot.employeeservice.Model.Employee;
import com.eaglepatriot.employeeservice.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger LOGGER
            = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Department add: {}", employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        LOGGER.info("Employee find");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("Employee find: id={}",id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable Long departmentId){
        LOGGER.info("Employee find: departmentId={}",departmentId);
        return employeeRepository.findByDepartment(departmentId);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        LOGGER.info("Employee delete: id={}",id);
        employeeRepository.deleteById(id);
        return "Record deleted";
    }
}
