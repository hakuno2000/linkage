package com.bglobal.linkage.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigInteger;
import java.util.Set;

@Getter
@Setter
@Entity(name = "lk_login_type")
public class LoginType {
    @Id
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "state")
    private Integer state;

    @Column(name = "created")
    private BigInteger created;

    @Column(name = "modified")
    private BigInteger modified;

    @JsonManagedReference
    @OneToMany(mappedBy = "loginType")
    private Set<UserLoginType> userLoginTypes;
}
