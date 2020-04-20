package org.java.insurance.web;

import org.java.insurance.service.Data_dictionaryService;
import org.java.insurance.service.impl.Data_dictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Date_dictionary")
public class Date_dictionaryController {

    @Autowired
    private Data_dictionaryService data_dictionaryService;

    @RequestMapping("/getType")
    @ResponseBody
    public List getGoodsTypeList() {
        List goodsTypeList = data_dictionaryService.findAll();
        return goodsTypeList;
    }
}
