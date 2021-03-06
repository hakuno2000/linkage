package com.bglobal.linkage.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "lk_service")
public class Service {
    @Id
    private String id;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "created")
    private BigInteger created;

    @Column(name = "modified")
    private BigInteger modified;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private Integer state;

    @JsonManagedReference
    @OneToMany(mappedBy = "service")
    private List<User> users;

    @ManyToMany
    @JoinTable(name = "lk_service_scope",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "scope_id"))
    private List<Scope> scopes;
}
