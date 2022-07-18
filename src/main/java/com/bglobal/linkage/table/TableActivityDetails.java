package com.bglobal.linkage.table;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@Setter
public class TableActivityDetails {
    private Integer man;
    private Integer woman;
    private Integer discount;
    private List<String> coupons;
    private Boolean total;
    private Boolean printErr;
    private String customerId;
    private String customerName;
    private Integer discountType;
    private Integer discountPrice;
    private Integer serviceCharge;
    private Integer lateNightCharge;
    private String serviceType;
    private String vendorOrderId;
    private String vendorService;
    private Integer paymentStatus;
    private Boolean isPrintErr;
    private List<Integer> isPrintOrders;
    private String commentOrders;
    private String orderTime;
    private String deliveryTime;
    private List<Integer> syncOrders;
}
