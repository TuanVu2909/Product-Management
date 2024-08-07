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
        @NamedStoredProcedureQuery(name = "LoanStatus.createLoan", procedureName = "pck_loan.createLoan", resultClasses = LoanStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_regId", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_lnDate", mode = ParameterMode.IN, type = Date.class),
                @StoredProcedureParameter(name = "pv_insuranceFee", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_guaranteeTranFee", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_expertiseFeePrePaid", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_rate", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_assetManagementFeeRate", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_rateOvd", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_expertiseFeeRate", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_prePaymentFeeRate", mode = ParameterMode.IN, type = Double.class),
                @StoredProcedureParameter(name = "pv_documentNo", mode = ParameterMode.IN, type = String.class)
        }),
        @NamedStoredProcedureQuery(name = "LoanStatus.updateLoanStatus", procedureName = "pck_loan.updateLoanStatus", resultClasses = LoanStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_loanId", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_status", mode = ParameterMode.IN, type = String.class)
        }),
        @NamedStoredProcedureQuery(name = "LoanStatus.prePayment", procedureName = "pck_loan.prePayment", resultClasses = LoanStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_loanId", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_userId", mode = ParameterMode.IN, type = int.class),
        }),
        @NamedStoredProcedureQuery(name = "LoanStatus.approvePrePayment", procedureName = "pck_loan.approvePrePayment", resultClasses = LoanStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_loanId", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_approveUserId", mode = ParameterMode.IN, type = int.class)
        }),
        @NamedStoredProcedureQuery(name = "LoanStatus.operatorLoan", procedureName = "pck_report.operatorLoan", resultClasses = LoanStatus.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_id", mode = ParameterMode.IN, type = int.class),
                @StoredProcedureParameter(name = "pv_loanId", mode = ParameterMode.REF_CURSOR, type = int.class),
                @StoredProcedureParameter(name = "pv_loanScheduleId", mode = ParameterMode.REF_CURSOR, type = int.class),
                @StoredProcedureParameter(name = "pv_custId", mode = ParameterMode.REF_CURSOR, type = int.class),
                @StoredProcedureParameter(name = "pv_fullName", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_mobile", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_idNumber", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_status", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_payType", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_loanStatus", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_loanType", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_saleFullName", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_lnFromDate", mode = ParameterMode.REF_CURSOR, type = String.class),
                @StoredProcedureParameter(name = "pv_lnToDate", mode = ParameterMode.REF_CURSOR, type = String.class),

        })
})
public class LoanStatus {
    @Id
    @Column(name = "pv_status")
    private String status;

    @Column(name = "pv_des")
    private String description;
}
