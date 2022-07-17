package com.bglobal.linkage.service;

import com.bglobal.linkage.entity.OrderStatus;

public interface OrderStatusService {
    OrderStatus getOrderStatus(String orderCode, String serviceId, Integer shopId);
    OrderStatus getOrderStatus(String orderCode);
    OrderStatus save(OrderStatus orderStatus);
}
