package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.references.ReferenceRequest;
import com.technology.apigateway.controller.request.references.UpdateReferenceRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.ReferenceService;
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
public class ReferenceController extends BaseResponse {

    ReferenceService referenceService;

    @PostMapping("create-reference")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createReference(HttpServletRequest httpServletRequest,
                                             @RequestBody ReferenceRequest referenceRequest) {
        return response(toResult(referenceService.createReference(referenceRequest)));
    }

    @PostMapping("update-reference")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateReference(HttpServletRequest httpServletRequest,
                                             @RequestBody UpdateReferenceRequest updateReferenceRequest) {
        return response(toResult(referenceService.updateReference(updateReferenceRequest)));
    }

    @PostMapping("delete-reference-by-id")
    public ResponseEntity<?> deleteReferencesById(@RequestParam int id) {
        return response(toResult(referenceService.deleteReferencesById(id)));
    }
}
