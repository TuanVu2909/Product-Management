// package com.technology.apigateway;

// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.transaction.annotation.Transactional;

// import com.technology.apigateway.controller.request.GetCustomerRequest;
// import com.technology.apigateway.controller.request.LoanRegistrationRequest;
// import com.technology.apigateway.database.entity.Customer;
// import com.technology.apigateway.database.entity.LoanRegistration;
// import com.technology.apigateway.service.CustomerService;
// import com.technology.apigateway.service.LoanRegistrationService;

// @SpringBootTest
// class ApigatewayApplicationTests {

//     @Test
//     void contextLoads() {
//     }

//     @Autowired
//     private LoanRegistrationService loanRegistrationService;

//     @Autowired
//     private CustomerService customerService;

//     @Test
//     @Transactional(readOnly = true)
//     public void getListLoan() {
//         LoanRegistrationRequest request = new LoanRegistrationRequest();
//         // request.setId(1);
//         // request.setCustId(69);
//         // request.setRegDate(LocalDateTime.now());
//         // request.setVehicleType("");
//         // request.setVehicleId(1);
//         // request.setVehicleNumber("");
//         // request.setRegistrationNumber("");
//         // request.setEngineNumber("");
//         // request.setChassisNumber("");
//         // request.setVehiclePrice(1);
//         // request.setLoanAmount(1);
//         // request.setTerm(1);
//         // request.setStatus("");
//         request.setSaleId(69);
//         // request.setCoId(1);
//         // request.setSaleNote("");
//         // request.setCoNote("");
//         // request.setCreatedDate(LocalDateTime.now());
//         // request.setIncomeProveType("");
//         // request.setTermType("");
//         request.setRegFromDate("20230320");
//         request.setRegToDate("20230320");

//         List<LoanRegistration> lstLoan = loanRegistrationService.getAllLoanRegistrationWhere(request);

//         System.out.println(lstLoan.size());

//     }

//     @Test
//     @Transactional(readOnly = true)
//     public void getCustomerByCareId() {
//         GetCustomerRequest request = new GetCustomerRequest();
//         request.setCareId(69);

//         List<Customer> lstLoan = customerService.getCustomerWhere(request);

//         System.out.println(lstLoan.size());

//     }

// }