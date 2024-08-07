package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.incomes.UpdateIncomesRequest;
import com.technology.apigateway.controller.request.references.UpdateReferenceRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.IncomesService;
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
public class IncomesController extends BaseResponse {

    @Autowired
    IncomesService incomesService;

    @PostMapping("update-incomes")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateIncomes(HttpServletRequest httpServletRequest,
                                             @RequestBody UpdateIncomesRequest updateReferenceRequest) {
        return response(toResult(incomesService.updateIncomes(updateReferenceRequest)));
    }

}
