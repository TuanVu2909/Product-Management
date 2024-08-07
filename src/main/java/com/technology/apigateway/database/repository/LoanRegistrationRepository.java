package com.technology.apigateway.database.repository;

import com.technology.apigateway.database.entity.ListLoanRegistration;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository("loanRegistrationRepository")
public interface LoanRegistrationRepository extends CrudRepository<ListLoanRegistration, Integer> {

    @Procedure("ListLoanRegistration.getLoanRegistration")
    List<ListLoanRegistration> getLoanRegistration(@Param("pv_id") Integer id);

    @Procedure("ListLoanRegistration.getListLoanRegistration")
    List<ListLoanRegistration> getListLoanRegistration(@Param("pv_id") Integer id,
                                                       @Param("pv_custId") Integer custId,
                                                       @Param("pv_vehicleType") String vehicleType,
                                                       @Param("pv_vehicleNumber") String vehicleNumber,
                                                       @Param("pv_registrationNumber") String registrationNumber,
                                                       @Param("pv_engineNumber") String engineNumber,
                                                       @Param("pv_chassisNumber") String chassisNumber,
                                                       @Param("pv_term") Integer term,
                                                       @Param("pv_status") String status,
                                                       @Param("pv_saleId") Integer saleId,
                                                       @Param("pv_coId") Integer coId,
                                                       @Param("pv_regFromDate") String regFromDate,
                                                       @Param("pv_regToDate") String regToDate,
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
                                                       @Param("pv_payType") String payType);
}
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            