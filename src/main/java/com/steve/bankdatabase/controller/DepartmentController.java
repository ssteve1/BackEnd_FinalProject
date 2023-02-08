package com.steve.bankdatabase.controller;
import com.steve.bankdatabase.entity.Department;
import com.steve.bankdatabase.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/add")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }
    @GetMapping("/AllDepartments")
    public List<Department > getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/findDepartmentById/{id}")
    public Department getDepartmentByIdById(@PathVariable Long id){
        return departmentService.getDepartmentId(id);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department){
        return departmentService.updateDepartment(department,id);
    }


}
