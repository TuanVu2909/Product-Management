package com.technology.apigateway.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.technology.apigateway.config.MockMultipartFile;
import com.technology.apigateway.constant.Constants;
import com.technology.apigateway.constant.ErrorCode;
import com.technology.apigateway.controller.request.AddressRequest;
import com.technology.apigateway.controller.request.LoanRequest;
import com.technology.apigateway.controller.request.MainRequest;
import com.technology.apigateway.controller.request.OperatorLoanRequest;
import com.technology.apigateway.controller.request.payment.ApprovePrePaymentRequest;
import com.technology.apigateway.controller.request.payment.PrePaymentRequest;
import com.technology.apigateway.controller.request.references.ReferenceRequest;
import com.technology.apigateway.database.entity.AdminUser;
import com.technology.apigateway.database.entity.Customer;
import com.technology.apigateway.database.entity.District;
import com.technology.apigateway.database.entity.GuardiansEntity;
import com.technology.apigateway.database.entity.ListLoan;
import com.technology.apigateway.database.entity.ListLoanRegistration;
import com.technology.apigateway.database.entity.LoanStatus;
import com.technology.apigateway.database.entity.OperatorLoan;
import com.technology.apigateway.database.entity.Province;
import com.technology.apigateway.database.entity.ReferencesEntity;
import com.technology.apigateway.database.entity.Vehicle;
import com.technology.apigateway.database.entity.VehicleCompany;
import com.technology.apigateway.database.entity.Ward;
import com.technology.apigateway.database.repository.AdminUserRepository;
import com.technology.apigateway.database.repository.CustomerRepository;
import com.technology.apigateway.database.repository.DistrictRepository;
import com.technology.apigateway.database.repository.GuardiansRepository;
import com.technology.apigateway.database.repository.LoanRegistrationRepository;
import com.technology.apigateway.database.repository.LoanRepository;
import com.technology.apigateway.database.repository.LoanStatusRepository;
import com.technology.apigateway.database.repository.OperatorLoanRepository;
import com.technology.apigateway.database.repository.ProvinceRepository;
import com.technology.apigateway.database.repository.ReferencesRepository;
import com.technology.apigateway.database.repository.UserFileRepository;
import com.technology.apigateway.database.repository.VehicleCompanyRepository;
import com.technology.apigateway.database.repository.VehicleRepository;
import com.technology.apigateway.database.repository.WardRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.runner.DataLoader;
import com.technology.apigateway.service.FilesStorageService;
import com.technology.apigateway.service.LoanService;
import com.technology.apigateway.utils.ApiUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service("loanService")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoanServiceImpl implements LoanService {

    LoanRepository loanRepository;

    LoanStatusRepository loanStatusRepository;

    OperatorLoanRepository operatorLoanRepository;

    CustomerRepository customerRepository;

    AdminUserRepository adminUserRepository;

    LoanRegistrationRepository loanRegistrationRepository;

    FilesStorageService filesStorageService;

    RestTemplate restTemplate;

    UserFileRepository fileRepository;

    ReferencesRepository referencesRepository;

    WardRepository wardRepository;

    ProvinceRepository provinceRepository;

    DistrictRepository districtRepository;

    VehicleRepository vehicleRepository;

    VehicleCompanyRepository vehicleCompanyRepository;

    GuardiansRepository guardiansRepository;

    @Override
    public LoanStatus createLoan(LoanRequest loanRequest) {
        LoanStatus loanStatus;

        loanStatus = loanStatusRepository.createLoan(
                loanRequest.getRegId(),
                loanRequest.getCustId(),
                loanRequest.getLndate(),
                loanRequest.getInsuranceFee(),
                loanRequest.getGuaranteeTranFee(),
                loanRequest.getExpertiseFeePrePaid(),
                Double.parseDouble(new DecimalFormat("##.##").format(loanRequest.getChangeRate() * 12)),
                Double.parseDouble(new DecimalFormat("##.##").format(loanRequest.getAssetManagementFeeRate() * 12)),
                Double.parseDouble(new DecimalFormat("##.##").format(loanRequest.getChangeRateOvd())),
                Double.parseDouble(new DecimalFormat("##.##").format(loanRequest.getExpertiseFeeRate() * 12)),
                Double.parseDouble(new DecimalFormat("##.##").format(loanRequest.getPrePaymentFeeRate())),
                loanRequest.getDocumentNo());

        if (loanStatus.getStatus().equals("0")) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, loanStatus.getDescription());
        }

        // bat dau sua tu` day
        MainRequest mainRequest = new MainRequest();
        AddressRequest addressRequest = new AddressRequest();
        List<Customer> lstCustomer = customerRepository.getCustomerWhere(null, null, loanRequest.getCustId());
        List<ListLoanRegistration> listLoanRegistration = loanRegistrationRepository.getListLoanRegistration(loanRequest.getRegId(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        List<AdminUser> lstAdmin = adminUserRepository.getAdminUserById(Integer.parseInt(listLoanRegistration.get(0).getSaleId()));
        Optional<Customer> optionalCustomer = customerRepository.findById(loanRequest.getCustId());
        List<ReferencesEntity> referencesEntity = referencesRepository.findByUserId(loanRequest.getCustId());
        Optional<Ward> optionalWard = wardRepository.findById(lstCustomer.get(0).getWardId());
        Optional<Province> optionalProvince = provinceRepository.findById(lstCustomer.get(0).getProvinceId());
        Optional<District> optionalDistrict = districtRepository.findById(lstCustomer.get(0).getDistrictId());
        Optional<Ward> optionalWard1 = wardRepository.findById(lstCustomer.get(0).getResidenceWardId());
        Optional<Province> optionalProvince1 = provinceRepository.findById(lstCustomer.get(0).getResidenceProvinceId());
        Optional<District> optionalDistrict1 = districtRepository.findById(lstCustomer.get(0).getResidenceDistrictId());
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(Integer.parseInt(listLoanRegistration.get(0).getVehicleId()));
        Optional<VehicleCompany> optionalVehicleCompany = vehicleCompanyRepository.findById(Integer.parseInt(listLoanRegistration.get(0).getVehicleBrand()));
        List<ListLoan> loanList = loanRepository.findByRegId(loanRequest.getRegId());
        List<GuardiansEntity> guardiansEntityList = guardiansRepository.findByUserId(loanRequest.getCustId());


        //Lay danh sach nguoi tham chieu
        List<ReferenceRequest> referenceRequestList = new ArrayList<>();
        for (int i = 0; i < referencesEntity.size(); i++) {
            ReferenceRequest referenceRequest = new ReferenceRequest();
            referenceRequest.setJob(referencesEntity.get(i).getRefJob());
            referenceRequest.setMobile(referencesEntity.get(i).getRefMobile());
            referenceRequest.setRelation(referencesEntity.get(i).getRefRelation());
            referenceRequest.setRefName(referencesEntity.get(i).getRefName());
            referenceRequestList.add(referenceRequest);
        }

        //Lay danh sach nguoi bao lanh
        if (guardiansEntityList.size() > 0) {
            mainRequest.setGuardName(guardiansEntityList.get(0).getName());
            mainRequest.setGuardBirth(guardiansEntityList.get(0).getBirthDate());
            mainRequest.setGuardIdNumber(guardiansEntityList.get(0).getIdNumber());
            mainRequest.setGuardIdDate(guardiansEntityList.get(0).getIdDate());
            mainRequest.setGuardIdPlace(guardiansEntityList.get(0).getIdPlace());
            mainRequest.setGuardAddress(guardiansEntityList.get(0).getAddress());
            mainRequest.setGuardCurrentAddress(guardiansEntityList.get(0).getCurrentAddress());
            mainRequest.setGuardMobile(guardiansEntityList.get(0).getMobile());
        }

        mainRequest.setTerm(Integer.parseInt(listLoanRegistration.get(0).getTerm()));
        mainRequest.setProfession(DataLoader.mapAllCode.get(optionalCustomer.get().getProfession() + "PROFESSION").getName());
        mainRequest.setBankAccountNumber(optionalCustomer.get().getBankAccountNumber());
        mainRequest.setBankName(DataLoader.mapAllCode.get(optionalCustomer.get().getBankName() + "BANKNAME").getName());
        mainRequest.setReferences(referenceRequestList);
        mainRequest.setLoanAmount(Integer.parseInt(listLoanRegistration.get(0).getLoanAmount()));
        mainRequest.setPurposeUsingLoan(listLoanRegistration.get(0).getPurposeUsingLoan());
        mainRequest.setLoanType(listLoanRegistration.get(0).getLoanType());
        mainRequest.setPayType(listLoanRegistration.get(0).getPayType());
        mainRequest.setFullName(optionalCustomer.get().getFullName());
        mainRequest.setVehicleType(listLoanRegistration.get(0).getVehicleType());
        mainRequest.setChassisNumber(listLoanRegistration.get(0).getChassisNumber());
        mainRequest.setEngineNumber(listLoanRegistration.get(0).getEngineNumber());
        mainRequest.setVehicleColor(listLoanRegistration.get(0).getVehicleColor());
        mainRequest.setFuel(listLoanRegistration.get(0).getFuel());
        mainRequest.setRegistrationNumber(listLoanRegistration.get(0).getRegistrationNumber());
        mainRequest.setVehicleNumber(listLoanRegistration.get(0).getVehicleNumber());
        mainRequest.setVehiclePrice(Long.parseLong(listLoanRegistration.get(0).getVehiclePrice()));
        mainRequest.setVehicleRegistrationDate(listLoanRegistration.get(0).getVehicleRegistrationDate());
        mainRequest.setSaleId(Integer.parseInt(listLoanRegistration.get(0).getSaleId()));
        mainRequest.setVehicleBrand(optionalVehicleCompany.get().getName());
        mainRequest.setVehicleRegistrationIssued(listLoanRegistration.get(0).getVehicleRegistrationIssued());
        addressRequest.setWard(optionalWard.get().getWName());
        addressRequest.setDistrict(optionalDistrict.get().getDName());
        addressRequest.setProvince(optionalProvince.get().getPName());
        addressRequest.setResidenceWard(optionalWard1.get().getWName());
        addressRequest.setResidenceDistrict(optionalDistrict1.get().getDName());
        addressRequest.setResidenceProvince(optionalProvince1.get().getPName());
        addressRequest.setVehicleName(optionalVehicle.get().getName());

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date curdate = new Date();

            DateFormat lnDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            addressRequest.setLnDate(lnDateFormat.parse(loanList.get(0).getLnDate()));

            filesStorageService.init("contracts", loanRequest.getCustId().toString());

            //Dua du lieu vao hop dong
            ApiUtils.fillDataToContract(lstCustomer.get(0),
                    "hoso" + Constants.FOLDER_SEPERATE + "default" + Constants.FOLDER_SEPERATE + "hopdongvaymoi.docx",
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "hopdongvay_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".docx",
                    mainRequest, lstAdmin.get(0), loanRequest.getDocumentNo(),
                    Double.parseDouble(new DecimalFormat("##.##").format(loanRequest.getChangeRate())),
                    Double.parseDouble(new DecimalFormat("##.##").format(loanRequest.getPrePaymentFeeRate())), addressRequest,
                    Double.parseDouble(new DecimalFormat("##.##").format(loanRequest.getAssetManagementFeeRate())),
                    Double.parseDouble(new DecimalFormat("##.##").format(loanRequest.getExpertiseFeeRate()))
            );

            MultipartFile mckFile = null;
            File inputWord = new File(
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "hopdongvay_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".docx");
            FileInputStream inputStream = new FileInputStream(inputWord);
            mckFile = new MockMultipartFile("hd", inputWord.getName(), "text/plain",
                    IOUtils.toByteArray(inputStream));

            final String uri = "http://45.117.83.201:9013/esign/v1.0/convert-pdf";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            headers.set("requestId", loanRequest.getCustId().toString());

            MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
            ByteArrayResource contentsAsResource = ApiUtils.convertFile(mckFile);
            multiValueMap.add("file", contentsAsResource);
            multiValueMap.add("output", loanRequest.getCustId().toString() + dateFormat.format(curdate) + ".pdf");

            HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(multiValueMap, headers);
            ResponseEntity<String> responseEntityStr = restTemplate.postForEntity(uri, request, String.class);

            // mapping response
            // OutputStream outputStream;
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root;
            if (responseEntityStr.getStatusCodeValue() == 200) {
                try {
                    root = mapper.readTree(responseEntityStr.getBody());
                    byte[] data;
                    try {
                        data = root.get("data").binaryValue();

                        FileUtils.writeByteArrayToFile(
                                new File("hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE
                                        + "contracts"
                                        + "/contract_" + loanRequest.getCustId().toString() + "_" + dateFormat.format(curdate) + ".pdf"),
                                data);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (JsonProcessingException e) {
                    throw new BusinessException(ErrorCode.FAILED_TO_JSON, ErrorCode.FAILED_TO_JSON_DESCRIPTION);
                }

            } else {
            }
            String contractEncode = encodeFileToBase64Binary(
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE
                            + "contracts"
                            + "/contract_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".pdf");
            fileRepository.insertRow("contract_" + loanRequest.getCustId().toString() + "_" + dateFormat.format(curdate) + ".pdf", /**
                     * FilenameUtils.getExtension(mckFile.getOriginalFilename())
                     */
                    "contract",
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "contract_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".pdf",
                    loanRequest.getCustId(), Integer.parseInt(listLoanRegistration.get(0).getSaleId()), "pdf", loanRequest.getRegId());

            fileRepository.insertRow("contract_" + loanRequest.getCustId().toString() + "_" + dateFormat.format(curdate) + ".docx", /**
                     * FilenameUtils.getExtension(mckFile.getOriginalFilename())
                     */
                    "contract",
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "hopdongvay_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".docx",
                    loanRequest.getCustId(), Integer.parseInt(listLoanRegistration.get(0).getSaleId()), "docx", loanRequest.getRegId());

            //Dua du lieu vao van ban uy quyen
            ApiUtils.fillDataToAuthorizationDocument(lstCustomer.get(0),
                    "hoso" + Constants.FOLDER_SEPERATE + "default" + Constants.FOLDER_SEPERATE + "mauvanbanuyquyen.docx",
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "vanbanuyquyen_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".docx",
                    mainRequest, lstAdmin.get(0), loanRequest.getDocumentNo(), addressRequest
            );

            File inputWordAuthorizationDocument = new File(
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "vanbanuyquyen_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".docx");
            FileInputStream inputStreamAuthorizationDocument = new FileInputStream(inputWordAuthorizationDocument);
            mckFile = new MockMultipartFile("hd", inputWordAuthorizationDocument.getName(), "text/plain",
                    IOUtils.toByteArray(inputStreamAuthorizationDocument));

            multiValueMap = new LinkedMultiValueMap<>();
            contentsAsResource = ApiUtils.convertFile(mckFile);
            multiValueMap.add("file", contentsAsResource);
            multiValueMap.add("output", "vanbanuyquyen_" + loanRequest.getCustId().toString() + dateFormat.format(curdate) + ".pdf");

            request = new HttpEntity<>(multiValueMap, headers);
            responseEntityStr = restTemplate.postForEntity(uri, request, String.class);

            mapper = new ObjectMapper();
            if (responseEntityStr.getStatusCodeValue() == 200) {
                try {
                    root = mapper.readTree(responseEntityStr.getBody());
                    byte[] data;
                    try {
                        data = root.get("data").binaryValue();

                        FileUtils.writeByteArrayToFile(
                                new File("hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE
                                        + "contracts"
                                        + "/vanbanuyquyen_" + loanRequest.getCustId().toString() + "_" + dateFormat.format(curdate) + ".pdf"),
                                data);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (JsonProcessingException e) {
                    throw new BusinessException(ErrorCode.FAILED_TO_JSON, ErrorCode.FAILED_TO_JSON_DESCRIPTION);
                }

            } else {
            }

            fileRepository.insertRow("vanbanuyquyen_" + loanRequest.getCustId().toString() + "_" + dateFormat.format(curdate) + ".pdf", /**
                     * FilenameUtils.getExtension(mckFile.getOriginalFilename())
                     */
                    "contract",
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "vanbanuyquyen_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".pdf",
                    loanRequest.getCustId(), Integer.parseInt(listLoanRegistration.get(0).getSaleId()), "pdf", loanRequest.getRegId());

            fileRepository.insertRow("vanbanuyquyen_" + loanRequest.getCustId().toString() + "_" + dateFormat.format(curdate) + ".docx", /**
                     * FilenameUtils.getExtension(mckFile.getOriginalFilename())
                     */
                    "contract",
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "vanbanuyquyen_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".docx",
                    loanRequest.getCustId(), Integer.parseInt(listLoanRegistration.get(0).getSaleId()), "docx", loanRequest.getRegId());

            //Dua du lieu vao bien ban ban giao tai san
            ApiUtils.fillDataToAssetTransferDocument(lstCustomer.get(0),
                    "hoso" + Constants.FOLDER_SEPERATE + "default" + Constants.FOLDER_SEPERATE + "maubienbanbangiaotaisan.docx",
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "bienbanbangiaotaisan_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".docx",
                    mainRequest, lstAdmin.get(0), loanRequest.getDocumentNo(), addressRequest
            );

            File inputWordAssetTranferDocument = new File(
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "bienbanbangiaotaisan_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".docx");
            FileInputStream inputStreamAssetTranferDocument = new FileInputStream(inputWordAssetTranferDocument);
            mckFile = new MockMultipartFile("hd", inputWordAuthorizationDocument.getName(), "text/plain",
                    IOUtils.toByteArray(inputStreamAssetTranferDocument));

            multiValueMap = new LinkedMultiValueMap<>();
            contentsAsResource = ApiUtils.convertFile(mckFile);
            multiValueMap.add("file", contentsAsResource);
            multiValueMap.add("output", "bienbanbangiaotaisan_" + loanRequest.getCustId().toString() + dateFormat.format(curdate) + ".pdf");

            request = new HttpEntity<>(multiValueMap, headers);
            responseEntityStr = restTemplate.postForEntity(uri, request, String.class);

            mapper = new ObjectMapper();
            if (responseEntityStr.getStatusCodeValue() == 200) {
                try {
                    root = mapper.readTree(responseEntityStr.getBody());
                    byte[] data;
                    try {
                        data = root.get("data").binaryValue();

                        FileUtils.writeByteArrayToFile(
                                new File("hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE
                                        + "contracts"
                                        + "/bienbanbangiaotaisan_" + loanRequest.getCustId().toString() + "_" + dateFormat.format(curdate) + ".pdf"),
                                data);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (JsonProcessingException e) {
                    throw new BusinessException(ErrorCode.FAILED_TO_JSON, ErrorCode.FAILED_TO_JSON_DESCRIPTION);
                }

            } else {
            }

            fileRepository.insertRow("bienbanbangiaotaisan_" + loanRequest.getCustId().toString() + "_" + dateFormat.format(curdate) + ".pdf", /**
                     * FilenameUtils.getExtension(mckFile.getOriginalFilename())
                     */
                    "contract",
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "bienbanbangiaotaisan_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".pdf",
                    loanRequest.getCustId(), Integer.parseInt(listLoanRegistration.get(0).getSaleId()), "pdf", loanRequest.getRegId());

            fileRepository.insertRow("bienbanbangiaotaisan_" + loanRequest.getCustId().toString() + "_" + dateFormat.format(curdate) + ".docx", /**
                     * FilenameUtils.getExtension(mckFile.getOriginalFilename())
                     */
                    "contract",
                    "hoso" + Constants.FOLDER_SEPERATE + loanRequest.getCustId().toString() + Constants.FOLDER_SEPERATE + "contracts"
                            + Constants.FOLDER_SEPERATE + "bienbanbangiaotaisan_" + loanRequest.getCustId() + "_" + dateFormat.format(curdate) + ".docx",
                    loanRequest.getCustId(), Integer.parseInt(listLoanRegistration.get(0).getSaleId()), "docx", loanRequest.getRegId());

        } catch (Docx4JException e) {
            log.info(e.getMessage());
        } catch (IOException e) {
            log.info(e.getMessage());
        } catch (JAXBException e) {
            log.info(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return loanStatus;
    }

    private static String encodeFileToBase64Binary(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        return new String(encoded, StandardCharsets.US_ASCII);
    }

    @Override
    public LoanStatus updateLoanStatus(LoanRequest loanRequest) {
        LoanStatus loanStatus;
        try {
            loanStatus = loanStatusRepository.updateLoanStatus(
                    loanRequest.getId(),
                    loanRequest.getStatus());

            if (loanStatus.getStatus().equals("0")) {
                throw new BusinessException(ErrorCode.UNKNOWN_ERROR, loanStatus.getDescription());
            }
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return loanStatus;
    }

    @Override
    public LoanStatus prePayment(PrePaymentRequest request) {
        LoanStatus loanStatus;
        try {
            loanStatus = loanStatusRepository.prePayment(
                    request.getLoanId(),
                    request.getUserId());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return loanStatus;
    }

    @Override
    public LoanStatus approvePrePayment(ApprovePrePaymentRequest request) {
        LoanStatus loanStatus;
        try {
            loanStatus = loanStatusRepository.approvePrePayment(
                    request.getLoanId(),
                    request.getApproveUserId());
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getMessage());
        }
        return loanStatus;
    }

    @Override
    public List<ListLoan> getLoanList(LoanRequest loanRequest) {
        List<ListLoan> loanList = loanRepository.getLoanList(
                loanRequest.getId(),
                loanRequest.getCustId(),
                loanRequest.getFullName(),
                loanRequest.getLnFromDate(),
                loanRequest.getLnToDate(),
                loanRequest.getTerm(),
                loanRequest.getRate(),
                loanRequest.getRateovd(),
                loanRequest.getFeeRate(),
                loanRequest.getStatus(),
                loanRequest.getPayType(),
                loanRequest.getTermType(),
                loanRequest.getLoanStatus(),
                loanRequest.getSaleId());
        if (loanList.isEmpty()) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR, "Not found Loan");
        }
        return loanList;
    }

    @Override
    public List<OperatorLoan> operatorLoan(OperatorLoanRequest operatorLoanRequest) {
        List<OperatorLoan> operatorLoanList = operatorLoanRepository.operatorLoan(
                operatorLoanRequest.getId(),
                operatorLoanRequest.getCustId(),
                operatorLoanRequest.getFullName(),
                operatorLoanRequest.getMobile(),
                operatorLoanRequest.getIdNumber(),
                operatorLoanRequest.getLoanType(),
                operatorLoanRequest.getTerm(),
                operatorLoanRequest.getRate(),
                operatorLoanRequest.getRateOvd(),
                operatorLoanRequest.getFeeRate(),
                operatorLoanRequest.getStatus(),
                operatorLoanRequest.getPayType(),
                operatorLoanRequest.getTermType(),
                operatorLoanRequest.getLoanStatus(),
                operatorLoanRequest.getSaleId(),
                operatorLoanRequest.getSaleFullName(),
                operatorLoanRequest.getLnFromDate(),
                operatorLoanRequest.getLnToDate());
        if (operatorLoanList.isEmpty()) {
            throw new BusinessException(ErrorCode.NOT_FOUND_CUSTOMER, ErrorCode.NOT_FOUND_OPERATOR);
        }
        return operatorLoanList;
    }

    public static void main(String[] args) {
        double value = 6;
        value = Double.parseDouble(new DecimalFormat("#.#").format(value));

        System.out.println(value);
    }
}
