package org.java.insurance.web;

import org.java.insurance.entity.Comprehensive_adjustment_verify;
import org.java.insurance.ov.PageResult;
import org.java.insurance.service.Comprehensive_adjustment_verifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Comprehensive_adjustmentVerify")
@RestController
public class Comprehensive_adjustment_verifyController {
    @Autowired
    private Comprehensive_adjustment_verifyService vertifyService;

    @GetMapping("/list")
    public ResponseEntity<PageResult<Comprehensive_adjustment_verify>> loadItem(Integer page, Integer limit){
        PageResult<Comprehensive_adjustment_verify>  pageResult=vertifyService.findAll(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }

    @GetMapping("/list2")
    public ResponseEntity<PageResult<Comprehensive_adjustment_verify>> loadItem2(Integer page, Integer limit){
        PageResult<Comprehensive_adjustment_verify>  pageResult=vertifyService.findAll2(page,limit);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }

    @GetMapping("/settlement")
    public ResponseEntity<Void> updateItem(@RequestParam("verify_id") String pid){
        vertifyService.settlementItem(pid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/closing")
    public ResponseEntity<Void> updateItem2(@RequestParam("verify_id") String pid){
        vertifyService.ClosingItem(pid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
