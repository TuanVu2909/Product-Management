package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.SimilarAssetsRequest;
import com.technology.apigateway.controller.request.references.UpdateReferenceRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.SimilarAssetsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Log4j2
public class SimilarAssetsController extends BaseResponse {

    @Autowired
    SimilarAssetsService similarAssetsService;

    @PostMapping("update-similarAssets")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateSimilarAssets(HttpServletRequest httpServletRequest,
                                             @RequestBody SimilarAssetsRequest similarAssetsRequest) {
        return response(toResult(similarAssetsService.updateSimilarAssets(similarAssetsRequest)));
    }


}
