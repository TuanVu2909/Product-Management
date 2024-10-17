package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.DrlSms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrlSmsRepository extends JpaRepository<DrlSms,Long> {
    @Query(value = "SELECT * FROM drlsms WHERE TRUNC(TO_DATE('1970-01-01', 'YYYY-MM-DD') + NUMTODSINTERVAL(receivedts, 'SECOND')) = TRUNC(SYSDATE)", nativeQuery = true)
    List<DrlSms> findDrlSmsById();
}
