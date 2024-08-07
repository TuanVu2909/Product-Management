package com.technology.apigateway.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@AllArgsConstructor
public class FileModel {
    private int uid;
    private String name;
    private String status;
    private String url;
    private Long percent;
}
