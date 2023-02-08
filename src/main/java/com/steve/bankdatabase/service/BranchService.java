package com.steve.bankdatabase.service;

import com.steve.bankdatabase.entity.Branch;
import com.steve.bankdatabase.entity.Employee;
import com.steve.bankdatabase.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getBranches() {
        return branchRepository.findAll();
    }

    public Branch getBranchById(Long id) {
        return branchRepository.findById(id).orElse(null);
    }

    public Branch updateBranch(Branch branch, Long id){
        Branch existingBranch = branchRepository.findById(id).orElse(null);
        existingBranch.setCity(branch.getCity());
        existingBranch.setCode(branch.getCode());
        branchRepository.save(existingBranch);
        return existingBranch;
    }

    public String deleteBranch(Long id){
        branchRepository.deleteById(id);
        return "Branch with id number: " + id + " has been deleted.";

    }
}
