package com.technology.apigateway.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.Branch;

@Repository("branchRepository")
public interface BranchRepository extends CrudRepository<Branch, String> {

    @Procedure("Branch.getAllBranch")
    List<Branch> getAllBranch();

    @Procedure("Branch.getBranchByUserId")
    List<Branch> getBranchByUserId(@Param("pv_userid") String userId);

}
