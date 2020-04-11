package org.java.order.web;

import org.java.insurance.ov.PageResult;
import org.java.order.service.Type_Of_InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 险种控制器层
 */
@RestController
@RequestMapping("/type_of_insurance")
public class Type_Of_InsuranceController {

    @Autowired
    private Type_Of_InsuranceService typeOfInsuranceService;

    @GetMapping("/query")
    public ResponseEntity<PageResult> query(){
        return ResponseEntity.ok(typeOfInsuranceService.findAll());
    }



}
