package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.CalculatePrice;
import com.technology.apigateway.controller.request.VehicleCompanyRequest;
import com.technology.apigateway.controller.request.VehicleRequest;
import com.technology.apigateway.controller.request.VehicleStateRequest;
import com.technology.apigateway.controller.request.VehicleTypeRequest;
import com.technology.apigateway.database.entity.CalculatorStatus;
import com.technology.apigateway.database.entity.Vehicle;
import com.technology.apigateway.database.entity.VehicleCompany;
import com.technology.apigateway.database.entity.VehicleState;
import com.technology.apigateway.database.entity.VehicleType;
import com.technology.apigateway.database.repository.CalculatorRepository;
import com.technology.apigateway.database.repository.VehicleCompanyRepository;
import com.technology.apigateway.database.repository.VehicleRepository;
import com.technology.apigateway.database.repository.VehicleStateRepository;
import com.technology.apigateway.database.repository.VehicleTypeRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleStateRepository vehicleStateRepository;

    @Autowired
    private VehicleCompanyRepository vehicleCompanyRepository;

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    private CalculatorRepository calculatorRepository;

    @Override
    public CalculatorStatus calculatePrice(CalculatePrice calculatePrice) {
        CalculatorStatus reStatus = calculatorRepository.finalCalPrice(
                calculatePrice.getVehicleId(),
                calculatePrice.getVehicleAge(),
                calculatePrice.getBt(),
                calculatePrice.getDbm(),
                calculatePrice.getDkmn(),
                calculatePrice.getRrdn(),
                calculatePrice.getBdmm(),
                calculatePrice.getTngt(),
                calculatePrice.getTk(),
                calculatePrice.getDnnv(),
                calculatePrice.getSx());
        return reStatus;
    }

    @Override
    public List<VehicleTypeRequest> getAllVehicleTypeByTypeId(int vehicleCompanyId) {
        List<VehicleType> vehicleTypeList = vehicleTypeRepository.getAllVehicleType();
        if (vehicleTypeList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Vehicle Type");
        }
        List<VehicleTypeRequest> vehicleRequestList = new ArrayList<>();
        for (VehicleType vehicleType : vehicleTypeList) {
            VehicleTypeRequest vehicleTypeRequest = new VehicleTypeRequest();
            vehicleTypeRequest.setId(vehicleType.getId());
            vehicleTypeRequest.setName(vehicleType.getName());
            vehicleRequestList.add(vehicleTypeRequest);
        }
        return vehicleRequestList;
    }

    @Override
    public List<VehicleTypeRequest> getAllVehicleType() {
        List<VehicleType> vehicleTypeList = vehicleTypeRepository.getAllVehicleType();
        if (vehicleTypeList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Vehicle Type");
        }
        List<VehicleTypeRequest> vehicleRequestList = new ArrayList<>();
        for (VehicleType vehicleType : vehicleTypeList) {
            VehicleTypeRequest vehicleTypeRequest = new VehicleTypeRequest();
            vehicleTypeRequest.setId(vehicleType.getId());
            vehicleTypeRequest.setName(vehicleType.getName());
            vehicleTypeRequest.setType(vehicleType.getType());
            vehicleRequestList.add(vehicleTypeRequest);
        }
        return vehicleRequestList;
    }

    @Override
    public Optional<VehicleCompany> getVehicleCompanyById(int id) {
        Optional<VehicleCompany> vehicleList = vehicleCompanyRepository.findById(id);
        return vehicleList;
    }

    @Override
    public List<VehicleRequest> getAllVehicle() {
        List<Vehicle> vehicleList = vehicleRepository.getAllVehicle();
        if (vehicleList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Vehicle");
        }
        List<VehicleRequest> vehicleRequestList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            VehicleRequest vehicleRequest = new VehicleRequest();
            vehicleRequest.setId(vehicle.getId());
            vehicleRequest.setName(vehicle.getName());
            vehicleRequest.setCompanyId(vehicle.getCompanyId());
            vehicleRequestList.add(vehicleRequest);
        }
        return vehicleRequestList;
    }

    @Override
    public List<VehicleRequest> getVehicleByCompanyId(int vehicleCompanyId) {
        List<Vehicle> vehicleList = vehicleRepository.getVehicleByCompanyId(vehicleCompanyId);
        if (vehicleList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Vehicle");
        }
        List<VehicleRequest> vehicleRequestList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            VehicleRequest vehicleRequest = new VehicleRequest();
            vehicleRequest.setId(vehicle.getId());
            vehicleRequest.setName(vehicle.getName());
            vehicleRequest.setCompanyId(vehicle.getCompanyId());
            vehicleRequestList.add(vehicleRequest);
        }
        return vehicleRequestList;
    }

    // lấy kiểu hãng xe theo kiểu phương tiện - ví dụ Mazda thì trong hãng
    // ô tô
    @Override
    public List<VehicleCompanyRequest> getCompanyByTypeId(int vehicleTypeId) {
        List<VehicleCompany> vehicleCompanyList = vehicleCompanyRepository.getCompanyByType(vehicleTypeId);
        if (vehicleCompanyList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Không tìm thấy hãng phương tiện");
        }
        List<VehicleCompanyRequest> vehicleRequestList = new ArrayList<>();
        for (VehicleCompany vehicleCompany : vehicleCompanyList) {
            VehicleCompanyRequest vehicleCompanyRequest = new VehicleCompanyRequest();
            vehicleCompanyRequest.setId(vehicleCompany.getId());
            vehicleCompanyRequest.setName(vehicleCompany.getName());
            vehicleCompanyRequest.setTypeId(vehicleCompany.getTypeId());
            vehicleRequestList.add(vehicleCompanyRequest);
        }
        return vehicleRequestList;
    }

    @Override
    public List<VehicleState> getVehicleState(VehicleStateRequest vehicleStateRequest) {
        List<VehicleState> vehicleStateList = vehicleStateRepository.getVehicleState(vehicleStateRequest.getLoanType());
        if (vehicleStateList.isEmpty()) {
            throw new BusinessException(ErrorCode.NOT_FOUND_CUSTOMER, ErrorCode.NOT_FOUND_OPERATOR);
        }
        return vehicleStateList;
    }

    @Override
    public List<VehicleCompanyRequest> getAllVehicleCompany() {
        List<VehicleCompany> vehicleCompanyList = vehicleCompanyRepository.getAllVehicleCompany();
        if (vehicleCompanyList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Vehicle");
        }
        List<VehicleCompanyRequest> vehicleCompanyRequestList = new ArrayList<>();
        for (VehicleCompany vehicleCompany : vehicleCompanyList) {
            VehicleCompanyRequest vehicleCompanyRequest = new VehicleCompanyRequest();
            vehicleCompanyRequest.setId(vehicleCompany.getId());
            vehicleCompanyRequest.setName(vehicleCompany.getName());
            vehicleCompanyRequest.setTypeId(vehicleCompany.getTypeId());
            vehicleCompanyRequestList.add(vehicleCompanyRequest);
        }
        return vehicleCompanyRequestList;
    }
}
