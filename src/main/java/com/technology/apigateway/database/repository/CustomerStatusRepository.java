package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.CustomerStatus;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("customerStatusRepository")
public interface CustomerStatusRepository extends CrudRepository<CustomerStatus, String> {
    @Procedure("CustomerStatus.createCustomer")
    CustomerStatus createCustomer(@Param("pv_fullname") String fullName,
                                  @Param("pv_mobile") String mobile,
                                  @Param("pv_dob") String dob,
                                  @Param("pv_idtype") String idType,
                                  @Param("pv_idnumber") String idNumber,
                                  @Param("pv_iddate") String iddate,
                                  @Param("pv_idplace") String idPlace,
                                  @Param("pv_idexpired") String idExpired,
                                  @Param("pv_address") String address,
                                  @Param("pv_wardid") int wardId,
                                  @Param("pv_districtid") int districtId,
                                  @Param("pv_provinceid") int provinceId,
                                  @Param("pv_email") String email,
                                  @Param("pv_married") String married,
                                  @Param("pv_profession") String profession,
                                  @Param("pv_education") String education,
                                  @Param("pv_custtype") String custType,
                                  @Param("pv_status") String status,
                                  @Param("pv_createddate") String createdDate,
                                  @Param("pv_income") int income,
                                  @Param("pv_residency") String residency,
                                  @Param("pv_residencytime") String residencyTime,
                                  @Param("pv_dependentperson") int dependentPerson,
                                  @Param("pv_workingperiod") int workingPeriod,
                                  @Param("pv_residenceaddress") String residenceAddress,
                                  @Param("pv_residencewardid") int residenceWardId,
                                  @Param("pv_residencedistrictid") int residenceDistrictId,
                                  @Param("pv_residenceprovinceid") int residenceprovinceid,
                                  @Param("pv_bankname") String bankName,
                                  @Param("pv_bankaccountnumber") String bankAccountNumber,
                                  @Param("pv_gender") int gender,
                                  @Param("pv_relationshipWithFiny") String relationshipWithFiny,
                                  @Param("pv_workAddress") String workAddress,
                                  @Param("pv_nameCompany") String nameCompany,
                                  @Param("pv_ethics") String ethics,
                                  @Param("pv_guardName") String guardName,
                                  @Param("pv_guardBirth") String guardBirth,
                                  @Param("pv_guardMobile") String guardMobile,
                                  @Param("pv_guardMaritalStatus") String guardMaritalStatus,
                                  @Param("pv_guardIdNumber") String guardIdNumber,
                                  @Param("pv_guardIdDate") String guardIdDate,
                                  @Param("pv_guardIdAddress") String guardIdAddress,
                                  @Param("pv_guardIdPlace") String guardIdPlace,
                                  @Param("pv_guardAddress") String guardAddress,
                                  @Param("pv_guardStatusAddress") String guardStatusAddress,
                                  @Param("pv_guardCurrentAddress") String guardCurrentAddress,
                                  @Param("pv_guardIsFieldWork") String guardIsFieldWork,
                                  @Param("pv_guardRelationship") String guardRelationship,
                                  @Param("pv_vehUseFor") int vehUseFor,
                                  @Param("pv_vehCrack") int vehCrack,
                                  @Param("pv_vehScratch") int vehScratch,
                                  @Param("pv_vehOthersState") int vehOthersState,
                                  @Param("pv_descriptionWork") String descriptionWork);

    @Procedure("CustomerStatus.updateCustomer")
    CustomerStatus updateCustomer(@Param("pv_id") int id,
                                  @Param("pv_fullname") String fullName,
                                  @Param("pv_mobile") String mobile,
                                  @Param("pv_dob") String dob,
                                  @Param("pv_idtype") String idType,
                                  @Param("pv_idnumber") String idNumber,
                                  @Param("pv_iddate") String idDate,
                                  @Param("pv_idplace") String idPlace,
                                  @Param("pv_idexpired") String idExpired,
                                  @Param("pv_address") String address,
                                  @Param("pv_wardid") int wardId,
                                  @Param("pv_districtid") int districtId,
                                  @Param("pv_provinceid") int provinceId,
                                  @Param("pv_email") String email,
                                  @Param("pv_married") String married,
                                  @Param("pv_profession") String profession,
                                  @Param("pv_education") String education,
                                  @Param("pv_custtype") String custType,
                                  @Param("pv_status") String status,
                                  @Param("pv_createddate") String createdDate,
                                  @Param("pv_income") int income,
                                  @Param("pv_residency") String residency,
                                  @Param("pv_residencytime") String residencyTime,
                                  @Param("pv_dependentperson") int dependentPerson,
                                  @Param("pv_workingperiod") int workingPeriod,
                                  @Param("pv_residenceaddress") String residenceAddress,
                                  @Param("pv_residencewardid") int residenceWardId,
                                  @Param("pv_residencedistrictid") int residenceDistrictId,
                                  @Param("pv_residenceprovinceid") int residenceProvinceId,
                                  @Param("pv_bankname") String bankName,
                                  @Param("pv_bankaccountnumber") String bankAccNo,
                                  @Param("pv_gender") int gender,
                                  @Param("pv_relationshipwithfiny") String relationShipWithFiny,
                                  @Param("pv_workaddress") String workAddress,
                                  @Param("pv_namecompany") String nameCompany,
                                  @Param("pv_descriptionWork") String pv_descriptionWork);

