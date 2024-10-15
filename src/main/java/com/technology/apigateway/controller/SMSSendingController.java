package com.technology.apigateway.controller;


import com.technology.apigateway.controller.request.SMSSendingRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.database.entity.SMSEntity;
import com.technology.apigateway.service.SMSSendingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api")
@Log4j2
@AllArgsConstructor
public class SMSSendingController extends BaseResponse {

    SMSSendingService smsSendingService;

    @PostMapping("/send-sms")
    public ResponseEntity<?> sendSms(HttpServletRequest httpServletRequest,@RequestBody SMSSendingRequest request) {
        return response(toResult(smsSendingService.callSMSSendingAPI(request)));
    }

    @GetMapping("/find-sms-mobile")
    public ResponseEntity<?> getFindSMSByMobile(HttpServletRequest httpServletRequest) {
        return response(toResult(smsSendingService.getFindSMSByMobile()));
    }

    @GetMapping("/get-sms")
    public ResponseEntity<?> getLog(HttpServletRequest httpServletRequest) {
        return response(toResult(smsSendingService.getLogs()));
    }
}