package com.tosun.loginsystem.user.service.UserService;

import com.tosun.loginsystem.user.converter.UserConverter;
import com.tosun.loginsystem.user.dto.UserDto;

import java.util.List;


public interface UserService {


    List<UserDto> getAllUser();

    UserDto saveUser(UserDto user);

    UserDto loginControl(UserDto userDto);

    Boolean deleteUserById(Long userId);

    Boolean findByUserId(Long userId);

    boolean setUserById(UserDto userDto);

    List<UserConverter> getAllUserByUserTypeId(Long userTypeId);


}
