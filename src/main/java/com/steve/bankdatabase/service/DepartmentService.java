package com.steve.bankdatabase.service;

import com.steve.bankdatabase.entity.Department;
import com.steve.bankdatabase.entity.Employee;
import com.steve.bankdatabase.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentId(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department updateDepartment(Department department, Long id){
        Department existingDepartment = departmentRepository.findById(id).orElse(null);
        existingDepartment.setName(department.getName());
        departmentRepository.save(existingDepartment);
        return existingDepartment;
    }


}
