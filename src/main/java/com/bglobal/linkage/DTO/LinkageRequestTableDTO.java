package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkageRequestTableDTO {
    private Integer id;
    private String uid;
    private Integer state;
    private Integer ownerId;
    private String name;
    private String description;
    private Integer serviceId;
    private String commonCode;
    private Integer shopId;
    private Integer created;
    private Integer modified;
    private Integer sortOrder;
}
