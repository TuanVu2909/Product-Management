package com.technology.apigateway.database.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.technology.apigateway.database.entity.UserFile;

@Repository("userFileRepository")
public interface UserFileRepository extends CrudRepository<UserFile, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into userfile (ID, FILENAME, FILETYPE, URL, LASTDOWNLOADTIME, COUNTDOWNLOAD, CUSTOMERID, SALEID, STATUS, EXTENSION, REGID) values (seq_userfile.nextval, :fileName, :fileType, :url, sysdate, 0, :customerId, :saleId, 1, :extension, :regId)", nativeQuery = true)
    void insertRow(@Param("fileName") String fileName,
                   @Param("fileType") String fileType,
                   @Param("url") String url,
                   @Param("customerId") Integer customerId,
                   @Param("saleId") Integer saleId,
                   @Param("extension") String extension,
                   @Param(("regId")) Integer regId);

    @Query(value = "SELECT * FROM userfile where customerId = :custId", nativeQuery = true)
    List<UserFile> getFileByUserId(@Param("custId") Integer custId);

    @Query(value = "SELECT * FROM userfile where regId = :regId", nativeQuery = true)
    List<UserFile> getFileByRegId(@Param("regId") Integer regId);
}
