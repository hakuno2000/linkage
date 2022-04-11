package com.bglobal.linkage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Getter
@Setter
@Entity(name = "lk_order_status")
public class OrderStatus {
    @Id
    private String id;

    @Column(name = "created")
    private BigInteger created;

    @Column(name = "log")
    private String log;

    @Column(name = "modified")
    private BigInteger modified;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "retry")
    private Integer retry;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "state")
    private Integer state;

    @Column(name = "status")
    private Integer status;

    @Column(name = "payment_status")
    private Integer paymentStatus;

    @Column(name = "service_type")
    private Integer serviceType;

    @Column(name = "table_activity_code")
    private String tableActivityCode;
}
