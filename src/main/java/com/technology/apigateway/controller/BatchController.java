package com.technology.apigateway.controller;


import com.technology.apigateway.controller.request.BatchRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.BatchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Transactional(readOnly = true)
    public ResponseEntity<?> runBatch(HttpServletRequest request, @RequestBody BatchRequest batchRequest) {
        return response(toResult(batchService.runBatch(batchRequest)));
    }
}
