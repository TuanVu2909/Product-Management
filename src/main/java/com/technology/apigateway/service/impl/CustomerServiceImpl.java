package com.technology.apigateway.service.impl;

import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.CustomerRequest;
import com.technology.apigateway.controller.request.GetCustomerRequest;
import com.technology.apigateway.controller.request.GetIncomeCustomerByIdAndIncomeType;
import com.technology.apigateway.database.entity.Customer;
import com.technology.apigateway.database.entity.status.CustomerStatus;
import com.technology.apigateway.database.entity.GuardiansEntity;
import com.technology.apigateway.database.entity.IncomeEntity;
import com.technology.apigateway.database.entity.ListCustomerBalance;
import com.technology.apigateway.database.entity.ListCustomerTransaction;
import com.technology.apigateway.database.entity.ReferencesEntity;
import com.technology.apigateway.database.entity.Scoring;
import com.technology.apigateway.database.entity.SimilarAssets;
import com.technology.apigateway.database.entity.UserFile;
import com.technology.apigateway.database.entity.UserScoring;
import com.technology.apigateway.database.repository.CustomerRepository;
import com.technology.apigateway.database.repository.CustomerStatusRepository;
import com.technology.apigateway.database.repository.GuardiansRepository;
import com.technology.apigateway.database.repository.IncomeRepository;
import com.technology.apigateway.database.repository.ListCustomerBalanceRepository;
import com.technology.apigateway.database.repository.ListTransactionRepository;
import com.technology.apigateway.database.repository.ReferencesRepository;
import com.technology.apigateway.database.repository.ScoringRepository;
import com.technology.apigateway.database.repository.SimilarAssetsRepository;
import com.technology.apigateway.database.repository.UserFileRepository;
import com.technology.apigateway.database.repository.UserScoringRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("customerService")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerServiceImpl implements CustomerService {

    CustomerStatusRepository customerStatusRepository;

    CustomerRepository customerRepository;

    ListCustomerBalanceRepository balanceRepository;

    ListTransactionRepository transactionRepository;

    IncomeRepository incomeRepository;

    GuardiansRepository guardiansRepository;

    ReferencesRepository referencesRepository;

    ScoringRepository scoringRepository;

    UserScoringRepository userScoringRepository;

    SimilarAssetsRepository assetsRepository;

    UserFileRepository fileRepository;

    @Override
    public List<CustomerRequest> getAllCustomer() {
        List<Customer> customerList = customerRepository.getAllCustomer();
        if (customerList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Customer");
        }
        List<CustomerRequest> customerRequestList = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerRequest customerRequest = new CustomerRequest();
            customerRequest.setId(customer.getId());
            customerRequest.setFullName(customer.getFullName());
            customerRequest.setMobile(customer.getMobile());
            customerRequest.setDob(customer.getDob());
            customerRequest.setIdType(customer.getIdType());
            customerRequest.setIdNumber(customer.getIdNumber());
            customerRequest.setIdDate(customer.getIdDate());
            customerRequest.setIdPlace(customer.getIdPlace());
            customerRequest.setIdExpired(customer.getIdExpired());
            customerRequest.setAddress(customer.getAddress());
            customerRequest.setWardId(customer.getWardId());
            customerRequest.setDistrictId(customer.getDistrictId());
            customerRequest.setProvinceId(customer.getProvinceId());
            customerRequest.setEmail(customer.getEmail());
            customerRequest.setMarried(customer.getMarried());
            customerRequest.setProfession(customer.getProfession());
            customerRequest.setEducation(customer.getEducation());
            customerRequest.setCustType(customer.getCustType());
            customerRequest.setStatus(customer.getStatus());
            customerRequest.setCreatedDate(customer.getCreatedDate());
            customerRequest.setIncome(customer.getIncome());
            customerRequest.setResidency(customer.getResidency());
            customerRequest.setResidencyTime(customer.getResidencyTime());
            customerRequest.setDependentPerson(customer.getDependentPerson());
            customerRequest.setWorkingPeriod(customer.getWorkingPeriod());
            customerRequest.setResidenceAddress(customer.getResidenceAddress());
            customerRequest.setResidenceWardId(customer.getResidenceWardId());
            customerRequest.setResidenceDistrictId(customer.getResidenceDistrictId());
            customerRequest.setResidenceProvinceId(customer.getResidenceProvinceId());
            customerRequestList.add(customerRequest);
        }
        return customerRequestList;
    }

    @Override
    public CustomerStatus createCustomer(CustomerRequest customerRequest) {
        CustomerStatus customerStatus;
        try {
            customerStatus = customerStatusRepository.createCustomer(
                    customerRequest.getFullName(),
                    customerRequest.getMobile(),
                    customerRequest.getDob(),
                    customerRequest.getIdType(),
                    customerRequest.getIdNumber(),
                    customerRequest.getIdDate(),
                    customerRequest.getIdPlace(),
                    customerRequest.getIdExpired(),
                    customerRequest.getAddress(),
                    customerRequest.getWardId(),
                    customerRequest.getDistrictId(),
                    customerRequest.getProvinceId(),
                    customerRequest.getEmail(),
                    customerRequest.getMarried(),
                    customerRequest.getProfession(),
                    customerRequest.getEducation(),
                    customerRequest.getCustType(),
                    customerRequest.getStatus(),
                    customerRequest.getCreatedDate(),
                    customerRequest.getIncome(),
                    customerRequest.getResidency(),
                    customerRequest.getResidencyTime(),
                    customerRequest.getDependentPerson(),
                    customerRequest.getWorkingPeriod(),
                    customerRequest.getResidenceAddress(),
                    customerRequest.getResidenceWardId(),
                    customerRequest.getResidenceDistrictId(),
                    customerRequest.getResidenceProvinceId(),
                    customerRequest.getBankName(),
                    customerRequest.getBankAccountNumber(),
                    customerRequest.getGender(),
                    customerRequest.getRelationshipWithFiny(),
                    customerRequest.getWorkAddress(),
                    customerRequest.getNameCompany(),
                    customerRequest.getEthics(),
                    "", "", "", "",
                    "", "", "", "",
                    "", "", "", "",
                    "", 1, 1, 1, 1,
                    customerRequest.getDescriptionWork());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return customerStatus;
    }

    @Override
    public CustomerStatus updateCustomer(CustomerRequest customerRequest) {
        CustomerStatus customerStatus;
        try {
            customerStatus = customerStatusRepository.updateCustomer(
                    customerRequest.getId(),
                    customerRequest.getFullName(),
                    customerRequest.getMobile(),
                    customerRequest.getDob(),
                    customerRequest.getIdType(),
                    customerRequest.getIdNumber(),
                    customerRequest.getIdDate(),
                    customerRequest.getIdPlace(),
                    customerRequest.getIdExpired(),
                    customerRequest.getAddress(),
                    customerRequest.getWardId(),
                    customerRequest.getDistrictId(),
                    customerRequest.getProvinceId(),
                    customerRequest.getEmail(),
                    customerRequest.getMarried(),
                    customerRequest.getProfession(),
                    customerRequest.getEducation(),
                    customerRequest.getCustType(),
                    customerRequest.getStatus(),
                    "",
                    customerRequest.getIncome(),
                    customerRequest.getResidency(),
                    customerRequest.getResidencyTime(),
                    customerRequest.getDependentPerson(),
                    customerRequest.getWorkingPeriod(),
                    customerRequest.getResidenceAddress(),
                    customerRequest.getResidenceWardId(),
                    customerRequest.getResidenceDistrictId(),
                    customerRequest.getResidenceProvinceId(),
                    customerRequest.getBankName(),
                    customerRequest.getBankAccountNumber(),
                    customerRequest.getGender(),
                    customerRequest.getRelationshipWithFiny(),
                    customerRequest.getWorkAddress(),
                    customerRequest.getNameCompany(),
                    customerRequest.getDescriptionWork());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return customerStatus;
    }

    @Override
    public List<Customer> getCustomerWhere(GetCustomerRequest request) {
        List<Customer> customerList = customerRepository.getCustomerWhere(
                request.getCareId(),
                request.getIdNumber(),
                request.getCustId());

        if (request.getIdNumber() != null) {
            incomeRepository.findByUserId(customerList.get(0).getId());
        }

        if (customerList.isEmpty()) {
            throw new BusinessException(ErrorCode.NOT_FOUND_CUSTOMER, ErrorCode.NOT_FOUND_CUSTOMER_DESCRIPTION);
        }
        return customerList;
    }

    @Override
    public List<IncomeEntity> getIncomesByUserId(GetCustomerRequest request) {
        return incomeRepository.findByUserId(request.getCareId());
    }

    @Override
    public List<GuardiansEntity> getGuardiansByUserId(GetCustomerRequest request) {
        return guardiansRepository.findByUserId(request.getCareId());
    }

    @Override
    public List<ReferencesEntity> getReferencesByUserId(GetCustomerRequest request) {
        return referencesRepository.findByUserId(request.getCareId());
    }

    @Override
    public List<ReferencesEntity> getReferencesByRegId(GetCustomerRequest request) {
        return referencesRepository.findByRegId(request.getRegId());
    }

    @Override
    public List<IncomeEntity> getCustomerByIdAndIncomeType(GetIncomeCustomerByIdAndIncomeType request) {
        return incomeRepository.getCustomerIncome(request.getUserId(), request.getIncomeType());
    }

    @Override
    public UserScoring getScoring(int userId) {
        // TODO Auto-generated method stub
        return userScoringRepository.getScoring(userId);
    }

    @Override
    public Scoring getScoringCal(int userId) {
        // TODO Auto-generated method stub
        return scoringRepository.getScoringCal(userId);
    }

    @Override
    public List<SimilarAssets> getSameAssets(int userId) {
        // TODO Auto-generated method stub
        return assetsRepository.findByUserId(userId);
    }

    @Override
    public List<UserFile> getUserFile(Integer custId) throws IOException {
        List<UserFile> userFileList = fileRepository.getFileByUserId(custId);
        for (UserFile userFile : userFileList) {
            String fileUrl = userFile.getUrl();
            userFile.setUploadFile(encodeFileToBase64Binary(fileUrl));
        }
        return userFileList;
    }

    @Override
    public List<UserFile> getUserFileByRegId(Integer regId) throws IOException {
        List<UserFile> userFileList = fileRepository.getFileByRegId(regId);
        for (UserFile userFile : userFileList) {
            String fileUrl = userFile.getUrl();
            userFile.setUploadFile(encodeFileToBase64Binary(fileUrl));
        }
        return userFileList;
    }

    @Override
    public List<ListCustomerBalance> getListCustomerBalance() {
        // TODO Auto-generated method stub
        return balanceRepository.getListCustomerBalance();
    }

    @Override
    public List<ListCustomerTransaction> getListTransaction() {
        // TODO Auto-generated method stub
        return transactionRepository.getListTransactions();
    }

    private static String encodeFileToBase64Binary(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] encoded = Base64.encodeBase64(org.apache.commons.io.FileUtils.readFileToByteArray(file));
        return new String(encoded, java.nio.charset.StandardCharsets.US_ASCII);
    }

}
