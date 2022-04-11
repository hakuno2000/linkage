package com.bglobal.linkage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Getter
@Setter
@Entity(name = "lk_queue")
public class Queue {
    @Id
    private String id;

    @Column(name = "common_code")
    private String commonCode;

    @Column(name = "created")
    private BigInteger created;

    @Column(name = "log")
    private String log;

    @Column(name = "modified")
    private BigInteger modified;

    @Column(name = "owner_code")
    private String ownerCode;

    @Column(name = "retry")
    private Integer retry;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "shop_code")
    private String shopCode;

    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "job_detail")
    private String jobDetail;

    @Column(name = "transfer")
    private Integer transfer;

    @Column(name = "trigger_detail")
    private String triggerDetail;
}
