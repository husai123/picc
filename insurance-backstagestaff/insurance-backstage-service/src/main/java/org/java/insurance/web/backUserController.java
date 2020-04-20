package org.java.insurance.web;

import org.java.insurance.entity.employee;
import org.java.insurance.entity.permission;
import org.java.insurance.entity.policy;
import org.java.insurance.service.backUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/backstage")
@RestController
public class backUserController {
    @Autowired
    private backUserService backUserService;

    @GetMapping("/queryBackstageById/{id}")
    public ResponseEntity<employee> queryBackstageById(@PathVariable("id") String id){

        employee customer = backUserService.querybackstageById(id);

        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }
    @GetMapping("/querypermissionById/{id}")
    public ResponseEntity<permission> querypermissionById(@PathVariable("id") String id){
        permission permission = backUserService.querypermissionById(id);
        return ResponseEntity.status(HttpStatus.OK).body(permission);
    }
    @GetMapping("/selectone")
    public ResponseEntity<List<policy>> selectone(){
        List<policy> list = backUserService.selectone();
        System.out.println(list);
        return ResponseEntity.ok(list);
    }

}
