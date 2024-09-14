package com.technology.apigateway.database.entity.status;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@Getter
@Setter
@ToString
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "CustomerStatus.createCustomer", procedureName = "pck_customer.create_customer", resultClasses = CustomerStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_fullname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_mobile", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_dob", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idtype", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idnumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_iddate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idplace", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idexpired", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_address", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_wardid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_districtid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_provinceid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_email", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_married", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_profession", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_education", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_custtype", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_status", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_createddate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_income", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_residency", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_residencytime", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_dependentperson", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_workingperiod", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_residenceaddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_residencewardid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_residencedistrictid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_residenceprovinceid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_bankname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_bankaccountnumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_gender", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_relationshipWithFiny", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_workAddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_nameCompany", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardName", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardBirth", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardMobile", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardMaritalStatus", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardIdNumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardIdDate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardIdAddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardIdPlace", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardAddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardStatusAddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardCurrentAddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardIsFieldWork", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_vehUseFor", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_vehCrack", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_vehScratch", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_vehOthersState", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_ethics", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_guardRelationship", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_descriptionWork", mode = ParameterMode.IN, type = String.class)
        }),
        @NamedStoredProcedureQuery(name = "CustomerStatus.updateCustomer", procedureName = "pck_customer.update_customer", resultClasses = CustomerStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_fullname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_mobile", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_dob", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idtype", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idnumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_iddate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idplace", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_idexpired", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_address", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_wardid", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_districtid", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_provinceid", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_email", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_married", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_profession", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_education", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_custtype", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_status", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_createddate", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_income", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_residency", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_residencytime", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_dependentperson", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_workingperiod", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_residenceaddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_residencewardid", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_residencedistrictid", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_residenceprovinceid", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_bankname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_bankaccountnumber", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_gender", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_relationshipwithfiny", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_workaddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_namecompany", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_descriptionWork", mode = ParameterMode.IN, type = String.class)

        }),
        @NamedStoredProcedureQuery(name = "CustomerStatus.createReference", procedureName = "pck_customer.createReference", resultClasses = CustomerStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_refname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_refmobile", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_refrelation", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_refjob", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_regId", mode = ParameterMode.IN, type = Integer.class)
        }),

        @NamedStoredProcedureQuery(name = "CustomerStatus.updateReference", procedureName = "pck_customer.updateReference", resultClasses = CustomerStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_refname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_refmobile", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_refrelation", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_refjob", mode = ParameterMode.IN, type = String.class)
        }),

        @NamedStoredProcedureQuery(name = "CustomerStatus.createIncomes", procedureName = "pck_customer.createIncomes", resultClasses = CustomerStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_companyname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_companyaddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_jobtitle", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_salary", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_creditinsname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_month", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_principalpermonth", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_interestpermonth", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_totalpermonth", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_incomeType", mode = ParameterMode.IN, type = String.class)
        }),

        @NamedStoredProcedureQuery(name = "CustomerStatus.updateIncomes", procedureName = "pck_customer.updateIncomes", resultClasses = CustomerStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_companyname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_companyaddress", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_jobtitle", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_salary", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_creditinsname", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "pv_month", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "pv_principalpermonth", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_interestpermonth", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_totalpermonth", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_incomeType", mode = ParameterMode.IN, type = String.class)
        }),

        @NamedStoredProcedureQuery(name = "CustomerStatus.createSimilarAssets", procedureName = "pck_customer.createSimilarAssets", resultClasses = CustomerStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_value", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_linkwebsite", mode = ParameterMode.IN, type = String.class),
        }),

        @NamedStoredProcedureQuery(name = "CustomerStatus.updateSimilarAssets", procedureName = "pck_customer.updateSimilarAssets", resultClasses = CustomerStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_value", mode = ParameterMode.IN, type = double.class),
                @StoredProcedureParameter(name = "pv_linkwebsite", mode = ParameterMode.IN, type = String.class),
        }),

        @NamedStoredProcedureQuery(name = "CustomerStatus.createScoring", procedureName = "pck_customer.createScoring", resultClasses = CustomerStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_proffession", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_age", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_residency", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_residencytime", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_maritalstatus", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_dependency", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_relwithfiny", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_incomeprovetype", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_income", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_workingtime", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_insurance", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_assettype", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_assetvalue", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_assetusefor", mode = ParameterMode.IN, type = int.class),
        }),

        @NamedStoredProcedureQuery(name = "CustomerStatus.calScoring", procedureName = "pck_customer.calScoring", resultClasses = CustomerStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_cursor", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_userid", mode = ParameterMode.IN, type = int.class)
        })
})

public class CustomerStatus {
    @Id
    @Column(name = "pv_status")
    private String status;

    @Column(name = "pv_des")
    private String description;
}
