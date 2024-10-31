package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.SMSEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsRepository extends CrudRepository<SMSEntity,String> {
//    @Transactional
//    @Procedure("SMSEntity.findSMSMobile")
//    List<SMSEntity> finAllSms();
@Query(value = "select s.id,s.tomobile,s.text,s.status from sms s where TRUNC(s.createddate) = TRUNC(SYSDATE)and s.status = 0", nativeQuery = true)
List<SMSEntity> finSmsByMobile();

@Query(value = "select s.id,s.tomobile,s.text,s.status from sms s where TRUNC(s.createddate) = TRUNC(SYSDATE)and s.status <> 0", nativeQuery = true)
List<SMSEntity> finSmsByStatus();
}
