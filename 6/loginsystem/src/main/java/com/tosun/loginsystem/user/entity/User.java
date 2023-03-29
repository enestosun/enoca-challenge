package com.tosun.loginsystem.user.entity;

import com.tosun.loginsystem.usertype.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Data//getset
@NoArgsConstructor//const
@AllArgsConstructor
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String userName;

    private String userPassword;

    private boolean active;

    @JoinColumn(name = "userTypeId")
    @ManyToOne(fetch = FetchType.EAGER)
    @org.hibernate.annotations.ForeignKey(name = "fk_user_usertype")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserType userType;

}
