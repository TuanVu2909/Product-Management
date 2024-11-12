package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.FileInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("fileInfoRepository")
public interface FileInfoRepository extends CrudRepository<FileInfo, Long> {

    @Query(value = "select * from fileinfo where custid = ?1 and status <> 3", nativeQuery = true)
    List<FileInfo> findAllByCustId(String custId);

    @Transactional
    @Modifying
    @Query(value = "update fileinfo set status = 3 where custid = ?1 and filename = ?2", nativeQuery = true)
    void deleteUpdate(String custId, String fileName);
}
