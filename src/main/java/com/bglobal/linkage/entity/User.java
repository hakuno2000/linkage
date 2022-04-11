package com.bglobal.linkage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

@Getter
@Setter
@Entity(name = "lk_user")
public class User {
    @Id
    private String id;

    @Column(name = "created")
    private BigInteger created;

    @Column(name = "modified")
    private BigInteger modified;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "state")
    private Integer state;

    @Column(name = "username")
    private String username;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service service;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserRole> userRoles;
}
