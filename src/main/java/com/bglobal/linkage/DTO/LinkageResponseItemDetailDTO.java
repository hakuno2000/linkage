package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkageResponseItemDetailDTO {
    private String itemDetailCode;
    private String name;
    private Integer state;
    private Integer sortOrder;
    private Integer created;
    private Integer modified;

    public LinkageResponseItemDetailDTO(LinkageRequestItemDetailDTO itemDetail) {
        this.itemDetailCode = itemDetail.getItemDetailCode();
        this.name = itemDetail.getName();
        this.state = itemDetail.getState();
        this.sortOrder = itemDetail.getSortOrder();
        this.created = itemDetail.getCreated();
        this.modified = itemDetail.getModified();
    }
}
