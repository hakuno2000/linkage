package com.bglobal.linkage.controller;

import com.bglobal.linkage.DTO.OrderDTO;
import com.bglobal.linkage.DTO.OrderResponseDTO;
import com.bglobal.linkage.entity.OrderStatus;
import com.bglobal.linkage.service.OrderStatusService;
import com.bglobal.linkage.service.ShopMappingService;
import com.bglobal.linkage.support.Authorization;
import com.bglobal.linkage.support.RandomUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private ShopMappingService shopMappingService;
    @Autowired
    private OrderStatusService orderStatusService;

    @PostMapping("/order/create")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestHeader("authorization") String token,
                                                        @RequestBody OrderDTO orderDTO,
                                                        HttpServletRequest request) {
//        if (!Authorization.checkToken(token, request)) {
//            return ResponseEntity.status(401).build();
//        }

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(RandomUUID.generate());
        orderStatus.setCreated(BigInteger.valueOf(System.currentTimeMillis() / 1000));
        orderStatus.setLog("");
        orderStatus.setModified(BigInteger.valueOf(0));
        orderStatus.setOrderCode(orderDTO.getOrderCode());
        orderStatus.setRetry(0);
        orderStatus.setServiceId(orderDTO.getServiceId());
        orderStatus.setShopId(shopMappingService.getShopIdByShopCode(orderDTO.getShopCode()));
        orderStatus.setState(orderDTO.getState());
        orderStatus.setStatus(1);
        orderStatus.setPaymentStatus(0);
        orderStatus.setServiceType(Integer.valueOf(orderDTO.getServiceType()));
        orderStatus.setTableActivityCode(orderDTO.getTableActivityCode());

        orderStatusService.save(orderStatus);

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrderCode(orderStatus.getOrderCode());

        return ResponseEntity.ok(orderResponseDTO);
    }
}
