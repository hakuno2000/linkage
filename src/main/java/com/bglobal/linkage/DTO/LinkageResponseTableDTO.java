package com.bglobal.linkage.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkageResponseTableDTO {
    private String tableCode;
    private String description;
    private String name;
    private Integer sortOrder;
    private Integer state;
    private Integer created;
    private Integer modified;

    public LinkageResponseTableDTO(LinkageRequestTableDTO table) {
        this.tableCode = table.getCommonCode();
        this.description = table.getDescription();
        this.name = table.getName();
        this.sortOrder = table.getSortOrder();
        this.state = table.getState();
        this.created = table.getCreated();
        this.modified = table.getModified();
    }
}
