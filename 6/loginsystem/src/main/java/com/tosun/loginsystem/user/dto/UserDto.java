package com.tosun.loginsystem.user.dto;

import com.tosun.loginsystem.usertype.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private String userName;
    private String userPassword;
    private boolean active;
    private UserType userType;

    @Override
    public String toString() {

        return "UserDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", active=" + active +
                ", userType=" + userType +
                '}';
    }
}
