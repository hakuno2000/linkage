package com.bglobal.linkage.repo;

import com.bglobal.linkage.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepo extends JpaRepository<OrderStatus, String> {
    OrderStatus findFirstByOrderCodeAndServiceIdAndShopId(String orderCode, String serviceId, Integer shopId);
    OrderStatus findFirstByOrderCode(String orderCode);
}
