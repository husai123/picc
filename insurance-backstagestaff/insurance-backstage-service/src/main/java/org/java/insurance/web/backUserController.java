package org.java.insurance.web;

import org.java.insurance.entity.backUser;
import org.java.insurance.entity.permission;
import org.java.insurance.service.backUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/backstage")
@RestController
public class backUserController {
    @Autowired
    private backUserService backUserService;

    @GetMapping("/queryBackstageById/{id}")
    public ResponseEntity<backUser> queryBackstageById(@PathVariable("id") Long id){

        backUser customer = backUserService.querybackstageById(id);

        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }
    @GetMapping("/querypermissionById/{id}")
    public ResponseEntity<permission> querypermissionById(@PathVariable("id") Long id){
        permission permission = backUserService.querypermissionById(id);
        return ResponseEntity.status(HttpStatus.OK).body(permission);
    }
}
