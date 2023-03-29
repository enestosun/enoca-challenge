package com.tosun.loginsystem.user.repo;

import com.tosun.loginsystem.user.converter.UserConverter;
import com.tosun.loginsystem.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository <User,Long> {

    @Query("select user from User user")
    List<User > getAllUser();

    User findByUserNameAndUserPassword(String userName,String userPassword);

    @Query("select user.userName as userName from User user " +
            "left join user.userType usertype where usertype.userTypeId=:userTypeId")
    List<UserConverter> getAllUserByUserTypeId(@Param("userTypeId") Long userTypeId);

}
