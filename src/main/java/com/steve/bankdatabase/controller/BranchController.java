package com.steve.bankdatabase.controller;
import com.steve.bankdatabase.entity.Branch;
import com.steve.bankdatabase.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;


    @GetMapping("/AllBranches")
    public List<Branch> getBranches(){
        return branchService.getBranches();
    }


    @PutMapping("/update/{id}")
    public Branch updateBranch(@PathVariable Long id, @RequestBody Branch branch){
        return branchService.updateBranch(branch,id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBranch(@PathVariable Long id){
        return branchService.deleteBranch(id);
    }

}
