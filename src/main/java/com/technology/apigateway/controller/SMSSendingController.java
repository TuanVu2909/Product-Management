package com.technology.apigateway.controller;


import com.technology.apigateway.controller.request.SMSSendingRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.SMSSendingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@Log4j2
@AllArgsConstructor
public class SMSSendingController extends BaseResponse {

    SMSSendingService smsSendingService;

    @PostMapping("/send-sms")
    public ResponseEntity<?> sendSms(@RequestBody SMSSendingRequest request) {
        return response(toResult(smsSendingService.callSMSSendingAPI(request)));
    }
}
