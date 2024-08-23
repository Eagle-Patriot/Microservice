package com.eaglepatriot.departmentservice.Repository;

import com.eaglepatriot.departmentservice.Model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class DeparmentRepository{
    private List<Department> departments = new ArrayList<>();

    public Department addDepartments(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Long id){
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll(){
        return departments;
    }

    public void deleteById(Long id) {
        Iterator<Department> iterator = departments.iterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            if (department.getId().equals(id)) {
                iterator.remove();
                break; // Exit the loop once the department is removed
            }
        }
    }
}
