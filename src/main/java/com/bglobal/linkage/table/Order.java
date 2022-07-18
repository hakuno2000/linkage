package com.bglobal.linkage.table;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Order {
    private Integer status;
    private Integer created;
    private Integer modified;
    private Integer state;
    private String uid;
    private Integer id;
    private String orderCode;
    private String shopCode;
    private Integer shopId;
    private String staffName;
    private Integer tableActivityId;
    private Integer staffId;
    private Integer parentId;
}
