package com.tosun.loginsystem.usertype.rest;


import com.tosun.loginsystem.usertype.entity.UserType;
import com.tosun.loginsystem.usertype.service.UserTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usertype")
@CrossOrigin(origins = "*")
public class UserTypeControl {

    @Autowired
   private UserTypeServiceImp userTypeService;


    @GetMapping(path = "/get")
    public ResponseEntity getAllUserType(){
       List<UserType> allUserType= userTypeService.getAllUsertype();
       return ResponseEntity.ok(allUserType);
    }

    @PostMapping(path = "/save")
    public ResponseEntity saveUserType(@RequestBody UserType userType){
         return ResponseEntity.ok( userTypeService.save(userType));
    }
    @DeleteMapping(path = "/delete/{id}")
    public void   deleteUserType(@PathVariable Long id){
        userTypeService.deleteUserType(id);
    }

}