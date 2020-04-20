package org.java.insurance.web;

import org.java.insurance.service.Type_of_insuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private Type_of_insuranceService type_of_insuranceService;

    @RequestMapping("/getType")
    @ResponseBody
    public List getGoodsTypeList() {
        List goodsTypeList = type_of_insuranceService.findAll();
        return goodsTypeList;
    }
}
