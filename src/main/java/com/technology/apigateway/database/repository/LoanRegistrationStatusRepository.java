package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.LoanRegistrationStatus;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository("loanRegistrationStatusRepository")
public interface LoanRegistrationStatusRepository extends CrudRepository<LoanRegistrationStatus, String> {

    @Procedure("LoanRegistrationStatus.createLoanRegistration")
    LoanRegistrationStatus createLoanRegistration(@Param("pv_custId") int custId,
            @Param("pv_vehicleType") String vehicleType,
            @Param("pv_vehicleId") int vehicleId,
            @Param("pv_vehicleNumber") String vehicleNumber,
            @Param("pv_registrationNumber") String registrationNumber,
            @Param("pv_engineNumber") String engineNumber,
            @Param("pv_chassisNumber") String chassisNumber,
            @Param("pv_vehiclePrice") int vehiclePrice,
            @Param("pv_loanAmount") int loanAmount,
            @Param("pv_term") int term,
            @Param("pv_saleId") int saleId,
            @Param("pv_saleNote") String saleNote,
            @Param("pv_incomeProveType") String incomeProveType,
            @Param("pv_termType") String termType,
            @Param("pv_vehicleOwnerName") String vehicleOwnerName,
            @Param("pv_vehicleColor") String vehicleColor,
            @Param("pv_addressVehicleDocuments") String addressVehicleDocuments,
            @Param("pv_loanType") String loanType,
            @Param("pv_vehicleOrigin") String vehicleOrigin,
            @Param("pv_vehicleRegistrationIssued") String vehicleRegistrationIssued,
            @Param("pv_vehicleRegistrationDate") Date vehicleRegistrationDate,
            @Param("pv_purposeUsingLoan") String purposeUsingLoan,
            @Param("pv_vehicleBrand") String vehicleBrand,
            @Param("pv_payType") String payType,
            @Param("pv_fuel") String fuel,
            @Param("pv_numberPeopleAllow") String numberPeopleAllow);

    @Procedure("LoanRegistrationStatus.updateLoanRegistration")
    LoanRegistrationStatus updateLoanRegistration(@Param("pv_id") int id,
            @Param("pv_custId") int custId,
            @Param("pv_vehicleType") String vehicleType,
            @Param("pv_vehicleId") int vehicleId,
            @Param("pv_vehicleNumber") String vehicleNumber,
            @Param("pv_registrationNumber") String registrationNumber,
            @Param("pv_engineNumber") String engineNumber,
            @Param("pv_chassisNumber") String chassisNumber,
            @Param("pv_vehiclePrice") int vehiclePrice,
            @Param("pv_loanAmount") int loanAmount,
            @Param("pv_term") int term,
            @Param("pv_status") String status,
            @Param("pv_saleId") int saleId,
            @Param("pv_coId") Integer coId,
            @Param("pv_saleNote") String saleNote,
            @Param("pv_coNote") String coNote,
            @Param("pv_incomeProveType") String incomeProveType,
            @Param("pv_termType") String termType,
            @Param("pv_vehicleOwnerName") String pv_vehicleOwnerName,
            @Param("pv_vehicleColor") String pv_vehicleColor,
            @Param("pv_addressVehicleDocuments") String pv_addressVehicleDocuments,
            @Param("pv_loanType") String pv_loanType,
            @Param("pv_vehicleOrigin") String pv_vehicleOrigin,
            @Param("pv_vehicleRegistrationIssued") String pv_vehicleRegistrationIssued,
            @Param("pv_vehicleRegistrationDate") Date pv_vehicleRegistrationDate,
            @Param("pv_purposeUsingLoan") String pv_purposeUsingLoan,
            @Param("pv_vehicleBrand") String pv_vehicleBrand,
            @Param("pv_payType") String pv_payType,
            @Param("pv_fuel") String fuel,
            @Param("pv_numberPeopleAllow") String numberPeopleAllow);

    @Procedure("LoanRegistrationStatus.updateLoanRegistrationStatus")
    LoanRegistrationStatus updateLoanRegistrationStatus(@Param("pv_id") int id,
            @Param("pv_status") String status, @Param("pv_finyPay") Integer finyPay);
}
