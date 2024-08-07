package com.technology.apigateway.database.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.AddComment;

@Repository("addCommentRepository")
public interface AddCommentRepository extends CrudRepository<AddComment, String> {

    @Procedure(name = "AddComment.addComment")
    AddComment addComment(@Param("pv_userid") Integer userId, @Param("pv_loanid") Integer loanRegId,
            @Param("pv_comment") String comment);
}
