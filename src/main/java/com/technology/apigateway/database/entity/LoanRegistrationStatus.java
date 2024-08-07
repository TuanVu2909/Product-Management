package com.technology.apigateway.database.entity;

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
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@NamedStoredProcedureQueries({
                @NamedStoredProcedureQuery(name = "LoanRegistrationStatus.createLoanRegistration", procedureName = "pck_loan.createLoanRegistration", resultClasses = LoanRegistrationStatus.class, parameters = {
                                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_vehicleType", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleId", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_vehicleNumber", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_registrationNumber", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_engineNumber", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_chassisNumber", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehiclePrice", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_loanAmount", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_term", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_saleId", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_saleNote", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_incomeProveType", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_termType", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleOwnerName", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleColor", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_addressVehicleDocuments", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_loanType", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleOrigin", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleRegistrationIssued", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleRegistrationDate", mode = ParameterMode.IN, type = Date.class),
                                @StoredProcedureParameter(name = "pv_purposeUsingLoan", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleBrand", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_payType", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_fuel", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_numberPeopleAllow", mode = ParameterMode.IN, type = String.class)
                }),
                @NamedStoredProcedureQuery(name = "LoanRegistrationStatus.updateLoanRegistration", procedureName = "pck_loan.updateLoanRegistration", resultClasses = LoanRegistrationStatus.class, parameters = {
                                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_vehicleType", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleId", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_vehicleNumber", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_registrationNumber", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_engineNumber", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_chassisNumber", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehiclePrice", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_loanAmount", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_term", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_status", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_saleId", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_coId", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_saleNote", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_coNote", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_incomeProveType", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_termType", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleOwnerName", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleColor", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_addressVehicleDocuments", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_loanType", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleOrigin", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleRegistrationIssued", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleRegistrationDate", mode = ParameterMode.IN, type = Date.class),
                                @StoredProcedureParameter(name = "pv_purposeUsingLoan", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_vehicleBrand", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_payType", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_fuel", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_numberPeopleAllow", mode = ParameterMode.IN, type = String.class)
                }),
                @NamedStoredProcedureQuery(name = "LoanRegistrationStatus.updateLoanRegistrationStatus", procedureName = "pck_loan.updateLoanRegistrationStatus", resultClasses = LoanRegistrationStatus.class, parameters = {
                                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = int.class),
                                @StoredProcedureParameter(name = "pv_status", mode = ParameterMode.IN, type = String.class),
                                @StoredProcedureParameter(name = "pv_finyPay", mode = ParameterMode.IN, type = Integer.class)
                })
})
public class LoanRegistrationStatus {
        @Id
        @Column(name = "pv_status")
        private String status;

        @Column(name = "pv_des")
        private String description;
}
