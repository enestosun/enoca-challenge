package com.tosun.loginsystem.usertype.repo;

import com.tosun.loginsystem.usertype.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepo extends JpaRepository <UserType,Long> {


}
