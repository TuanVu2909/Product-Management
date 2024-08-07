package com.technology.apigateway.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "USERFILE")
@NamedQuery(name = "UserFile.findAll", query = "SELECT a FROM UserFile a")
public class UserFile {
        @Id
        @Column(name = "ID")
        private int id;

        @Column(name = "FILENAME")
        private String fileName;

        @Column(name = "FILETYPE")
        private String fileType;

        @Column(name = "URL")
        private String url;

        @Column(name = "UPLOADFILE")
        private String uploadFile;

        @Column(name = "LASTDOWNLOADTIME")
        private String lastDownLoadTime;

        @Column(name = "COUNTDOWNLOAD")
        private int countDownload;

        @Column(name = "CUSTOMERID")
        private int customerId;

        @Column(name = "SALEID")
        private int saleId;

        @Column(name = "STATUS")
        private int status;

        @Column(name = "EXTENSION")
        private String extension;

        @Column(name = "REGID")
        private Integer regId;
}
