package com.bglobal.linkage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "lk_transaction_status")
public class TransactionStatus {
    @Id
    private Integer id;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "log")
    private String log;

    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "state")
    private Integer state;

    @Column(name = "created")
    private Integer created;

    @Column(name = "modified")
    private Integer modified;
}
