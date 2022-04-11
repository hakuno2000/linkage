package com.bglobal.linkage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "lk_payment_status")
public class PaymentStatus {
    @Id
    private Integer id;

    @Column(name = "payment_code")
    private String paymentCode;

    @Column(name = "log")
    private String log;

    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "retry")
    private Integer retry;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "state")
    private Integer state;

    @Column(name = "create")
    private Integer create;

    @Column(name = "modified")
    private Integer modified;
}
