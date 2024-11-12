package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.Constants;
import com.technology.apigateway.controller.request.SMSSendingRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.database.entity.SMSEntity;
import com.technology.apigateway.database.repository.SmsRepository;
import com.technology.apigateway.service.SMSSendingService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

@Service
public class SMSSendingServiceImpl extends BaseResponse<SMSSendingService> implements SMSSendingService {
    @Autowired
    private SmsRepository smsRepository;

    public String callSMSSendingAPI(SMSSendingRequest sendingRequest) {
        String jsonResponse = "";
        String[] urls = {
                Constants.SOUTH_TELECOM_SMS_API_URI_1,
                Constants.SOUTH_TELECOM_SMS_API_URI_2
        };

        for (String apiUrl : urls) {
            try {
                URL url = new URL(apiUrl);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setUseCaches(false);
                con.setDoOutput(true);
                con.setDoInput(true);

                String auth = "finy_api:5TK4CcuV";
                String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes("UTF-8"));
                String authHeaderValue = "Basic " + encodedAuth;

                con.setRequestProperty("Authorization", authHeaderValue);
                con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                con.setRequestProperty("Accept", "application/json; charset=UTF-8");
                con.setRequestMethod("POST");

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("smsid", sendingRequest.getSmsId());
                jsonObject.put("from", "FINY");
                jsonObject.put("to", sendingRequest.getTo());
                jsonObject.put("text", sendingRequest.getText());
                jsonObject.put("unicode", sendingRequest.getUnicode());
                jsonObject.put("dlr", sendingRequest.getDlr());

                logger.info("strJsonBody:\n" + jsonObject.toString());

                byte[] sendBytes = jsonObject.toString().getBytes("UTF-8");
                con.setFixedLengthStreamingMode(sendBytes.length);

                OutputStream outputStream = con.getOutputStream();
                outputStream.write(sendBytes);

                int httpResponse = con.getResponseCode();
                logger.info("httpResponse: " + httpResponse);

                if (httpResponse >= HttpURLConnection.HTTP_OK && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
                    Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
                    jsonResponse = scanner.useDelimiter("/A").hasNext() ? scanner.next() : "";
                    scanner.close();
                    break; // Nếu gửi thành công, thoát khỏi vòng lặp
                } else {
                    Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
                    jsonResponse = scanner.useDelimiter("/A").hasNext() ? scanner.next() : "";
                    scanner.close();
                }

                logger.info("jsonResponse:\n" + jsonResponse);

            } catch (Throwable t) {
                logger.error("Error while sending SMS using URL: " + apiUrl, t);
                t.printStackTrace();
                // Thử với URL tiếp theo nếu có lỗi
            }
        }

        return jsonResponse;

    }
    @Override
    public List<SMSEntity> getLogs(){

        List<SMSEntity> entityList = null;
        try {
            entityList = smsRepository.finSmsByMobile();
        }
        catch(Exception e){
            logger.error("error => "+e.getMessage());
        }
        return entityList ;
    }

    @Transactional
    public List<SMSEntity> getFindSMSByMobile() {
        List<SMSEntity> smsEntityList = null;
        try {
            smsEntityList = smsRepository.finSmsByMobile();
            if (smsEntityList != null){
                for (SMSEntity sms : smsEntityList) {
                    String toMobile = sms.getToMobile();
                    String text = sms.getText();
                    int id = sms.getId();
                    String smsid = Integer.toString(id);
                    if (toMobile != null && text != null) {
                        SMSSendingRequest request = new SMSSendingRequest();
                        request.setSmsId(smsid);
                        request.setTo(toMobile);
                        request.setText(text);
                        String response = callSMSSendingAPI(request);

                        if (response != null) {
                            sms.setStatus(1);
                            smsRepository.save(sms);
                            logger.info("SMS sent successfully to " + toMobile);

                        } else {
                            logger.error("Failed to send SMS to " + toMobile);
                        }
                    }
                }
                return smsEntityList;
            }else {
                logger.warn("No SMS records found.");
                return null;
            }

        } catch (Exception e) {
            logger.error("Error in getFindAllSMS: " + e.getMessage());
        }
        return smsEntityList;
    }




}