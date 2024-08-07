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
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "LOANSCHEDULE")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "LoanSchedule.getLoanScheduleByLoanId", procedureName = "pck_loan.getLoanSchedule", resultClasses = LoanSchedule.class, parameters = {
                @StoredProcedureParameter(name = "pv_refcursor", mode = ParameterMode.REF_CURSOR, type = Void.class),
                @StoredProcedureParameter(name = "pv_loanId", mode = ParameterMode.IN, type = int.class)
        })
})
public class LoanSchedule {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "LOANID")
    private int loanId;

    @Column(name = "DUENO")
    private int dueNo;

    @Column(name = "DUEDATE")
    private String duedate;

    @Column(name = "PRINNML")
    private Double prinnml;

    @Column(name = "PRINOVD")
    private Double prinovd;

    @Column(name = "INTNML")
    private Double intnml;

    @Column(name = "INTOVD")
    private Double intovd;

    @Column(name = "PRINPAID")
    private Double prinpaid;

    @Column(name = "INTPAID")
    private Double intpaid;

    @Column(name = "ASSETMANAGEMENTFEE")
    private Double assetManagementFee;

    @Column(name = "ASSETMANAGEMENTOVD")
    private Double assetManagementOvd;

    @Column(name = "ASSETMANAGEMENTPAID")
    private Double assetManagementPaid;

    @Column(name = "PAIDDATE")
    private String paidDate;

    @Column(name = "ESTPRIN")
    private Double estPrin;

    @Column(name = "ESTINT")
    private Double estInt;

    @Column(name = "CNTDAYS")
    private Double cntDays;

    @Column(name = "FEEOVD")
    private Double feeOvd;

    @Column(name = "FEEOVDPAID")
    private Double feeOvdPaid;

    @Column(name = "EXPERTISEFEE")
    private Double expertiseFee;

    @Column(name = "EXPERTISEFEEOVD")
    private Double expertiseFeeOvd;

    @Column(name = "EXPERTISEFEEPAID")
    private Double expertiseFeePaid;


}
