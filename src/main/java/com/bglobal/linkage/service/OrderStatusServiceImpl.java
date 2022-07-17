package com.bglobal.linkage.service;

import com.bglobal.linkage.entity.OrderStatus;
import com.bglobal.linkage.repo.OrderStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    @Autowired
    private OrderStatusRepo orderStatusRepo;

    @Override
    public OrderStatus getOrderStatus(String orderCode, String serviceId, Integer shopId) {
        return orderStatusRepo.findFirstByOrderCodeAndServiceIdAndShopId(orderCode, serviceId, shopId);
    }

    @Override
    public OrderStatus getOrderStatus(String orderCode) {
        return orderStatusRepo.findFirstByOrderCode(orderCode);
    }
}
