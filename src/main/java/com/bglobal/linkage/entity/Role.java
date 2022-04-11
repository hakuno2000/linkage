package com.bglobal.linkage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Getter
@Setter
@Entity(name = "lk_role")
public class Role {
    @Id
    private String id;

    @Column(name = "created")
    private BigInteger created;

    @Column(name = "modified")
    private BigInteger modified;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private Integer state;
}
