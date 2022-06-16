package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkageRequestTableActivityDTO {
    private String uid;
    private Integer total;
    private Integer subtotal;
    private Integer modified;
    private Integer discount;
    private Integer id;
    private Integer price;
    private String details;
    private Double tax;
    private Integer created;
    private String orderDetailCode;
    private String orderCode;
    private Integer discountValue;
    private Integer discountPercent;
    private String itemCode;
    private String parentOrderDetailCode;
    private Integer orderNumber;
    private Integer priceTaxIn;
    private Integer orderId;
    private String itemName;
    private Integer itemId;
    private Integer discountType;
    private Integer discountPrice;
    private Integer parentId;
    private Boolean taxInclusiveF;
}
