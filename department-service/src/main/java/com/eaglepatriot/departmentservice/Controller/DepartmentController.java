package com.eaglepatriot.departmentservice.Controller;

import com.eaglepatriot.departmentservice.Client.EmployeeClient;
import com.eaglepatriot.departmentservice.Model.Department;
import com.eaglepatriot.departmentservice.Repository.DeparmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController{

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DeparmentRepository deparmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return deparmentRepository.addDepartments(department);
    }

    @GetMapping
    public List<Department> findAll() {
        LOGGER.info("Department find");
        return deparmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department find: id={}",id);
        return deparmentRepository.findById(id); 
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department find");
        List<Department> departments =
                deparmentRepository.findAll();
        departments.forEach(department ->
                department.setEmployees(
                        employeeClient.findByDepartment(department.getId())));
        return departments;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        LOGGER.info("department delete: id={}",id);
        deparmentRepository.deleteById(id);
        return "Record deleted";
    }

}
