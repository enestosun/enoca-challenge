package com.tosun.loginsystem.usertype.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTypeDto {

    private Long userTypeId;
    private String userTypeName;
}
