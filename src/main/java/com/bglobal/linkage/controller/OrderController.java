package com.bglobal.linkage.controller;

import com.bglobal.linkage.DTO.OrderResponseDTO;
import com.bglobal.linkage.support.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class OrderController {
    @PostMapping("/order/create")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestHeader("authorization") String token,
                                                        @RequestParam(name = "categoryCode", required = false, defaultValue = "") String categoryCode,
                                                        @RequestParam(name = "shopCode", required = false, defaultValue = "277_404") String shopCode,
                                                        @RequestParam(name = "categoryState", required = false, defaultValue = "1") Integer categoryState,
                                                        HttpServletRequest request) {
//        if (!Authorization.checkToken(token, request)) {
//            return ResponseEntity.status(401).build();
//        }

        return ResponseEntity.ok(new OrderResponseDTO());
    }
}
