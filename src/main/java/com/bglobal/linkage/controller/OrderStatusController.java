package com.bglobal.linkage.controller;

import com.bglobal.linkage.DTO.OrderStatusDTO;
import com.bglobal.linkage.entity.OrderStatus;
import com.bglobal.linkage.service.OrderStatusService;
import com.bglobal.linkage.service.ShopMappingService;
import com.bglobal.linkage.support.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class OrderStatusController {
    @Autowired
    private OrderStatusService orderStatusService;
    @Autowired
    private ShopMappingService shopMappingService;

    @GetMapping("/order/status")
    public ResponseEntity<OrderStatusDTO> getOrderStatus(@RequestHeader("authorization") String token,
                                                         @RequestParam(name = "orderCode", required = false, defaultValue = "") String orderCode,
                                                         @RequestParam(name = "serviceId", required = false, defaultValue = "") String serviceId,
                                                         @RequestParam(name = "shopCode", required = false, defaultValue = "") String shopCode,
                                                         HttpServletRequest request) {
//        if (!Authorization.checkToken(token, request)) {
//            return ResponseEntity.status(401).build();
//        }
        Integer shopId  = shopMappingService.getShopIdByShopCode(shopCode);

        OrderStatus orderStatus;
        if (shopId == null || serviceId == null) orderStatus = orderStatusService.getOrderStatus(orderCode);
        else orderStatus = orderStatusService.getOrderStatus(orderCode, serviceId, shopId);

        if (orderStatus == null) {
            return ResponseEntity.status(404).build();
        }

        OrderStatusDTO orderStatusDTO = new OrderStatusDTO(orderStatus);
        return ResponseEntity.ok(orderStatusDTO);
    }
}
