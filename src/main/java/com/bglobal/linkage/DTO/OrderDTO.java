package com.bglobal.linkage.DTO;

import java.util.List;

public class OrderDTO {
    private String orderCode;
    private String serviceId;
    private String serviceType;
    private String shopCode;
    private String comment;
    private String requestId;
    private String transactionId;
    private Integer state;
    private Integer subtotal;
    private Integer total;
    private String tableCode;
    private String tableActivityCode;
    private Integer discountType;
    private Integer discountPercent;
    private Integer discountValue;
    private Integer customerNumber;
    private Customer customer;
    private List<OrderDetail> orderDetails;

    public class Customer {
        private String customerCode;
        private String name;
        private String phone;
        private String email;
    }

    public class OrderDetail {
        private String orderDetailCode;
        private String itemCode;
        private String itemName;
        private Integer orderNumber;
        private Integer price;
        private Integer priceTaxIn;
        private String comment;
        private Integer discountValue;
        private Integer discountPercent;
        private Integer discountType;
        private Double tax;
        private Integer subtotal;
        private Integer total;
        private List<ItemDetailContent> itemDetailContents;

        public class ItemDetailContent {
            private String comment;
            private Integer discountPercent;
            private Integer discountType;
            private Integer discountValue;
            private String itemDetailContentCode;
            private String itemName;
            private String orderDetailCode;
            private Integer orderNumber;
            private Integer price;
            private Integer priceTaxIn;
            private Integer subtotal;
            private Double tax;
            private Integer total;
        }
    }
}