    @Procedure("CustomerStatus.createReference")
    CustomerStatus createReference(@Param("pv_userid") int id,
                                   @Param("pv_refname") String refName,
                                   @Param("pv_refmobile") String mobile,
                                   @Param("pv_refrelation") String refRelation,
                                   @Param("pv_refjob") String refJob,
                                   @Param("pv_regId") Integer regId);

    @Procedure("CustomerStatus.updateReference")
    CustomerStatus updateReference(@Param("pv_id") int id,
                                   @Param("pv_userid") int userId,
                                   @Param("pv_refname") String refName,
                                   @Param("pv_refmobile") String mobile,
                                   @Param("pv_refrelation") String refRelation,
                                   @Param("pv_refjob") String refJob);

    @Procedure("CustomerStatus.createIncomes")
    CustomerStatus createIncomes(@Param("pv_userid") int userId,
                                 @Param("pv_companyname") String companyName,
                                 @Param("pv_companyaddress") String companyAddress,
                                 @Param("pv_jobtitle") String jobTitle,
                                 @Param("pv_salary") double salary,
                                 @Param("pv_creditinsname") String creditInsName,
                                 @Param("pv_month") int month,
                                 @Param("pv_principalpermonth") double principalPerMonth,
                                 @Param("pv_interestpermonth") double interestPerMonth,
                                 @Param("pv_totalpermonth") double totalPerMonth,
                                 @Param("pv_incomeType") String incomeType);

    @Procedure("CustomerStatus.updateIncomes")
    CustomerStatus updateIncomes(@Param("pv_id") int id,
                                 @Param("pv_userid") int userId,
                                 @Param("pv_companyname") String companyName,
                                 @Param("pv_companyaddress") String companyAddress,
                                 @Param("pv_jobtitle") String jobTitle,
                                 @Param("pv_salary") double salary,
                                 @Param("pv_creditinsname") String creditInsName,
                                 @Param("pv_month") int month,
                                 @Param("pv_principalpermonth") double principalPerMonth,
                                 @Param("pv_interestpermonth") double interestPerMonth,
                                 @Param("pv_totalpermonth") double totalPerMonth,
                                 @Param("pv_incomeType") String incomeType);

    @Procedure("CustomerStatus.createSimilarAssets")
    CustomerStatus createSimilarAssets(@Param("pv_userid") int userId,
                                       @Param("pv_value") double value,
                                       @Param("pv_linkwebsite") String linkWebsite);

    @Procedure("CustomerStatus.updateSimilarAssets")
    CustomerStatus updateSimilarAssets(@Param("pv_id") int id,
                                       @Param("pv_userid") int userId,
                                       @Param("pv_value") double value,
                                       @Param("pv_linkwebsite") String linkWebsite);

    @Procedure("CustomerStatus.createScoring")
    CustomerStatus createScoring(
            @Param("pv_userid") int userId, @Param("pv_proffession") int proffession,
            @Param("pv_age") int age,
            @Param("pv_residency") int residency,
            @Param("pv_residencytime") int residencyTime,
            @Param("pv_maritalstatus") int maritalStatus,
            @Param("pv_dependency") int dependency,
            @Param("pv_relwithfiny") int relWithFiny,
            @Param("pv_incomeprovetype") int incomeProveType,
            @Param("pv_income") int income,
            @Param("pv_workingtime") int workingTime,
            @Param("pv_insurance") int insurance,
            @Param("pv_assettype") int assetType,
            @Param("pv_assetvalue") int assetValue,
            @Param("pv_assetusefor") int assetUseFor);

    @Procedure("CustomerStatus.calScoring")
    CustomerStatus calScoring(
            @Param("pv_userid") int userId);
}
