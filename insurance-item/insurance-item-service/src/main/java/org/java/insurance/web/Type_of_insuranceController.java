package org.java.insurance.web;

import org.java.insurance.entity.Type_of_insurance;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.Type_of_insuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Type_of_insurance")
public class Type_of_insuranceController {
    @Autowired
    private Type_of_insuranceService type_of_insuranceService;

    @GetMapping("/list")
    public ResponseEntity<PageResult<Type_of_insurance>> loadItem(@RequestParam("insurance_id") String pid){
        PageResult<Type_of_insurance> list=type_of_insuranceService.findById(pid);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
