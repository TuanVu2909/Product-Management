package com.technology.apigateway.controller;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.*;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.AdminUserService;
import com.technology.apigateway.service.AuthService;
import com.technology.apigateway.service.CustomerService;
import com.technology.apigateway.service.FilesStorageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController extends BaseResponse<AuthService> {

    AuthService authenticationService;

    AdminUserService adminUserService;

    FilesStorageService filesStorageService;

    CustomerService customerService;

    @PostMapping("login")
    @Transactional(readOnly = true)
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        return response(toResult(authenticationService.login(request)));
    }

    @GetMapping("get-all-admin-user")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllAdminUser(HttpServletRequest httpServletRequest) {
        return response(toResult(adminUserService.getAllAdminUser()));
    }

    @GetMapping("get-admin-user-by-id/{userid}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAdminUserById(HttpServletRequest httpServletRequest, @PathVariable int userid) {
        return response(toResult(adminUserService.getAdminUserById(userid)));
    }

    @PostMapping("create-admin-user")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createAdminUser(HttpServletRequest httpServletRequest,
                                             @RequestBody AdminUserRequest request) {
        return response(toResult(adminUserService.createAdminUser(request)));
    }

    @PostMapping("update-admin-user")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateAdminUser(HttpServletRequest httpServletRequest,
                                             @RequestBody AdminUserRequest adminUserRequest) {
        return response(toResult(adminUserService.updateAdminUser(adminUserRequest)));
    }

    @PostMapping("delete-file-by-id")
    public ResponseEntity<?> deleteFileById(HttpServletRequest httpServletRequest, @RequestParam int id) {
        return response(toResult(adminUserService.deleteFileById(id)));
    }

    @PostMapping("/delete-file")
    public ResponseEntity<?> deleteFile(HttpServletRequest httpServletRequest, @RequestParam("file") String file,
                                        @RequestParam("custId") String custId, @RequestParam("id") int id) {
        String key = "files";
        log.info("[API DELETE] request param key:{} id", key, custId);
        try {
            return filesStorageService.deleteFile(file, key, custId, id);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
    }

    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadFile(HttpServletRequest httpServletRequest,
                                        @RequestParam("file") MultipartFile[] files,
                                        @RequestParam("custId") String custId,
                                        @RequestParam("saleId") String saleId,
                                        @RequestParam("type") String type,
                                        @RequestParam("regId") Integer regId) {

        String key = "files";
        log.info("[API UPLOAD] request param key:{} id", key, custId);
        try {
            for (int i = 0; i < files.length; i++) {
                filesStorageService.uploadFile(files[i], key, custId, saleId, type, regId);
            }

            return response(toResult("OK"));
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }

    }

    @PostMapping("/get-file")
    public ResponseEntity<?> getFile(HttpServletRequest httpServletRequest,
                                     @RequestBody GetFileRequest request) {
        log.info("[API GET FILE] request param key:{} id", request.getCustId());
        try {
            return filesStorageService.getFile(request.getCustId());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
    }

    public void auto() {
        try {
            System.out.println("~~~~> : " + System.currentTimeMillis());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
    }



    @PostMapping("/get-user-file")
    public ResponseEntity<?> listUserFile(HttpServletRequest httpServletRequest,
                                          @RequestBody GetFileRequest request) {
        log.info("[API GET FILE] request param key:{} id", request.getCustId());
        try {
            return response(toResult(customerService.getUserFile(Integer.parseInt(request.getCustId()))));
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
    }

    @PostMapping("/get-user-file-by-regId")
    public ResponseEntity<?> getUserFileByRegId(HttpServletRequest httpServletRequest,
                                                @RequestBody GetFileRequest request) {
        log.info("[API GET FILE] request param key:{} id", request.getRegId());
        try {
            return response(toResult(customerService.getUserFileByRegId(request.getRegId())));
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
    }

}
