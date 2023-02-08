package com.steve.bankdatabase.repository;
import com.steve.bankdatabase.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}