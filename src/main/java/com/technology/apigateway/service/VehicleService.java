package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.CalculatePrice;
import com.technology.apigateway.controller.request.VehicleCompanyRequest;
import com.technology.apigateway.controller.request.VehicleRequest;
import com.technology.apigateway.controller.request.VehicleStateRequest;
import com.technology.apigateway.controller.request.VehicleTypeRequest;
import com.technology.apigateway.database.entity.CalculatorStatus;
import com.technology.apigateway.database.entity.VehicleCompany;
import com.technology.apigateway.database.entity.VehicleState;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    CalculatorStatus calculatePrice(CalculatePrice calculatePrice);

    List<VehicleTypeRequest> getAllVehicleTypeByTypeId(int vehicleCompanyId);

    List<VehicleTypeRequest> getAllVehicleType();

    Optional<VehicleCompany> getVehicleCompanyById(int vehicleId);

    List<VehicleCompanyRequest> getAllVehicleCompany();
    List<VehicleRequest> getAllVehicle();
    List<VehicleRequest> getVehicleByCompanyId(int companyId);

    // lấy hãng phương tiện theo kiểu phương tiện
    List<VehicleCompanyRequest> getCompanyByTypeId(int typeId);

    List<VehicleState> getVehicleState(VehicleStateRequest vehicleStateRequest);


}
