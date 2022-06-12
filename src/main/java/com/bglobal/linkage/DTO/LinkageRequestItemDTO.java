package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkageRequestItemDTO {
    private Integer id;
    private String uid;
    private Integer state;
    private Integer ownerId;
    private String name;
    private String description;
    private Integer createdUserId;
    private String commonCode;
    private Integer shopId;
    private Integer created;
    private Integer modified;
    private Integer sortOrder;
    private Integer stock;
    private Integer itemDetailId;
    private String detail;
    private String categoryCode;
    private String itemDetailCode;
    private Boolean taxInclusiveF;
    private Double price;
    private Double priceTaxIn;
    private Double tax;
}
