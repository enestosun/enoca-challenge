package com.tosun.loginsystem.user.rest;


import com.tosun.loginsystem.user.converter.UserConverter;
import com.tosun.loginsystem.user.dto.UserDto;
import com.tosun.loginsystem.user.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
   private UserServiceImp userService;


    @GetMapping(path = "/login")
    public ResponseEntity loginControl(@RequestBody UserDto userDto) {
        UserDto loginControl = userService.loginControl(userDto);
        return ResponseEntity.ok(loginControl);
    }

    @PostMapping(path = "/save")
    public ResponseEntity saveUser(@RequestBody UserDto userDto) {
        UserDto userConvertor = userService.saveUser(userDto);
        return ResponseEntity.ok(userConvertor);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity getAllUser() {
        List<UserDto> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping(path = "/find/{userId}")
    public ResponseEntity findByUserId(@PathVariable Long userId) {
        return null;
    }


    @PutMapping(path = "/set")
    public ResponseEntity setUserById(@RequestBody UserDto userDto) {
        boolean status = userService.setUserById(userDto);
        return ResponseEntity.ok(status);

    }


    @GetMapping(path = "/getbyrole/{userTypeId}")
    public ResponseEntity getAllByUserTypeId(@PathVariable Long userTypeId) {
        List<UserConverter> allUserByUserTypeId = userService.getAllUserByUserTypeId(userTypeId);
        return ResponseEntity.ok(allUserByUserTypeId);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public ResponseEntity deleteByUserId(@PathVariable Long userId) {
        Boolean status = userService.deleteUserById(userId);
        return ResponseEntity.ok(status);
    }
}