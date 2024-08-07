package com.technology.apigateway.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.UserComment;

@Repository("commentRepository")
public interface CommentRepository extends CrudRepository<UserComment, Integer> {

    // @Procedure(name = "UserComment.getAllCommentByLoanRegId")
    // List<UserComment> getAllCommentByLoanRegId(@Param("pv_loanid") int loanId);

    @Query(value = "Select u.*, a.full_name fullname, c.name role\r\n" + //
            "          From usercomment u, admin_user a, allcode c\r\n" + //
            "         Where a.user_id = u.userid\r\n" + //
            "         and c.code = a.role\r\n" + //
            "         and c.type = 'ROLE'\r\n" + //
            "         and u.loanregid = :loanid order by u.id desc", nativeQuery = true)
    List<UserComment> getAllCommentByLoanRegId(@Param("loanid") Integer loanid);
}
