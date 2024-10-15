package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.DrlSms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrlSmsRepository extends JpaRepository<DrlSms,Long> {
    @Query(value = "select * from drlsms where smsid  not in (select id from sms)", nativeQuery = true)
    List<DrlSms> findDrlSmsById();
}
