package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.incomes.CreateIncomesRequest;
import com.technology.apigateway.controller.request.incomes.UpdateIncomesRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.IncomesService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IncomesController extends BaseResponse {

    IncomesService incomesService;

    @PostMapping("create-incomes")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createIncomes(HttpServletRequest httpServletRequest,
                                           @RequestBody CreateIncomesRequest createIncomesRequest) {
        return response(toResult(incomesService.createIncomes(createIncomesRequest)));
    }

    @PostMapping("update-incomes")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateIncomes(HttpServletRequest httpServletRequest,
                                             @RequestBody UpdateIncomesRequest updateReferenceRequest) {
        return response(toResult(incomesService.updateIncomes(updateReferenceRequest)));
    }

    @PostMapping("delete-incomes-by-id")
    public ResponseEntity<?> deleteIncomeById(@RequestParam int id) {
        return response(toResult(incomesService.deleteIncomesById(id)));
    }

}
