package com.technology.apigateway.controller;

import com.technology.apigateway.constant.Constants;
import com.technology.apigateway.controller.request.AddCommentRequest;
import com.technology.apigateway.controller.request.ChangePasswordRequest;
import com.technology.apigateway.controller.request.CustomerRequest;
import com.technology.apigateway.controller.request.GetCustomerRequest;
import com.technology.apigateway.controller.request.GetIncomeCustomerByIdAndIncomeType;
import com.technology.apigateway.controller.response.BaseResponse;
import com.technology.apigateway.database.entity.ChangePassword;
import com.technology.apigateway.database.repository.AddCommentRepository;
import com.technology.apigateway.database.repository.ChangePasswordRepository;
import com.technology.apigateway.database.repository.CommentRepository;
import com.technology.apigateway.database.repository.PayTypeRepository;
import com.technology.apigateway.exception.BusinessException;
import com.technology.apigateway.runner.DataLoader;
import com.technology.apigateway.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController extends BaseResponse {

    CustomerService customerService;

    PayTypeRepository payTypeRepository;

    AddCommentRepository addCommentRepository;

    CommentRepository commentRepository;

    ChangePasswordRepository passwordRepository;

    @GetMapping("get-all-customer")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllCustomer(HttpServletRequest httpServletRequest) {
        return response(toResult(customerService.getAllCustomer()));
    }

    @PostMapping("get-customer-where")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getCustomerWhere(HttpServletRequest httpServletRequest,
                                              @RequestBody GetCustomerRequest request) {
        return response(toResult(customerService.getCustomerWhere(request)));
    }

    @PostMapping("get-customer-incomes")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getCustomerIncomes(HttpServletRequest httpServletRequest,
                                                @RequestBody GetCustomerRequest request) {
        return response(toResult(customerService.getIncomesByUserId(request)));
    }

    @PostMapping("get-income-customer-by-id-and-incomeType")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getCustomerByIdAndIncomeType(HttpServletRequest httpServletRequest,
                                                          @RequestBody GetIncomeCustomerByIdAndIncomeType request) {
        return response(toResult(customerService.getCustomerByIdAndIncomeType(request)));
    }

    @PostMapping("get-customer-guardians")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getCustomerGuardians(HttpServletRequest httpServletRequest,
                                                  @RequestBody GetCustomerRequest request) {
        return response(toResult(customerService.getGuardiansByUserId(request)));
    }

    @PostMapping("get-customer-references")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getCustomerReferences(HttpServletRequest httpServletRequest,
                                                   @RequestBody GetCustomerRequest request) {
        return response(toResult(customerService.getReferencesByUserId(request)));
    }

    @PostMapping("get-customer-references-by-regId")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getCustomerReferencesByRegId(HttpServletRequest httpServletRequest,
                                                          @RequestBody GetCustomerRequest request) {
        return response(toResult(customerService.getReferencesByRegId(request)));
    }

    @PostMapping("create-customer")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createCustomer(HttpServletRequest httpServletRequest,
                                            @RequestBody @Valid CustomerRequest customerRequest) {
        return response(toResult(customerService.createCustomer(customerRequest)));
    }

    @PostMapping("update-customer")
    @Transactional(readOnly = true)
    public ResponseEntity<?> updateCustomer(HttpServletRequest httpServletRequest,
                                            @RequestBody CustomerRequest customerRequest) {
        return response(toResult(customerService.updateCustomer(customerRequest)));
    }

    @GetMapping("get-user-scoring/{userId}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getUserScoring(HttpServletRequest httpServletRequest, @PathVariable int userId) {
        return response(toResult(customerService.getScoring(userId)));
    }

    @GetMapping("get-user-scoring-cal/{userId}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getUserScoringCal(HttpServletRequest httpServletRequest, @PathVariable int userId) {
        return response(toResult(customerService.getScoringCal(userId)));
    }

    @GetMapping("get-same-assets/{userId}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getSameAssets(HttpServletRequest httpServletRequest, @PathVariable int userId) {
        return response(toResult(customerService.getSameAssets(userId)));
    }

    @GetMapping("get-paytype-by-id/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getPayTypeByLoanType(HttpServletRequest httpServletRequest, @PathVariable int id) {
        return response(toResult(DataLoader.mapAllCode.get(id + "PAYTYPE").getName()));
    }


    @GetMapping("get-all-paytypeconf")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getPayTypeByLoanType(HttpServletRequest httpServletRequest) {

        return response(toResult(payTypeRepository.findAll()));
    }


    @PostMapping("add-comment")
    @Transactional(readOnly = true)
    public ResponseEntity<?> addComment(HttpServletRequest httpServletRequest,
                                        @RequestBody AddCommentRequest request) {

        return response(toResult(
                addCommentRepository.addComment(request.getUserId(), request.getLoanRegId(), request.getComment())));
    }

    @GetMapping("get-all-comment/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getComment(HttpServletRequest httpServletRequest, @PathVariable Integer id) {

        return response(toResult(commentRepository.getAllCommentByLoanRegId(id)));
    }

    @GetMapping("get-all-customer-balance")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getAllCustomerBalance(HttpServletRequest httpServletRequest) {

        return response(toResult(customerService.getListCustomerBalance()));
    }


    @PostMapping("change-password")
    @Transactional(readOnly = true)
    public ResponseEntity<?> changePassword(HttpServletRequest httpServletRequest,
                                            @RequestBody ChangePasswordRequest request) {

        ChangePassword res = passwordRepository.changePassword(request.getUserId(), request.getCurrentPassword(),
                request.getNewPassword(), request.getConfirmNewPassword());

        if (!res.getStatus().equals("01")) {
            throw new BusinessException(Constants.ERROR, res.getDescription());
        }

        return response(toResult(res));
    }

    @GetMapping("get-list-transaction")
    @Transactional(readOnly = true)
    public ResponseEntity<?> getListTransaction(HttpServletRequest httpServletRequest) {

        return response(toResult(customerService.getListTransaction()));
    }

}
