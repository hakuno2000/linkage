package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkageRequestItemDetailContentDTO {
    private Integer id;
    private String uid;
    private Integer state;
    private String itemCode;
    private String name;
    private Double price;
    private Double priceTaxIn;
    private String itemDetailContentCode;
    private String itemDetailCode;
    private Integer shopId;
    private Integer created;
    private Integer modified;
    private Integer sortOrder;
}
