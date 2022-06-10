package com.bglobal.linkage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "ls_shop_mapping")
public class ShopMapping {
    @Id
    private Integer id;

    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "owner_id")
    private Integer ownerId;

    @Column(name = "common_code")
    private String commonCode;

    @Column(name = "name")
    private String name;

    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "created")
    private String created;

    @Column(name = "modified")
    private String modified;
}
