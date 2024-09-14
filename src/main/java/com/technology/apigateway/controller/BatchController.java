package com.technology.apigateway.controller;


import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.BatchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BatchController extends BaseResponse {

    BatchService batchService;

    @PostMapping("run-batch")
    public ResponseEntity<?> runBatch(HttpServletRequest request, @PathVariable int userId) {
        return response(toResult(batchService.runBatch(userId)));
    }
}
