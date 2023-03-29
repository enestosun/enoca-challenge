package com.tosun.loginsystem.usertype.service.UserService;


import com.tosun.loginsystem.usertype.entity.UserType;

import java.util.List;

public interface UserTypeService {
    List<UserType> getAllUsertype();

    UserType save(UserType userType);

    void deleteUserType(Long userTypeId);


}
