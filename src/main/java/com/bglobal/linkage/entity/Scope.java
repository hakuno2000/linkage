package com.bglobal.linkage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "lk_scope")
public class Scope {
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

    @ManyToMany(mappedBy = "scopes")
    private List<Service> services;
}
