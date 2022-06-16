package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ShopDTO {
    private Integer id;
    private Integer ownerId;
    private String name;
    private String details;
    private Integer serviceId;
    private String commonCode;
    private Integer shopId;
    private Integer created;
    private Integer modified;
}
