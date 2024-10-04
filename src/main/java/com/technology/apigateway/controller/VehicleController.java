package com.technology.apigateway.controller;

import com.technology.apigateway.controller.request.CalculatePrice;
import com.technology.apigateway.controller.request.VehicleStateRequest;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.service.VehicleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VehicleController extends BaseResponse {

    VehicleService vehicleService;

    // get ra kieu phuong tien
    @GetMapping("get-all-vehicle-type-id")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllVehicleTypeByTypeID(HttpServletRequest httpServletRequest) {
        return response(toResult(vehicleService.getAllVehicleType()));
    }

    // get ra kieu phuong tien
    @GetMapping("get-all-vehicle-type")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllVehicleType(HttpServletRequest httpServletRequest) {
        return response(toResult(vehicleService.getAllVehicleType()));
    }

    @GetMapping("get-all-vehicle-company")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllVehicleCompany(HttpServletRequest httpServletRequest) {
        return response(toResult(vehicleService.getAllVehicleCompany()));
    }

    @GetMapping("get-all-vehicle")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllVehicle(HttpServletRequest httpServletRequest) {
        return response(toResult(vehicleService.getAllVehicle()));
    }

    @GetMapping("get-company-by-TypeId/{typeId}") // truyền vào Id ở bảng vehicleType - kiểu phương tiện
    @Transactional(readOnly = true)
    public ResponseEntity<?> getCompanyByType(HttpServletRequest httpServletRequest, @PathVariable int typeId) {
        return response(toResult(vehicleService.getCompanyByTypeId(typeId)));
    }

    @GetMapping("get-vehicleCompany-by-Id/{id}") // truyền vào id ở bảng vehicleCompany
    @Transactional(readOnly = true)
    public ResponseEntity<?> getVehicleCompanyById(HttpServletRequest httpServletRequest, @PathVariable int id){
        return response(toResult(vehicleService.getVehicleCompanyById(id)));
    }

    @GetMapping("get-vehicle-by-CompanyId/{companyId}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getVehicleByVehicleCompanyId(HttpServletRequest httpServletRequest,
            @PathVariable int companyId) {
        return response(toResult(vehicleService.getVehicleByCompanyId(companyId)));
    }

    @PostMapping("calculate-price")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateAdminUser(HttpServletRequest httpServletRequest,
            @RequestBody CalculatePrice calculatePrice) {
        return response(toResult(vehicleService.calculatePrice(calculatePrice)));
    }

    @PostMapping("get-vehicle-state")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getVehicleState(HttpServletRequest httpServletRequest,
                                             @RequestBody VehicleStateRequest request){
        return response(toResult(vehicleService.getVehicleState(request)));
    }

}
