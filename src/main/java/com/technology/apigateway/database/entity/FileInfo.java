package com.technology.apigateway.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FILEINFO")
@NamedQuery(name = "FileInfo.findAll", query = "SELECT a FROM FileInfo a")
public class FileInfo {

        @Id
        @SequenceGenerator(name = "seq_fileinfo", sequenceName = "seq_fileinfo", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fileinfo")
        private Long id;

        @Column(name = "FILENAME")
        private String fileName;

        @Column(name = "FILEURL")
        private String fileUrl;

        @Column(name = "CUSTID")
        private Integer custId;

        @Column(name = "STATUS")
        private Integer status;

        @Column(name = "PATH")
        private String path;

}
