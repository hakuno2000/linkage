package com.bglobal.linkage.DTO;

import com.bglobal.linkage.entity.OrderStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderStatusDTO {
    private String orderCode;
    private Integer serviceType;
    private Integer orderStatus;
    private Integer paymentStatus;
    private Integer state;
    private BigInteger created;
    private BigInteger modified;

    public OrderStatusDTO(OrderStatus orderStatus) {
        this.orderCode = orderStatus.getOrderCode();
        this.serviceType = orderStatus.getServiceType();
        this.orderStatus = orderStatus.getStatus();
        this.paymentStatus = orderStatus.getPaymentStatus();
        this.state = orderStatus.getState();
        this.created = orderStatus.getCreated();
        this.modified = orderStatus.getModified();
    }
}
