package com.tosun.loginsystem.user.service;

import com.tosun.loginsystem.user.converter.UserConverter;
import com.tosun.loginsystem.user.dto.UserDto;
import com.tosun.loginsystem.user.entity.User;
import com.tosun.loginsystem.user.repo.UserRepo;
import com.tosun.loginsystem.user.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<UserDto> getAllUser() {
        List<User> allUser = userRepo.getAllUser();
        List<UserDto> userDtoList = new ArrayList<UserDto>();

        for (User user : allUser) {

            UserDto userDto = new UserDto();
            userDto.setUserName(user.getUserName());
            userDto.setActive(user.isActive());
            userDto.setUserType(user.getUserType());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public UserDto saveUser(UserDto userdto) {

        User user = new User();
        user.setUserName(userdto.getUserName());
        user.setUserPassword(userdto.getUserPassword());
        user.setActive(userdto.isActive());
        user.setUserType(userdto.getUserType());
        User savedUser = userRepo.save(user);

        UserDto savedUserTypeDto = new UserDto();
        savedUserTypeDto.setUserName(savedUser.getUserName());
        savedUserTypeDto.setActive(savedUser.isActive());

        return savedUserTypeDto;
    }

    @Override
    public UserDto loginControl(UserDto userDto) {

        User byUserNameAndUserPassword = userRepo.findByUserNameAndUserPassword(userDto.getUserName(),
                userDto.getUserPassword());
        UserDto savedUser = new UserDto();

        if (byUserNameAndUserPassword.getUserId() > 0) {
            savedUser.setUserType(byUserNameAndUserPassword.getUserType());
            savedUser.setUserName(byUserNameAndUserPassword.getUserName());
            return savedUser;
        }
        return savedUser;
    }

    @Override
    public Boolean deleteUserById(Long userId) {
        userRepo.deleteById(userId);
        Optional<User> userById = userRepo.findById(userId);
        if (userById.isEmpty())
            return true;
        return false;
    }

    @Override
    public Boolean findByUserId(Long userId) {
        Optional<User> byUserId = userRepo.findById(userId);
        if (byUserId.isPresent())
            return true;
        return false;
    }

    @Override
    public boolean setUserById(UserDto userDto) {
        Optional<User> byId = userRepo.findById(userDto.getUserId());
        if (byId.isEmpty())
            return false;

        User user = new User(userDto.getUserId(), userDto.getUserName(), userDto.getUserPassword(), userDto.isActive(), userDto.getUserType());
        User setUser = userRepo.save(user);
        Optional<User> optionalUser = Optional.of(setUser);
        if (optionalUser.isPresent())
            return true;
        return false;
    }

    @Override
    public List<UserConverter> getAllUserByUserTypeId(Long userTypeId) {
        List<UserConverter> userName = userRepo.getAllUserByUserTypeId(userTypeId);
        return userName;
    }

}
