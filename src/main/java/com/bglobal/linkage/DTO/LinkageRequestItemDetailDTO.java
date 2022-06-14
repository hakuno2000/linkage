package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkageRequestItemDetailDTO {
    private Integer id;
    private Integer state;
    private String name;
    private String itemDetailCode;
    private Integer shopId;
    private Integer created;
    private Integer modified;
    private Integer sortOrder;
}
