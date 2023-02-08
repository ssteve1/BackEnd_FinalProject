package com.steve.bankdatabase.repository;
import com.steve.bankdatabase.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}