package com.eaglepatriot.employeeservice.Repository;

import com.eaglepatriot.employeeservice.Model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class EmployeeRepository {
    public List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee){
        employees.add(employee);
        return employee;
    }

    public List<Employee> findAll(){
        return employees;
    }

    public Employee findById(Long id){
        return employees.stream()
                .filter(a -> a.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findByDepartment(Long departmentId){
        return employees.stream()
                .filter(a -> a.departmentId().equals(departmentId))
                .toList();
    }
    public void deleteById(Long id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee a = iterator.next();
            if (a.id().equals(id)) {
                iterator.remove();
                break; // Exit the loop once the department is removed
            }
        }
    }
}
