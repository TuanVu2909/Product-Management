package com.technology.apigateway.controller;

import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.database.entity.DrlSms;
import com.technology.apigateway.models.Dto.DrlSmsDto;
import com.technology.apigateway.service.SMSSendingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/sms")
@Log4j2
@AllArgsConstructor
public class DRLDataController extends BaseResponse {
    @Autowired
    private SMSSendingService smsSendingService;

    @GetMapping("/webHook")
    public ResponseEntity<String> receiveSms(
            @RequestParam String smsid,
            @RequestParam Long receivedts,
            @RequestParam Long deliveredts,
            @RequestParam Integer status,
            @RequestParam String user,
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String text,
            @RequestParam Integer errorcode,
            @RequestParam String carrier,
            @RequestParam Integer mnp
    ) {
        // Tạo DTO từ các thông số request
        DrlSmsDto smsDTO = new DrlSmsDto();
        smsDTO.setSmsid(smsid);
        smsDTO.setReceivedts(receivedts);
        smsDTO.setDeliveredts(deliveredts);
        smsDTO.setStatus(status);
        smsDTO.setUser(user);
        smsDTO.setFrom(from);
        smsDTO.setMobile(to);
        smsDTO.setText(text);
        smsDTO.setErrorcode(errorcode);
        smsDTO.setCarrier(carrier);
        smsDTO.setMnp(mnp);

        // Tạo drlSms từ DTO
        DrlSms smsEntity = new DrlSms();
        smsEntity.setSmsid(smsDTO.getSmsid());
        smsEntity.setReceivedts(smsDTO.getReceivedts());
        smsEntity.setDeliveredts(smsDTO.getDeliveredts());
        smsEntity.setStatus(smsDTO.getStatus());
        smsEntity.setUser(smsDTO.getUser());
        smsEntity.setFrom(smsDTO.getFrom());
        smsEntity.setMobile(smsDTO.getMobile());
        smsEntity.setText(smsDTO.getText());
        smsEntity.setErrorcode(smsDTO.getErrorcode());
        smsEntity.setCarrier(smsDTO.getCarrier());
        smsEntity.setMnp(smsDTO.getMnp());

        // Lưu vào DB
        smsSendingService.saveDrlSms(smsEntity);

        return ResponseEntity.ok("SMS data saved successfully");
    }

    @GetMapping("/get-drlData")
    public ResponseEntity<?> getFindSMSByMobile(HttpServletRequest httpServletRequest) {
        return response(toResult(smsSendingService.findSmsById()));
    }

}
