package com.bglobal.linkage.entity;

import com.bglobal.linkage.support.UserLoginTypeId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "lk_user_login_type")
public class UserLoginType {
    @EmbeddedId
    private UserLoginTypeId id;

    @JsonBackReference
    @ManyToOne
    @MapsId("loginTypeId")
    @JoinColumn(name = "login_type_id", referencedColumnName = "id")
    private LoginType loginType;
}
