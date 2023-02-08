package com.steve.bankdatabase.repository;
import com.steve.bankdatabase.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {

}