package com.tosun.loginsystem.usertype.service;

import com.tosun.loginsystem.usertype.entity.UserType;
import com.tosun.loginsystem.usertype.repo.UserTypeRepo;
import com.tosun.loginsystem.usertype.service.UserService.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImp implements UserTypeService {

    @Autowired
    private UserTypeRepo userTypeRepo;


    public List<UserType> getAllUsertype() {
        return userTypeRepo.findAll();
    }

    public  UserType save(UserType userType){
        return userTypeRepo.save(userType);
    }

    public void deleteUserType(Long userTypeId){
         userTypeRepo.deleteById(userTypeId);
    }

}
